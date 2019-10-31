package threadTest04;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 09:41
 * @Description:
 * 不可重入锁
 */

public class LockTest01 {
    Lock lock = new Lock();

    public void a() {
        lock.lock();
        b();
        lock.unLock();
    }

    //不可重入
    public void b() {
        lock.lock();
        //.....
        lock.unLock();
    }

    public static void main(String[] args) {

        LockTest01 lockTest01 = new LockTest01();
        //不可重入锁，造成死循环
        lockTest01.a();


    }
}

//不可重入锁
class Lock {
    //是否占用
    private boolean isLocked = false;

    //使用锁
    public synchronized void lock() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }

    //释放锁
    public synchronized void unLock() {
        isLocked = false;
        notify();
    }
}