package threadTest04;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 08:25
 * @Description:
 * ThreadLocal：每个线程自身的储存本地、局部区域
 * get/set/initialValue
 * 示例：
 * 发糖初始20个糖共用，单个线程更改更改元数据
 */
public class ThreadLoacalTest03 {
    //lambda表达式
    private static ThreadLocal<Integer> threadLocal2 = ThreadLocal.withInitial(()->20);
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new MyThread().start();
        }
    }
    public static class MyThread extends Thread {
        @Override
        public void run() {
            Integer t = threadLocal2.get();
            System.out.println(Thread.currentThread().getName()+"得到了->>>" + threadLocal2.get());
            threadLocal2.set(t - 5);
            System.out.println(Thread.currentThread().getName()+"剩下了->>>" + threadLocal2.get());
        }
    }
}