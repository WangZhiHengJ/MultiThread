package multiThread01;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/30 01:47
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

        String s = "aaaaa";
        System.out.println(s+"bbb".hashCode());
        System.out.println(s.hashCode());
        printPth(s);

        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        StringBuilder sb = new StringBuilder("bbb");
        System.out.println(sb.hashCode());
        sbPrint(sb);
    }


   static void  printPth(String s) {
       System.out.println("-------------------");
       System.out.println(s.hashCode());
        s+="2222";
       System.out.println(s.hashCode());
   }
    static void  sbPrint(StringBuilder s) {
        System.out.println("-------------------");
        System.out.println(s.hashCode());
        s.append("222");
        System.out.println(s.hashCode());
        System.out.println(s);
    }
}