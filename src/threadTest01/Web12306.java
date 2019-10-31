package threadTest01;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/30 23:16
 * @Description:
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class Web12306 implements Runnable {
    private int ticketNums = 99;

    @Override
    public void run() {
        while (true) {
            if (ticketNums < 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+">>>"+ticketNums--);
        }
    }

    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {
        Web12306 web = new Web12306();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(web,"牛1").start();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(web,"牛2").start();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(web,"牛3").start();

    }
}