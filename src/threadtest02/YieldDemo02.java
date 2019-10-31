package threadtest02;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/2 16:40
 * @Description: 线程礼让 yield
 * 暂停线程，使当前线程直接从运行状态进入就绪状态
 *
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class YieldDemo02  {

    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {

        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(()->{
            for (int i = 0; i < 100; i++) {

//                if (i % 10 == 0) {
//                    Thread.yield();//lambda yield
//                }
                System.out.println("lambda...");

            }
        }).start();

        for (int i = 0; i < 100; i++) {
            if (i % 20 == 0) {
                Thread.yield(); //main yield
            }
            System.out.println("main....."+i);
        }
    }
}

class MyYield02 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->strat");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "-->end");
    }
}