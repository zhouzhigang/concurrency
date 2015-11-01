/**
 * Synchronizaing data access with read/write locks.
 *
 * Dependencies: PricesInfo.java, Reader.java, Writer.java
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        // Create a PricesInfo object
        PricesInfo pricesInfo = new PricesInfo();

        // Create five Reader objects and five Threads to execute them
        Reader readers[] = new Reader[5];
        Thread threadsReader[] = new Thread[5];

        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadsReader[i] = new Thread(readers[i]);
        }

        // Create a Writer object and Thread to execute it
        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);

        // start the threads
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();
    }
}
