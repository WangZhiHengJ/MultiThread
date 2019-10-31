package threadTest01;

import java.util.concurrent.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/30 23:40
 * @Description:
 * 多线程的第三种创建方式
 */
public class CRacer02 implements Callable<Integer> {
    private static String winner;

    @Override
    public Integer call() {
        for (int steps = 1; steps <= 100; steps++) {
            System.out.println(Thread.currentThread().getName()+">>>"+steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if (flag) {
                return steps;
            }
        }
        return null;
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CRacer02 racer = new CRacer02();
        CRacer02 racer2 = new CRacer02();
        //创建服务
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Integer> f1 = ser.submit(racer);
        Future<Integer> f2 = ser.submit(racer2);
        //接收结果
        f1.get();
        f2.get();
        ser.shutdownNow();
    }
}