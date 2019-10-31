package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 17:54
 * @Description:
 * 使用反射读取注解信息，模拟处理注解信息的流程
 */
public class Demo02 {

    public static void main(String[] args) {
        try {
            Class clz = Class.forName("annotation.Student");
            Annotation[] a = clz.getAnnotations();
            //获得类的所有有效注解
            for (Annotation annotation : a) {
                System.out.println(annotation);
            }
            //获得注解类得 注解
            table t = (table) clz.getAnnotation(table.class);
            System.out.println(t.value());

            //获得类的属性的注解
            Field fd =  clz.getDeclaredField("studentName");
            MyFieldAnnotation mf = fd.getAnnotation(MyFieldAnnotation.class);
            System.out.println(mf.columnName() + "--" + mf.type() + "--" + mf.length());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}