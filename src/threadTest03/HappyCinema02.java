package threadTest03;


import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @author: 王志恒
 * @date: 2019/8/5 1:10
 * @return:
 * @Description：
 */


public class HappyCinema02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(6);
        Cinema02 cinema02 = new Cinema02(list, "影视中心");

        List<Integer> zsList = new ArrayList<>();
        zsList.add(1);
        zsList.add(2);

        List<Integer> lsList = new ArrayList<>();
        lsList.add(5);
        lsList.add(6);

        Customer02 zhangsan = new Customer02(cinema02, zsList);
        Customer02 lisi = new Customer02(cinema02, lsList);

        new Thread(zhangsan, "张三").start();
        new Thread(lisi, "李四").start();

    }
}

//顾客
class Customer02 implements Runnable {
    //影院
    Cinema02 cinema;
    //位置个数
    List<Integer> seats;

    public Customer02(Cinema02 cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ",您需要的座位是：" + seats.toString());
        boolean flag = cinema.bookTickets(seats);
        if (flag) {
            System.out.println(threadName + "出票成功: " + seats.toString());
            System.out.println(threadName + "剩余可用位置为：" + cinema.getSite());
        } else {
            System.out.println(threadName + "出票失败,位置不够");
            System.out.println(threadName + "剩余可用位置为：" + cinema.getSite());
        }
    }
}

//影院
class Cinema02 {
    //可用的位置个数
    private volatile List<Integer> site;
    //名称
    private String name;

    public Cinema02(List<Integer> site, String name) {
        this.site = site;
        this.name = name;
    }

    //购票
    public boolean bookTickets(List<Integer> seate) {
        synchronized (this) {
            List<Integer> copy = new ArrayList<>();
            //防止失败,copy一份进行操作
            copy.addAll(site);
            copy.removeAll(seate);
            if ((copy.size() + seate.size()) != site.size()) {
                return false;
            }
            System.out.println("当前线程是：" + Thread.currentThread().getName());
            site = copy;
            return true;

        }
    }

    public List<Integer> getSite() {
        return site;
    }


    public String getName() {
        return name;
    }
}