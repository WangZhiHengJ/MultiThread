package threadTest04;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 08:25
 * @Description:
 * ThreadLocal：每个线程自身的储存本地、局部区域
 * get/set/initialValue
 */
public class ThreadLoacalTest01 {
    //每个线程独享
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        threadLocal.set(100);
        System.out.println("main当前线程值："+threadLocal.get());
        new Thread(new MyThread()).start();

    }

    public static class MyThread extends Thread {

//        @Override
//        public void run() {
//            System.out.println("MyThread线程的值："+threadLocal.get());
//        }
        @Override
        public void run() {
            threadLocal.set(10);
            System.out.println("MyThread线程的值："+threadLocal.get());
        }
    }
}