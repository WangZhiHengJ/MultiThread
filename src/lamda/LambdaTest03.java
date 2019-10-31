package lamda;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/1 18:25
 * @Description:
 * lambda表达式 增加返回值
 */
public class LambdaTest03 {

    public static void main(String[] args) {

        Interest interest = (a,b)-> {
            System.out.println("创建lambda表达式-->" + (a+b));
            return a+b;
        };
        int i = interest.lambda(10, 20);
        System.out.println(i);

        interest = (a, b) -> a + b;
        i = interest.lambda(20, 30);
        System.out.println(i);

    }


}

interface Interest {
    int lambda(int a,int b);
}

class inter implements Interest {
    @Override
    public int lambda(int a,int b) {
        System.out.println("创建lambda表达式-->" + (a+b));
        return a+b;
    }
}
