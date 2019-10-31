package jvm_heap_stack;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/28 21:23
 * @Description:
 */
public class Stu {
    int id;
    String name;
    int age;
    Computer computer;
    void play() {
        System.out.println("我在玩王者农药");
    }

    void study() {
        System.out.println("我在练习多线程,使用的是"+computer.brand);
    }
    public Stu() {
    }

    public static void main(String[] args) {
        Stu stu = new Stu();
        stu.id = 1001;
        stu.age = 18;
        stu.name = "张三";

        Computer computer = new Computer();
        computer.brand = "联想";

        stu.computer = computer;
        stu.study();
        stu.play();

    }

}

class Computer {
    String brand;

    public Computer() {
    }
}