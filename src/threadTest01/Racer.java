package threadTest01;


/**
 * @Auther: 王志恒
 * @Date: 2019/7/30 23:40
 * @Description:
 */
public class Racer implements Runnable {
    private static String winner;
    @Override
    public void run() {
        for (int steps = 1; steps <= 100; steps++) {
            System.out.println(Thread.currentThread().getName()+">>>"+steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if (flag) {
                break;
            }
       }
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("》》》》》》》》》》》》》》》胜利："+winner);
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {
        Racer racer = new Racer();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(racer, "乌龟").start();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(racer, "兔子").start();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(racer, "裁判").start();
    }
}