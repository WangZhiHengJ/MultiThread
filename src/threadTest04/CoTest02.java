package threadTest04;


/**
 * @Auther: 王志恒
 * @Date: 2019/8/9 20:17
 * @Description: 按照自己想法写一遍
 * 协作模型：
 * 生产者消费者实现方式一：管程法
 */
public class CoTest02 {
    public static void main(String[] args) {
        Cangku cangku = new Cangku();
        new Shengchan(cangku).start();
        new Xiaofei(cangku).start();
    }
}

//生产者
class Shengchan extends Thread {
    Cangku cangku;

    public Shengchan(Cangku cangku) {
        this.cangku = cangku;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            cangku.push(new Shangpin(i));
            System.out.println("生产第" + i + "商品");
        }
    }
}

//消费者
class Xiaofei extends Thread {
    Cangku cangku;

    public Xiaofei(Cangku cangku) {
        this.cangku = cangku;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            int n = cangku.pop();
            System.out.println("消费第" + n + "商品");
        }
    }
}

/**
 * @author: 王志恒
 * @date: 2019/8/9 21:26
 * @Description： 仓库负责存储数据，生产和消费的沟通，也就是控制什么时候生产什么时候消费
 */
class Cangku {
    Shangpin[] shangpins = new Shangpin[10];
    int count = 0; //总数

    //生产
    public synchronized void push(Shangpin shangpin) {
        /**
         * @author: 王志恒
         * @date: 2019/8/9 21:29
         *解决两个问题，
         * 1、什么时候可以生产
         * 2、什么时候停止生产
         */
        //停止生产 仓库满了，停止生产
        if (count == shangpins.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        shangpins[count] = shangpin;
        //告诉消费者有商品了，可以消费
        count++;
        this.notifyAll();

    }

    //消费
    public synchronized int pop() {
        /**
         * @author: 王志恒
         * @date: 2019/8/9 21:29
         *解决两个问题，
         * 1、什么时候可以消费
         * 2、什么时候停止消费
         */
        //停止生产 仓库满了，停止生产
        if (count == 0) {
            try {
                //等待:会让出锁
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //告诉生产者，已经消费了。有位置了，可以生产。
        count--;
        int id = shangpins[count].getId();
        this.notifyAll();
        return id;
    }
}

class Shangpin {
    int id;

    public Shangpin(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}