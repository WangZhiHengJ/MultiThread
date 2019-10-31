package annotation;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 17:20
 * @Description:
 * 自定义注解
 */
public class Demo01 {

    @MyAnnotation01(age = 19,id = 1,schools = {"北京大学"})
    public void test() {

    }

    //只有一个注解时可以不写注解的名字  @MyAnnotation02(value ="aaa")
    @MyAnnotation02("aaa")
    public void test2() {

    }
}