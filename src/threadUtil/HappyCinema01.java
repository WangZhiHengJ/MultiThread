package threadUtil;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/4 17:25
 * @Description:
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class HappyCinema01 {
    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {
        Cinema c = new Cinema(10, "辉煌影视中心");

        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(new customer(c, 10),"张三").start();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(new customer(c, 10),"李四").start();


    }
}

//顾客
class customer implements Runnable {
    Cinema cinema;
    int seats;

    public customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        boolean flag = cinema.bookTickets(seats);
        if (flag) {
            System.out.println("出票成功:" + Thread.currentThread().getName() + "<- 位置个数为" + seats);
            if (cinema.getSite()>0) {
                System.out.println("剩余可用位置为：" + cinema.getSite());
            }

        } else {
            System.out.println(Thread.currentThread().getName()+"出票失败,位置不够");
            System.out.println("剩余可用位置为：" + cinema.getSite());
        }
    }
}


//影院
class Cinema {
    private int site; //可用的位置个数
    private String name; //名称

    public Cinema(int site, String name) {
        this.site = site;
        this.name = name;
    }
    //购票

    public boolean bookTickets(int seate) {


        if (seate > site) {
            return false;
        }
        synchronized (this) {
            if (seate > site) {
                return false;
            }
            site -= seate;
            return true;
        }
    }

    public int getSite() {
        return site;
    }
}