import java.util.concurrent.TimeUnit;

/**
 * Task to be executed.
 */
public class Task implements Runnable {
    // thread name
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task " + name + ": Starting");
        // wait for a random period of time
        try {
            long duration = (long)(Math.random()*10);
            System.out.printf("Task %s: ReportGenerator: Generating a report during %d seconds\n", name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Task %s: Ending\n", name);
    }

    public String toString() {
        return name;
    }
}
