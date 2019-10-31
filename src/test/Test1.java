package test;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/5 02:36
 * @Description:
 * 一个问题
 * 缓存的问题
 */
public class Test1 implements Runnable{
    @Override
    public void run() {
        zuse();
    }

    synchronized void zuse(){
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("线程中断");
                return;
            }
            System.out.println("正常运行");
        }
    }
    public static void main(String[] args) {
        Thread thread =  new Thread(new Test1());
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();




    }
}