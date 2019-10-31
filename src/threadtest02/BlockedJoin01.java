package threadtest02;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/2 17:00
 * @Description: join 插队 ：当前线程立刻获得cpu调度
 */
public class BlockedJoin01 {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("儿子买烟的故事");
        Thread son = new Thread(() -> {
            try {
                System.out.println("走到路边,碰到一个游戏厅。进去玩了10秒");
                for (int j = 1; j <= 10; j++) {
                    System.out.println(j);
                    TimeUnit.SECONDS.sleep(1);
                    Thread.sleep(1000);
                    if (j > 10) {
                        break;
                    }
                }
                System.out.println("想起来还没买烟,赶紧去买");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "son");

        Thread father = new Thread(() -> {
            System.out.println("老爸想抽烟,发现没烟了，让儿子去买烟");
            try {
                son.join();
                System.out.println("儿子回来把烟交给了老爸，老爸很高兴。");
                System.out.println("买烟结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "father");
        father.start();
        son.start();

    }
}

