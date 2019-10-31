package threadtest02;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/2 16:40
 * @Description: 线程礼让 yield
 * 暂停线程，使当前线程直接从运行状态进入就绪状态
 *
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class YieldDemo01  {

    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {

        MyYield01 my = new MyYield01();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(my, "a").start();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(my, "b").start();

    }
}

class MyYield01 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->strat");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "-->end");
    }
}