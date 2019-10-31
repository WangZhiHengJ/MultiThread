package threadTest04;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 08:25
 * @Description:
 * ThreadLocal：每个线程自身的储存本地、局部区域
 * 分析运行时的上下文环境
 * 1、谁调用 上下文环境就 属于谁
 */
public class ThreadLoacalTest04 {
    //lambda表达式
    private static ThreadLocal<Integer> threadLocal2 = ThreadLocal.withInitial(()->20);
    public static void main(String[] args) {
            new MyThread().start();
    }
    public static class MyThread extends Thread {

        public MyThread() {
            System.out.println(Thread.currentThread().getName()+"->>>" + threadLocal2.get());
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"->>>" + threadLocal2.get());
        }
    }
}