import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Same with DataSourcesLoader, the only difference is it sleep for 6 seconds.
 */
public class NetworkConnectionsLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning network connection loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network connection loadding has finished: %s\n", new Date());
    }
}
