package threadTest03;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/30 23:16
 * @Description:
 * 线程不安全演示
 */

@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class Web12306 implements Runnable {
    private int ticketNums = 20;
    private boolean flag =true;


    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // test01();
          //  test02();
//            test03();
//            test04();
            test05();
        }

    }

    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {
        Web12306 web = new Web12306();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(web,"牛1").start();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(web,"牛2").start();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(web,"牛3").start();

    }

    public  void test01() {


      //出现负数是由于主内存的值没有刷新，也就是大于0的时候另外两个线程通过了资源之前的所有判断，但是拿到资源的时候主内存的值已经刷新了
      //出现相同的数字是，主内存的值没有刷新，线程拿的都是同一份资源
            if (ticketNums <= 0) {
                flag = false;
                return;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+">>>"+ticketNums--);
    }


    /**
     * @author: 王志恒
     * @date: 2019/8/4 16:37
     * @param
     * @return:
     * @Description：
     * 线程安全
     *增加同步代码块
     */
    public  void test02() {
        //出现负数是由于主内存的值没有刷新，也就是大于0的时候另外两个线程通过了资源之前的所有判断，但是拿到资源的时候主内存的值已经刷新了
        //出现相同的数字是，主内存的值没有刷新，线程拿的都是同一份资源
        synchronized (this) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+">>>"+ticketNums--);
        }
    }

    /**
     * @author: 王志恒
     * @date: 2019/8/4 16:38
     * @param
     * @return:
     * @Description：
     *线程不安全 锁定的Integer对象一直在变所以锁定失败
     * 例如：Integer1对象 和 Integer2 是两个对象
     *
     */
    public  void test03() {
        //出现负数是由于主内存的值没有刷新，也就是大于0的时候另外两个线程通过了资源之前的所有判断，但是拿到资源的时候主内存的值已经刷新了
        //出现相同的数字是，主内存的值没有刷新，线程拿的都是同一份资源
        synchronized ((Integer)ticketNums) {

            if (ticketNums <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+">>>"+ticketNums--);
        }
    }
    /**
     * @author: 王志恒
     * @date: 2019/8/4 16:52
     * @param
     * @return:
     * @Description：
     *线程不安全：范围太小锁不住
     *
     */
    public  void test04() {
        //出现负数是由于主内存的值没有刷新，也就是大于0的时候另外两个线程通过了资源之前的所有判断，但是拿到资源的时候主内存的值已经刷新了
        //出现相同的数字是，主内存的值没有刷新，线程拿的都是同一份资源


            if (ticketNums <= 0) {
                flag = false;
                return;
            }
        synchronized (this) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+">>>"+ticketNums--);
        }
    }

    /**
     * @author: 王志恒
     * @date: 2019/8/4 16:55
     * @param
     * @return:
     * @Description：
     *缩小锁的范围，尽可能锁定合理的范围
     * 增加程序的效率
     * 双重检测 double checking
     * 主要解决临界值的问题
     */
    public  void test05() {
        //出现负数是由于主内存的值没有刷新，也就是大于0的时候另外两个线程通过了资源之前的所有判断，但是拿到资源的时候主内存的值已经刷新了
        //出现相同的数字是，主内存的值没有刷新，线程拿的都是同一份资源
        if (ticketNums <= 0) { //考虑的是没有票的时候
            flag = false;
            return;
        }
        synchronized (this) {
            if (ticketNums <= 0) {  //考虑的是最后一张票的时候
                flag = false;
                return;
            }
            System.out.println(Thread.currentThread().getName()+">>>"+ticketNums--);
        }
    }
}