import java.util.concurrent.Semaphore;

/**
 * Print queue using Semaphore.
 */
public class PrintQueue {

    private final Semaphore semaphore;

    public PrintQueue() {
        // create a binary semaphore(only take the value 1 or 0)
        semaphore = new Semaphore(1);
    }

    public void printJob(Object document) {
        try {
            // acquire the semaphore
            semaphore.acquire();
            // simulate printing a document
            long duration = (long)(Math.random()*10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // free the semaphore
            semaphore.release();
        }
    }
}
