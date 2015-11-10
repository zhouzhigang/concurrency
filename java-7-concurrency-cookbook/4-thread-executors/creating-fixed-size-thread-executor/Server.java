import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Executors;

/**
 * The Server will execute every task it receives using an executor.
 * Using a fixed thread pool.
 */
public class Server {
    private ThreadPoolExecutor executor;

    /**
     * Initialize the ThreadPoolExecuter object using Executors class.
     */
    public Server() {
        // although therer are four constructors in ThreadPoolExecutor
        // we recommond use Executors to create it, here it returns ExecutorService object
        executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
    }

    /**
     * Call execute() method of executor to send it the task.
     */
    public void executeTask(Task task) {
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
        // the number of tasks that have been sent to the executor
        System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
    }

    /**
     * Call shutdown() of executor to finish its execution.
     */
    public void endServer() {
        executor.shutdown();
    }

}

