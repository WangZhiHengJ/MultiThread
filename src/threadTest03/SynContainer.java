package threadTest03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/8 21:59
 * @Description: 线程安全:操作并发容器
 * 由于list底层是Object数组，是线程不安全的，所以多线程在操作list容器的时候
 * 容易发生覆盖问题，例如多个线程 同时往Object[i]的位置添加元素就会发生覆盖问题
 */
public class SynContainer {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> lockList = new ArrayList<>();
        for (int i = 0; i <= 10000; i++) {
            new Thread(() ->
                    list.add(Thread.currentThread().getName())
            ).start();
            new Thread(() -> {
                //这样加锁也可以实现
                synchronized (lockList) {
                    lockList.add(Thread.currentThread().getName());
                }
            }).start();
        }
//        list.add("a");
//        list.add("a");
        System.out.println(list.size());
        System.out.println(lockList.size());
    }
}

