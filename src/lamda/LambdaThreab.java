package lamda;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/1 17:39
 * @Description: lambda表达式
 * 简化线程 用一次的类适合使用
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class LambdaThreab  {
    //静态内部类
    static class Test implements Runnable {
        /**
         * @author: 王志恒
         * @date: 2019/8/1 17:40
         * @param
         * @return:
         * @Description：
         * 线程入口点
         */
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {

            }
        }
    }


    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {
     //   new Thread(new Test()).start();


         class Test2 implements Runnable {
            /**
             * @author: 王志恒
             * @date: 2019/8/1 17:40
             * @param
             * @return:
             * @Description：
             * 局部内部类
             */
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("听歌");
                }
            }
        }
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(new Test2()).start();

         //匿名内部类必须借助接口和父类
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("听歌");
                }
            }
        }).start();

        //jdk8简化 lanbda
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("听歌");
            }
        }).start();

    }
}