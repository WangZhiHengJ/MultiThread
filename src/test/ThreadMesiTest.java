package test;

public class ThreadMesiTest  {
    public static volatile boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {

                while (!initFlag) {
                    //System.out.println("1、>>"+initFlag);
//                    try {
//                       // Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//// TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                }
                System.out.println("我获取到最新的flag值了！！！");
            }
        });
        thread1.start();
        Thread.sleep(3000);
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                initFlag = true;
                System.out.println("2、>>"+initFlag);
                System.out.println("我更新到flag值了！！！");
            }
        });
        thread2.start();
        System.out.println("3、>>"+initFlag);

    }
}