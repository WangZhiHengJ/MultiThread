package lamda;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/1 17:53
 * @Description:
 * lambda
 * 1、lambda推导必须有一个引用接收
 * 2、lambda关注的是方法体
 * 3、lambda必须借助接口或者父类才可以
 * 4、当接口中有多个方法时没办法推导
 *
 */
public class LambdaTest01 {

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        //方法内部类
        class Like2 implements ILike {
            @Override
            public void lambda() {
                System.out.println("创建lambda表达式2");
            }
        }
        like = new Like2();
        like.lambda();

        //匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("创建lambda表达式3");
            }
        };

        //lambda
        like = ()->{
                System.out.println("创建lambda表达式3");
        };



    }
    interface ILike {
        void lambda();
    }

    static class Like implements ILike {
        @Override
        public void lambda() {
            System.out.println("创建lambda表达式1");
        }
    }

}

