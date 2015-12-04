import java.util.concurrent.Callable;

/**
 * A task with infinite loop.
 */
public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        // infinite loop until the task be cancelled
        while (true) {
            System.out.printf("Task: Test\n");
            Thread.sleep(100);
        }
    }
}
