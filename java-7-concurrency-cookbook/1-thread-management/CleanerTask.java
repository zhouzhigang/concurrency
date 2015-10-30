import java.util.Deque;
import java.util.Date;

/**
 * CleanerTask is a daemon thread, which will delete event more than 10 seconds ago.
 */
public class CleanerTask extends Thread {
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        // mark the thread as a daemon thread with setDaemon method
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;

        if (deque.size() == 0) {
            return;
        }
        delete = false;
        // if the last event was created more than 10 seconds ago, then delete it and check the next event
        do {
            Event e = deque.getLast();
            difference = date.getTime() - e.getDate().getTime();
            if (difference > 10000) {
                System.out.printf("Cleaner: %s\n", e.getEvent());
                deque.removeLast();
                delete = true;
            }
        } while (difference > 10000);

        if (delete) {
            System.out.printf("Cleaner: Size of the queue: %d\n", deque.size());
        }
    }
}
