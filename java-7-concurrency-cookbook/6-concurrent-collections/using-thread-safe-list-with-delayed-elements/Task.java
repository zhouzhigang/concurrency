import java.util.concurrent.DelayQueue;
import java.util.Date;

/**
 * Task that create events to the delay queue.
 */
public class Task implements Runnable {

    private int id;

    private DelayQueue<Event> queue;

    public Task(int id, DelayQueue<Event> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        Date now = new Date();
        Date delay = new Date();
        delay.setTime(now.getTime() + (id*1000));
        System.out.printf("Thread %s: %s\n", id, delay);
        // add events in the queue using add() method
        for (int i = 0; i < 100; i++) {
            Event event = new Event(delay);
            queue.add(event);
        }
    }
}
