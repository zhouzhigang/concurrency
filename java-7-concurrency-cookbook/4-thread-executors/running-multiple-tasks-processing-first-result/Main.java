import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;

/**
 * Running multiple tasks and processing the first result.
 */
public class Main {
    public static void main(String[] args) {
        String username = "test";
        String password = "test";

        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator dbValidator = new UserValidator("DataBase");

        TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
        TaskValidator dbTask = new TaskValidator(dbValidator, username, password);

        List<TaskValidator> taskList = new ArrayList<>();
        taskList.add(ldapTask);
        taskList.add(dbTask);

        // create a ThreadPoolExecutor object
        ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();
        String result;

        try {
            // invokeAny method will return the result of the first task that finishes without throwing an exception
            // return type is same with call method in Callable object
            result = executor.invokeAny(taskList);
            System.out.printf("Main: Result: %s\n", result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.printf("Main: End of the Execution\n");
    }
}
