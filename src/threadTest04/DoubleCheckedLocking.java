package threadTest04;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 07:38
 * @Description:懒汉模式 单例模式：双重检测。
 * 在多线程环境下：
 * 1、私有化构造器
 * 2、提供私有的静态属性：储存对象的地址
 * 3、对外提供公共的静态方法获取这个对象
 */
public class DoubleCheckedLocking {
    //2、提供私有的静态属性：储存对象的地址
    //考虑指令重排情况,加上volatile关键字，避免指令重排
    private static volatile DoubleCheckedLocking doubleCheckedLocking;
    //1、私有化构造器
    private DoubleCheckedLocking() {
    }
    //3、对外提供公共的静态方法获取这个对象
    public static DoubleCheckedLocking getObj() {
        /**
         * 主要解决三个问题
         * 1、不让外面直接获取对象，new实例
         * 2、多线程情况下，保证线程安全，尽量提高程序效率。
         * 3、考虑指令重排情况
         */
        if (doubleCheckedLocking != null) { //提高程序效率
            synchronized (DoubleCheckedLocking.class) {
                if (doubleCheckedLocking == null) {
                    doubleCheckedLocking = new DoubleCheckedLocking();
                    /**
                     * 1、创建对象空间
                     * 2、初始化对象信息
                     * 3、返回对象的地址给引用
                     * 这是不是原子性操作所以可能发生指令重排
                     */
                }
            }
        }
        //返回对象的地址给引用
        return doubleCheckedLocking;
    }

    public static void main(String[] args) {

    }
}