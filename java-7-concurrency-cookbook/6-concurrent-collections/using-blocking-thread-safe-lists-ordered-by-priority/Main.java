import java.util.concurrent.PriorityBlockingQueue;

/**
 * Using Blocking thread-safe lists ordered priority.
 */
public class Main {
    public static void main(String[] args) {
        // priority blocking queue
        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<Event>();

        // create threads
        Thread taskThreads[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Task task = new Task(i, queue);
            taskThreads[i] = new Thread(task);
        }
        // start these threads
        for (int i = 0; i < taskThreads.length; i++) {
            taskThreads[i].start();
        }
        // wait for finalization
        for (int i = 0; i < taskThreads.length; i++) {
            try {
                taskThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // get data from the priority blocking queue
        System.out.printf("Main: Queue Size: %d\n", queue.size());
        for (int i = 0; i < taskThreads.length*1000; i++) {
            // use poll() method to take off the event from the queue
            Event event = queue.poll();
            System.out.printf("Thread %s: Priority %d\n", event.getThread(), event.getPriority());
        }

        System.out.printf("Main: Queue Size: %d\n", queue.size());
        System.out.printf("Main: End of the program\n");
    }
}
