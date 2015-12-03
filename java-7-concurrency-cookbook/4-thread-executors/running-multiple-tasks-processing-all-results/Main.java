import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.ArrayList;

/**
 * Running multiple tasks and processing all the results.
 */
public class Main {
    public static void main(String[] args) {
        // create a ThreadPoolExecutor object
        ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();

        // create a list of Task objects
        List<Task> taskList = new ArrayList<Task>();
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Thread " + i);
            taskList.add(task);
        }

        // create a list of Future objects
        List<Future<Result>> resultList = null;

        // call invokeAll method of ThreadPoolExecutor class, it will return a list of Future objects
        try {
            resultList = executor.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // finalize the executor using shutdown method
        executor.shutdown();

        // print the results
        System.out.println("Main: Printing the results");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Result> future = resultList.get(i);
            try {
                Result result = future.get();
                System.out.println(result.getName() + ": " + result.getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
