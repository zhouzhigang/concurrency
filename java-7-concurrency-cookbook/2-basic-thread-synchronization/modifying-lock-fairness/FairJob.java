/**
 * Modifying Lock fairness.
 * Simulate many print jobs in fair mode.
 *
 * Dependencies: FairPrintQueue.java
 */
public class FairJob implements Runnable {
    // shared print queue object
    private FairPrintQueue printQueue;

    public FairJob(FairPrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        // send a job to print
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        FairPrintQueue printQueue = new FairPrintQueue();

        // create 10 Job objects and 10 threads to run them
        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new FairJob(printQueue), "Thread " + i);
        }
        // start the 10 threads
        for (int i = 0; i < 10; i++) {
            thread[i].start();
            // sleep for a moment to make sure all threads start one by one
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
