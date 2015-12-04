import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Canceling a task in an executor.
 */
public class Main {
    public static void main(String[] args) {

        // createa ThreadPoolExecutor object
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        Task task = new Task();

        // submit the task
        System.out.printf("Main: Executing the Task\n");
        Future<String> result = executor.submit(task);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // cancel the task
        System.out.printf("Main: Canceling the Task\n");
        result.cancel(true);

        // check if cancled and already done
        System.out.printf("Main: Canceled: %s\n", result.isCancelled());
        System.out.printf("Main: Done: %s\n", result.isDone());

        // shutdown the executor
        executor.shutdown();
        System.out.printf("Main: The executor has finished\n");
    }
}
