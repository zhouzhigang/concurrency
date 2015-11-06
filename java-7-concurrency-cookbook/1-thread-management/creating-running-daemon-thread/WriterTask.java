import java.util.Deque;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Each WriterTask thread writers an event and sleep for one second.
 */
public class WriterTask implements Runnable {

    private Deque<Event> deque;

    public WriterTask (Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // create a new event, save it in the queue, and sleep for one second
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generated an event", Thread.currentThread().getId()));
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}