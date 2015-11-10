import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Executors;

/**
 * The Server will execute every task it receives using an executor.
 */
public class Server {
    private ThreadPoolExecutor executor;

    /**
     * Initialize the ThreadPoolExecuter object using Executors class.
     */
    public Server() {
        // although therer are four constructors in ThreadPoolExecutor
        // we recommond use Executors to create it, here it returns ExecutorService object
        executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
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
    }

    /**
     * Call shutdown() of executor to finish its execution.
     */
    public void endServer() {
        executor.shutdown();
    }

}

