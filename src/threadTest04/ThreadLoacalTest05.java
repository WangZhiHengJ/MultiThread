package threadTest04;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 08:25
 * @Description:
 * InheritableThreadLocal 可继承的
 * 继承上下文环境的数据
 * 拷贝一份给子线程,子线程修改不影响主线程的数据
 */
public class ThreadLoacalTest05 {
    //lambda表达式
    private static ThreadLocal<Integer> threadLocal2 = new InheritableThreadLocal<>();
    //private static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
    public static void main(String[] args) {
        threadLocal2.set(20);
        System.out.println(Thread.currentThread().getName()+"->>>" + threadLocal2.get());

        //使用InheritableThreadLocal的时候，会继承上下文环境，也就是在哪个线程开辟的新线程会继承前一个线程的数据
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"->>>" + threadLocal2.get());
            threadLocal2.set(10);
            System.out.println(Thread.currentThread().getName()+"->>>" + threadLocal2.get());
        }).start();

        System.out.println(Thread.currentThread().getName()+"->>>" + threadLocal2.get());

    }
}