package threadTest04;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/9 22:50
 * @Description:
 * 定时任务：
 * 先创建自己的任务类，继承定时任务类:TimerTask,重写run方法
 * 2、创建定时器 timer 调用 计划方法：schedule备注：(计划的意思)
 */
public class TimerTest01  {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //2秒后执行任务，每隔1重复调用
//        timer.schedule(new MyTask(), 2000, 1000);
        //2秒后执行任务,只调用一次
//        timer.schedule(new MyTask(), 2000);

        //从指定时间开始执行任务
        timer.schedule(new MyTask(),new Date());
        //终止定时器，丢弃任何当前的任务
//        timer.cancel();

    }
}

class MyTask extends TimerTask {
    @Override
    public void run() {
            System.out.println("放空大脑,休息一会.");
    }
}