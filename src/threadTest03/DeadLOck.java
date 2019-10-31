package threadTest03;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/8 22:48
 * @Description: 死锁：过多的同步可能造成相互不释放资源
 * 从而互相等待，一般发生于同步中持有多个对象的锁
 */
public class DeadLOck {
    public static void main(String[] args) {
        Markup m1 = new Markup(0,"美美");
        Markup m2 = new Markup(1,"丫丫");

        m1.start();
        m2.start();

    }
}

//口红
class Lipstick {

}

//镜子
class Mirror {

}

class Markup extends Thread {
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    //选择
    int choice;
    //名字
    String girl;

    public Markup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;

    }

    @Override
    public void run() {
        //化妆
        markup();
    }

    //解锁死锁：不要在同一个锁内获取另一个锁对象
    private void markup() {
        if (choice == 0) {
            synchronized (lipstick) { //获得口红的锁
                System.out.println(this.girl + "获得口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (mirror) { //获得口红的锁
                System.out.println(this.girl + "获得镜子");
            }

        } else {

            synchronized (mirror) { //获得口红的锁
                System.out.println(this.girl + "获得镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lipstick) { //获得口红的锁
                System.out.println(this.girl + "获得口红");
            }


        }

    }
    /**  死锁
    private void markup() {
        if (choice == 0) {
            synchronized (lipstick) { //获得口红的锁
                System.out.println(this.girl + "获得口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) { //获得口红的锁
                    System.out.println(this.girl + "获得镜子");
                }
            }

        } else {

            synchronized (mirror) { //获得口红的锁
                System.out.println(this.girl + "获得镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick) { //获得口红的锁
                    System.out.println(this.girl + "获得口红");
                }
            }


        }

    }
     */
}