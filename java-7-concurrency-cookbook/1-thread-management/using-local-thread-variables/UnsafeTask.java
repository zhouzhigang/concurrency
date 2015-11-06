import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Various Threads object using the same Runnable object.
 * All the threads share the same attributess.
 */
public class UnsafeTask implements Runnable {

    // all the threads share the same attribute
    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s \n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // startDate might be changed by other threads
        System.out.printf("Thread Finished: %s: %s\n", Thread.currentThread().getId(), startDate);
    }
    
    public static void main(String[] args) {
        UnsafeTask task = new UnsafeTask();
        for (int i = 0; i < 10; i++) {
            // all threads using the same Runnable object
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
