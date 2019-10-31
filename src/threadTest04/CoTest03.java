package threadTest04;


import javafx.geometry.VPos;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/9 20:17
 * @Description: 按照自己想法写一遍
 * 协作模型：
 * 生产者消费者实现方式二：信号灯法
 */
public class CoTest03 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Audience(tv).start();
    }
}

//生产者 演员
class Player extends Thread {
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("奇葩说");
            } else {
                this.tv.play("广告");
            }
        }
    }
}

//消费者 观众
class Audience extends Thread {
    Tv tv;

    public Audience(Tv tv) {
        this.tv = tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
                this.tv.watch();
        }
    }
}
//数据仓库：电视
class Tv {
    String voice;
    boolean flag = true;
    //信号灯
    //T标识演员表演 观众等待
    //F 标识观众观看 演员等待

    //表演
    public synchronized void play(String voice) {

        if (!this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.voice = voice;
        System.out.println(voice);
        this.flag = !this.flag;
        this.notifyAll();
    }
    //观看
    public synchronized void watch() {
        if (this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众欣赏："+voice);
        this.flag = !this.flag;
        this.notifyAll();
    }
}

