package classload;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/16 20:21
 * @Description:
 * 类加载机制
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader()); //当前类的 类加载器 ：应用类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent()); //当前类的 父类加载器 ：扩展类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());//引导类，类加载器 由c编写所以获取不到
        //当前类路径 classPath
        System.out.println(System.getProperty("java.class.path"));
        System.out.println("---"+Thread.currentThread().getContextClassLoader().getResource(".").getPath());
        aa();
    }

    public static  void aa() {
        System.out.println(Thread.currentThread().getClass().getResource("/"));
    }

}