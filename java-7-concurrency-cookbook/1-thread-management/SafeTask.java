import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Using local thread variables.
 * All thread objects have their own value of startDate attribute.
 */
public class SafeTask implements Runnable {

    /**
     * ThreadLocal variables store a value of an attribute for each Thread that useone of these attributes.
     * This object will have an implementation that inlcudes the method initialValue().
     */
    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        // using get() method to get the startDate attribute
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
    }

    public static void main(String[] args) {
        SafeTask task = new SafeTask();
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
