import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;

public class ResultTask extends FutureTask<String> {

    // thread name
    private String name;

    public ResultTask(Callable<String> callable) {
        super(callable);
        this.name = ((ExecutableTask)callable).getName();
    }

    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s: Has been canceled\n", name);
        } else {
            System.out.printf("%s: Has finished\n", name);
        }
    }

}
