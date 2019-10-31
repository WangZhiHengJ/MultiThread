package threadtest02;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/3 20:11
 * @Description:
 * 多线程的常用方法 alive getName setName
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class InfoTest {
    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t.isAlive());
        System.out.println(t.getName());

        MyInfo myInfo = new MyInfo();
        t = Thread.currentThread();
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(myInfo).setName("MyInfo ");
        System.out.println(t.getName());

    }
}

class MyInfo implements Runnable {
    private String name;

    @Override
    public void run() {

    }

    public MyInfo() {
    }

    public MyInfo(String name) {
        this.name = name;
    }


}