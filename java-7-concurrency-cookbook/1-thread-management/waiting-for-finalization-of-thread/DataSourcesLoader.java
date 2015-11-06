import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Same with NetworkConnectionsLoader, the only difference is it sleep for 4 seconds.
 */
public class DataSourcesLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning data sources loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished: %s\n", new Date());
    }
}
