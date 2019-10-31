package threadtest02;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/3 19:37
 * @Description:
 * 设置线程的优先级
 * 优先级高的获得调度的概率高一点，执行的时间片长一点。
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class PriorityTest {
    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"->>"+Thread.currentThread().getPriority());

        Mypriority mp = new Mypriority();

        @SuppressWarnings("AlibabaAvoidManuallyCreateThread") Thread t1 = new Thread(mp,"t1");
        @SuppressWarnings("AlibabaAvoidManuallyCreateThread") Thread t2 = new Thread(mp,"t2");
        @SuppressWarnings("AlibabaAvoidManuallyCreateThread") Thread t3 = new Thread(mp,"t3");
        @SuppressWarnings("AlibabaAvoidManuallyCreateThread") Thread t4 = new Thread(mp,"t4");
        @SuppressWarnings("AlibabaAvoidManuallyCreateThread") Thread t5 = new Thread(mp,"t5");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(3);
        t4.setPriority(9);
        t5.setPriority(6);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class Mypriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"->>"+Thread.currentThread().getPriority());
    }
}