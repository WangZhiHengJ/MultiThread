package threadTest03;

import java.util.concurrent.CopyOnWriteArrayList;
/**
 * @Auther: 王志恒
 * @Date: 2019/8/8 21:59
 * @Description: 线程安全:操作并发容器
 * 将list改为 CopyOnWriteList 安全的并发容器
 */
public class SynContainer02 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() ->
                    list.add(Thread.currentThread().getName())
            ).start();
        }
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(list.size());
    }
}

