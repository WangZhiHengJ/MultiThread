package threadtest02;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/2 17:00
 * @Description: join 插队 ：当前线程立刻获得cpu调度
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class BlockedJoin02 {


    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {

        System.out.println("儿子买烟的故事");

        Father f = new Father();
        Son son = new Son();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(f).start();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(son).start();


    }
}

@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
class Father implements Runnable {
    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    @Override
    public void run() {
        System.out.println("老爸想抽烟,发现没烟了，让儿子去买烟");
        @SuppressWarnings("AlibabaAvoidManuallyCreateThread") Thread t = new Thread(new Son());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("儿子回来把烟交给了老爸，老爸很高兴。");
        System.out.println("买烟结束");
    }
}

class Son implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("走到路边,碰到一个游戏厅。进去玩了10秒");
            for (int j = 1; j <= 10; j++) {
                System.out.println(j);
                Thread.sleep(1000);
                if (j > 10) {
                    break;
                }
            }
            System.out.println("想起来还没买烟,赶紧去买");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}