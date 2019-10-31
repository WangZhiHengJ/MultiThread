package threadtest02;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/2 18:15
 * @Description:
 * 观察线程的状态
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class AllState {
    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {
        @SuppressWarnings("AlibabaAvoidManuallyCreateThread") Thread t = new Thread(()->{

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.yield();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(".....");
        });
        //观察状态
        Thread.State state = t.getState();
        System.out.println(state);

        t.start();
        state = t.getState();
        System.out.println(state);

        while (true) {
            //活动的线程数
            int num = Thread.activeCount();
            if (num == 1) {
                break;
            }
            System.out.println(num);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState();
            System.out.println(state);
        }
    }


}