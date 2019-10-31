package threadTest04;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 07:23
 * @Description:
 * volatile用于保证数据的同步。也就是可见性
 */
public class VolatileTest {
    private volatile static int num = 0;
//    private  static int num = 0;
    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            while (num == 0) {

            }
        }).start();

        Thread.sleep(1000);
        System.out.println("等待结束");
        num = 1;
        System.out.println("主线程结束");
    }
}