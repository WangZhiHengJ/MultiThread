package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 17:45
 * @Description:
 */
//标识可以用在方法上、类上面
@Target(value = {ElementType.METHOD, ElementType.TYPE,ElementType.FIELD})
//单词的本意是保留的意思。
//标识什么级别保留该注释信息，用于描述注解的生命周期：SOURCE 在源文件中有效。CLASS在class文件中有效。RUNTIME运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface MyFieldAnnotation {
    //列名
    String columnName();
    //类型
    String type();
    //长度
    int length();
}
