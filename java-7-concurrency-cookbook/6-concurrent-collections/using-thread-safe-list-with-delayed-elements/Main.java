import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.Date;

/**
 * Using thread-safe lists with delayed elements.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        DelayQueue<Event> queue = new DelayQueue<Event>();

        Thread threads[] = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            Task task = new Task(i+1, queue);
            threads[i] = new Thread(task);
        }
        // launch all threas
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        // wait for finalization
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        //
        do {
            int counter = 0;
            Event event;
            do {
                event = queue.poll();
                if (event != null) counter++;
            } while (event != null);
            System.out.printf("At %s you have read %d events\n", new Date(), counter);
            TimeUnit.MILLISECONDS.sleep(500);
        } while (queue.size() > 0);
    }
}

