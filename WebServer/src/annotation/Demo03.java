package annotation;

import java.lang.reflect.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 17:54
 * @Description: 使用反射读取注解信息，模拟处理注解信息的流程
 */
public class Demo03 {

    public static void main(String[] args) {
        try {
            Class<Student> clazz =(Class<Student>) Class.forName("annotation.Student");

            //获得类对象，创建对象实例,所以一定要加无参构造方法
            Student student01 =  clazz.newInstance(); //其实是调用了无参构造方法
            System.out.println(student01);

            //通过反射API,调用构造器方法
            System.out.println("通过反射API,调用构造器方法");
            Constructor<Student> constructor = clazz.getConstructor(int.class, String.class, int.class);
            student01 = constructor.newInstance(111, "阿志", 18);
            System.out.println(student01.getAge());


            //通过反射API,调用普通方法
            System.out.println("通过反射API,调用普通方法");
            Method[] methods= clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            System.out.println(student01.getAge());

            Student student02 =  clazz.newInstance();
            Method method= clazz.getDeclaredMethod("setAge",int.class);
            method.invoke(student02, 20);
            System.out.println(student02.getAge());

            //调用没有形参的方法时，不用传递对象 System.out.println(student02.getAge());下面两句等于这一句

            method= clazz.getDeclaredMethod("getAge");
            System.out.println(method.invoke(student02));

            //有形参的时候需要指定参数类型
            Student student03 = clazz.newInstance();
            Method m2 = clazz.getDeclaredMethod("setStudentName", String.class);
            m2.invoke(student03, "阿志2");//通过反射设置

            m2 = clazz.getDeclaredMethod("getStudentName");
            System.out.println(m2.invoke(student03));//通过反射读取

            //获得单个字段
            Student student04 =  clazz.newInstance();
            //Field field1 = clazz.getField("studentName"); 必须加上Declared，要不然拿不动私有的 private 修饰的属性
            Field field1 = clazz.getDeclaredField("studentName");
            field1.setAccessible(true);//Accessible要设置为true.告诉编译器不用做访问检查了，注意只是访问检查，可以直接访问
            field1.set(student04,"阿志4"); //通过反射设置字段的值
            System.out.println("---"+student04.getStudentName());
            System.out.println(field1.get(student04));//通过反射读取字段的值
            //获得所有字段
            System.out.println("获得所有字段");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }


            //通过反射API,调用普通方法


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}