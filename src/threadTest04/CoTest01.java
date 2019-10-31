package threadTest04;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/9 20:17
 * @Description: 协作模型：
 * 生产者消费者实现方式一：管程法
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Production(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Production extends Thread {
    SynContainer container;

    public Production(SynContainer synContainer) {
        this.container = synContainer;
    }

    //开始生产
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("生产：第->" + i + "个馒头");
            container.push(new Steamedbun(i));
        }
    }
}

//消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    //开始消费
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("第-->" + container.pop() + "个馒头被消费");
        }
    }
}

//缓冲区：仓库
class SynContainer {
    Steamedbun[] buns = new Steamedbun[10];
    int count = 0;//计数器

    //存储生产
    public synchronized void push(Steamedbun bun) {
        /**
         *何时能生产：判断容器是否存在空间
         */
        //不能生产只有等待
        if (count == buns.length) {
            try {
                this.wait(); //此时线程阻塞 什么时候解除阻塞：消费者消费完毕库存，通知继续生产
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间可以生产
        buns[count] = bun;
        count++;
        this.notifyAll(); //生产了就存在商品了，可以通知消费了
    }

    //消费 获取
    public synchronized int pop() {
        /**
         *何时能消费：判断容器是否存在数据
         */
        //没有数据只能等待
        if (count == 0) {
            try {
                this.wait(); //此时线程阻塞 什么时候解除阻塞：生产者通知可以消费，解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //有数据可以消费
        count--;
        int n = buns[count].getId();
        this.notifyAll(); //消费了就存在空间了，可以通知生产者生产了
        return n;
    }
}

//商品：消费品
class Steamedbun {
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}