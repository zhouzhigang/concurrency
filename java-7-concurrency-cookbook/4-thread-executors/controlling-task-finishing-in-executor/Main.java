import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;

/**
 * Controlling a task finishing in an executor.
 */
public class Main {
    public static void main(String[] args) {

        // create ExecutorService object
        ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();

        ResultTask resultTasks[] = new ResultTask[5];

        // initialize the ResultTask objects
        for (int i = 0; i < 5; i++) {
            ExecutableTask executableTask = new ExecutableTask("Task " + i);
            resultTasks[i] = new ResultTask(executableTask);
            executor.submit(resultTasks[i]);
        }

        // put the main thread to sleep for 5 seconds
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // print the result using get() method
        for (int i = 0; i < resultTasks.length; i++) {
            try {
                if (!resultTasks[i].isCancelled()) {
                    System.out.printf("%s\n", resultTasks[i].get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // finish the executor
        executor.shutdown();
    }
}


