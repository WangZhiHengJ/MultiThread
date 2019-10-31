package lamda;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/1 18:13
 * @Description: lambda加入参数
 */
public class LambdaTest02 {
    public static void main(String[] args) {

        ILove love = (int a) -> {
            System.out.println("创建lambda表达式-->" + a);
        };
        love.lambda(100);
        love = a -> System.out.println("创建lambda表达式-->" + a);
        love.lambda(50);

    }


}

interface ILove {
    void lambda(int a);
}

class Love implements ILove {
    @Override
    public void lambda(int a) {
        System.out.println("sdf ");
        System.out.println("创建lambda表达式-->" + a);
    }
}