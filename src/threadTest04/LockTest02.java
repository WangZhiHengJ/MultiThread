package threadTest04;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: 王志恒
 * @Date: 2019/8/12 09:41
 * @Description:
 * 可重入锁示例
 * 锁可以延续使用 + 计数器
 */

public class LockTest02 {
    //ReLock reLock = new ReLock();
    //jdk内部提供的可重入锁
    ReentrantLock reLock = new ReentrantLock();
    public void a() {
        reLock.lock();
        System.out.println(reLock.getHoldCount());
        b();
        reLock.unlock();
        System.out.println(reLock.getHoldCount());
    }

    //不可重入
    public void b() {
        reLock.lock();
        System.out.println(reLock.getHoldCount());
        //.....
        reLock.unlock();
        System.out.println(reLock.getHoldCount());
    }

    public static void main(String[] args) {

        LockTest02 lockTest02 = new LockTest02();
        //不可重入锁，造成死循环
        lockTest02.a();

    }
}
//可重入锁
class ReLock {
    //是否占用
    private boolean isLocked = false;
    private Thread lockedBy = null; //存储线程
    private int holdCount = 0; //计数器
    //使用锁
    public synchronized void lock() {
        Thread t = Thread.currentThread();
        while (isLocked && lockedBy != t) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockedBy = t;
        holdCount++;

    }

    //释放锁
    public synchronized void unLock() {
        Thread t = Thread.currentThread();
        if (t == lockedBy) {
            holdCount--;
            if (holdCount == 0 ) {
                isLocked = false;
                lockedBy = null;
                notify();
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}