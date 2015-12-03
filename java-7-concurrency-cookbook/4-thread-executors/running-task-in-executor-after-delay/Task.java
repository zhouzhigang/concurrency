import java.util.concurrent.Callable;
import java.util.Date;

/**
 * Task.
 */
public class Task implements Callable<String> {

    // thread name
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s: Starting at: %s\n", name, new Date());
        return "Hello, world";
    }
}
