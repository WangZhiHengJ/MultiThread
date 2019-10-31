package threadTest01;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/30 18:30
 * @Description:
 * 创建线程方式一：
 * 1、继承Thread类重写run方法
 * 2、实现Runnable接口
 */
public class StartThread02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("一边听歌");
        }

    }

    public static void main(String[] args) {

        StartThread02 st = new StartThread02();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(st).start();
        for (int i = 0; i < 200; i++) {
            System.out.println("一边写代码");
        }

    }


}