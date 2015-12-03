import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Task that implements Callable interface parameterized with Result class.
 */
public class Task implements Callable<Result> {

    // task name
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.printf("%s: Starting\n", this.name);

        // wait for a random period of time
        try {
            long duration = (long)(Math.random()*10);
            System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // generate an int value to return in the Result object, calculate the sum of five random numbers
        int value = 0;
        for (int i = 0; i < 5; i++) {
            value += (int)(Math.random()*100);
        }
        // create a Result object and initialize it with the name of this task and the result
        Result result = new Result();
        result.setName(name);
        result.setValue(value);
        System.out.println(this.name + ": Ends");
        return result;
    }
}

