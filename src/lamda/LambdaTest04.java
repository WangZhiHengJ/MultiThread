package lamda;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/1 18:25
 * @Description:
 * lambda表达式 增加返回值
 */
@SuppressWarnings({"ALL", "AlibabaAvoidManuallyCreateThread"})
public class LambdaTest04 implements Runnable{

    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public static void main(String[] args) {

        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(()->System.out.println("练习lambda表达式")).start();
    }

    @Override
    public void run() {
        System.out.println("LambdaTest03.java");
    }
}

