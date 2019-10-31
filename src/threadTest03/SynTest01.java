package threadTest03;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/30 23:16
 * @Description: 线程安全：在并发时保证数据的正确性、效率尽可能的高
 * synchronized
 */

@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class SynTest01 implements Runnable {
    private int ticketNums = 10;
    private boolean flag = true;


    @Override
    public void run() {
        while (flag) {
            test();
        }
    }


    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {
        //一份资源
        SynTest01 web = new SynTest01();
        //多个代理
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(web, "牛1").start();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(web, "牛2").start();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(web, "牛3").start();

    }

    public synchronized void test() {

        //出现负数是由于主内存的值没有刷新，也就是大于0的时候另外两个线程通过了资源之前的所有判断，但是拿到资源的时候主内存的值已经刷新了
        //出现相同的数字是，主内存的值没有刷新，线程拿的都是同一份资源
            if (ticketNums <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ">>>" + ticketNums--);
    }


}