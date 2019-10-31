package threadtest02;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/2 15:52
 * @Description:
 * 终止线程
 * 1、线程正常执行完毕 ——>次数
 * 2、外部干涉——>加入标识
 * 不要使用stop destory
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class TerminateThread implements  Runnable{
    private boolean flag = true;
    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        //关联标识,true 运行 false停止
        while (flag) {
            System.out.println(name+"->>"+i);
        }
    }

    //对外提供方式改变标识
    public void terminate() {
        this.flag = false;
    }

    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread("张三");
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(tt).start();
        for (int i = 0; i < 50; i++) {
            if (i == 40) {
                tt.terminate();
            }
            System.out.println("main-->" + i);
        }
    }

}