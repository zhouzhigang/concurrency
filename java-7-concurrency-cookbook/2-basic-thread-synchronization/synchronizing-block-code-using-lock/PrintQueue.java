import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Print queue.
 */
public class PrintQueue {

    // locl object
    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document) {
        // get the control of the Lock object, 
        // if other thread already get the lock, the lock() method will put current thread to sleep until the other thread finishs
        queueLock.lock();
        try {
            // critical section
            Long duration = (long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration/1000) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // free the control of the Lock object
            queueLock.unlock();
        }
    }
}

