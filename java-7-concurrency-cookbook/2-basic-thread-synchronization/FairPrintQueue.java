import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Print queue in fair mode.
 */
public class FairPrintQueue {

    // lock object in fair mode
    private final Lock queueLock = new ReentrantLock(true);

    /**
     * Seperate the simulation of printing in two blocks of code, free the lock between them.
     */
    public void printJob(Object document) {
        // get the control of the Lock object, 
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
        // the second part, allow other threads have opportunity to get to lock
        queueLock.lock();
        try {
            Long duration = (long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration/1000) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}

