import java.util.Date;

/**
 * Waiting for the finalization of a thread.
 * Using join method to initialization.
 *
 * Dependences: DataSourcesLoader.java, NetworkConnectionsLoader.java
 */
public class WaitingFinalization {
    public static void main(String[] args) {
        DataSourcesLoader dsLoader = new DataSourcesLoader();
        Thread thread1 = new Thread(dsLoader, "DataSourcesLoader");

        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");

        thread1.start();
        thread2.start();

        // wait for the finalization of both threads using the join method
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
    }
}
