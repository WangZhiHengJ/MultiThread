package reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 15:56
 * @Description: 反射： 由此类对象建模的类的类型
 * 1、获取类对象
 * java中类的各种构造（方法、属性、构造器、注释、类名等等）都映射成java对象
 * 推荐第三种
 */
public class reflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //三种方式获得Class对象
        //1、对象.getClass
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();

        //2、类.class
        //clz = Iphone.class;

        //3、Class.forName("完整路径")
        clz = Class.forName("reflect.Iphone");
        String name = Class.forName("reflect.Iphone").getName();
        System.out.println(name);

        //1、创建对象
        //jdk9已经不推荐使用了
        Iphone iphone1 = (Iphone) clz.newInstance();
        System.out.println(iphone1);

        //2、使用构造器获取对象
        Iphone iphone2 = (Iphone) clz.getConstructor().newInstance();
        System.out.println(iphone2);

    }

}

class Iphone {
    public Iphone() {

    }
}
