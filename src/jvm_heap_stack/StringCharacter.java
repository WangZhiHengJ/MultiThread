package jvm_heap_stack;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/30 01:47
 * @Description:
 * 字符串的不可变性
 */
public class StringCharacter {
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