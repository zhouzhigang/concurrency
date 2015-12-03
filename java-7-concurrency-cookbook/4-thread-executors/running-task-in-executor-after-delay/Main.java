import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Date;

/**
 * Running a stak in an executor after a delay.
 */
public class Main {

    public static void main(String[] args) {
        
        // create an executor of the ScheduledThreadPoolExecutor
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);

        System.out.printf("Main: Starting at: %s\n", new Date());
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task " + i);
            // initialize and start a few tasks with the schedule method
            executor.schedule(task, i+1, TimeUnit.SECONDS);
        }

        // request the finalization of executor
        executor.shutdown();

        // wait for finalization of all the tasks using the awaitTermination method
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.printf("Main: Ends at: %s\n", new Date());
    }
}
