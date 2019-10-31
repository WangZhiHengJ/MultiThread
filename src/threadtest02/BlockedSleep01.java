package threadtest02;

import threadTest01.Web12306;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/2 16:11
 * @Description:
 *sleep 模拟网络延时
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class BlockedSleep01 implements Runnable{
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