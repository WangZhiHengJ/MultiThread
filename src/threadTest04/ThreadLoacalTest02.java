package threadTest04;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 08:25
 * @Description:
 * ThreadLocal：每个线程自身的储存本地、局部区域
 * get/set/initialValue
 */
public class ThreadLoacalTest02 {
    //初始化值得第一种方式：直接初始化 值。继承ThreadLocal重写initial方法。这里写的是内部类
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };
    //初始化值得第二种方式：lambda表达式
//    private static ThreadLocal<Integer> threadLocal2 = ThreadLocal.withInitial(()->{
//        return 200;
//    });
    //lambda表达式
    private static ThreadLocal<Integer> threadLocal2 = ThreadLocal.withInitial(()->200);
    public static void main(String[] args) {
        threadLocal.set(20);
        System.out.println("main当前线程值："+threadLocal.get());
        new Thread(new MyThread()).start();
        System.out.println("main当前线程值："+threadLocal.get());
        findUserById();
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread线程的值："+threadLocal.get());
        }
    }

    static void findUserById() {
        HashMap<User,String> hashMap = new HashMap();
        User user = new User();
        User user1 = new User();
        hashMap.put(user, "11");
        hashMap.put(user1, "22");

        for (Map.Entry<User,String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }

   static class User { }
}
