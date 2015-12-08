import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Executors;

/**
 * Controlling rejected tasks of an executor.
 */
public class Main {

    public static void main(String[] args) {

        RejectedTaskController controller = new RejectedTaskController();
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();

        // establish the rejected task controller of the executor
        executor.setRejectedExecutionHandler(controller);

        System.out.printf("Main: Starting.\n");
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task " + i);
            executor.submit(task);
        }

        System.out.printf("Main: Shuting down the Executor.\n");
        executor.shutdown();

        // submit a task after executor shutdown
        System.out.printf("Main: Sending another Task.\n");
        Task task = new Task("RejectedTask");
        executor.submit(task);

        System.out.println("Main: End");
        System.out.printf("Main: End.\n");
    }
}
