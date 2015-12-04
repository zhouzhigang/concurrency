import java.util.Date;

/**
 * Task.
 */
public class Task implements Runnable {

    // thread name
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Starting at: %s\n", name, new Date());
    }
}
