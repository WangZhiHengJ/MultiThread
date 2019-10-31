package threadtest02;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/3 19:56
 * @Description:
 * 守护线程：是为用户线程服务的,jmv不用等待守护线程执行完毕.
 * 默认情况下所有的线程都是用户线程，jvm等待所有用户线程执行完毕才会停止运行
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class DemonTest {
    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {

        God god = new God();
        You you = new You();

        @SuppressWarnings("AlibabaAvoidManuallyCreateThread") Thread t = new Thread(god);
        t.setDaemon(true);
        t.start();

        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(you).start();
    }
}


class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("好幸福啊");
        }
        System.out.println("ooooo....");
    }
}


class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("一直存在....");
        }
    }
}