
class ThreadTest1 implements Runnable {
    // 构造方法中开辟线程
    public ThreadTest1() {
//        new Thread(() -> {
//            while (true) {
//                foo();
//            }
//        }).start();
        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();

    }

    synchronized void foo() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ">>>运行");
        }
    }

    @Override
    public void run() {

        if (Thread.interrupted()) {
            System.out.println("中断线程。");
            return;
        } else {
            synchronized (ThreadTest1.class) {
                while (true) {
                    try {
                        Thread.sleep(1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("等待锁中...");
                }
            }
//
//        while (true) {
//            if (Thread.interrupted()) {
//                System.out.println("中断线程。");
//                break;
//            } else {
//
//                synchronized (ThreadTest1.class) {
//                    System.out.println("等待锁中...");
//
//                }
//            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest1());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName() + ">>>" + thread.getState());
//        thread.interrupt();
        System.out.println("main thread is dead.");
    }

}
