import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Task that will be execute by Server.
 */
public class Task implements Runnable {
    private Date initDate;
    private String name;

    public Task(String name) {
        initDate = new Date();
        this.name = name;
    }
    
    @Override
    public void run() {
        System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
        System.out.printf("%s: Taks %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());
        // put the task to sleep for a random period of time
        try {
            Long duration = (long)(Math.random()*10);
            System.out.printf("%s: Task %s: Doing a task during %d seconds\n", Thread.currentThread().getName(), name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // print the completion date of task
        System.out.printf("%s: Taks %s: Finished on: %s\n", Thread.currentThread().getName(), name, new Date());
    }
}
