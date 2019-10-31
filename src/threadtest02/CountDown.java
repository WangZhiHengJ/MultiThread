package threadtest02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/2 16:19
 * @Description:
 * 倒计时
 */
public class CountDown {
  static  Date date = new Date();
    public static void main(String[] args) throws InterruptedException {
        int  flag = 10;

        long endTime = date.getTime();
        while (flag !=-1) {
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime -= 1000;
            flag--;
        }
        System.out.println(new Date());
    }
}