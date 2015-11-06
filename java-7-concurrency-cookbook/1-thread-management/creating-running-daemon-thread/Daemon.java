import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Daemon thread test.
 *
 * Dependencies: Event.java, WriterTask.java, CleanerTask.java
 */
public class Daemon {
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<Event>();

        WriterTask writer = new WriterTask(deque);
        // each writer thread will create an event every second
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }

        // CleanerTask thread will not delete event less than 10 seconds,
        // So in the first 10 seconds, each thread will creates 10 events(total: 30).
        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}
