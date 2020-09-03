import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {

    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    public void method1() {
        lock.lock();
        try {
            cond.await();                           // suspend execution, await for signal to resume
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void method2() {
        lock.lock();
 
        cond.signal();      // signal the other thread to continue execution
                            // unlock must be called after so that the other thread can acquire the lock
                            // cond.signal();       // signal the first thread, which was waiting the longest
                            // cond.signalAll();    // signal all threads
        lock.unlock();
       
    }
}