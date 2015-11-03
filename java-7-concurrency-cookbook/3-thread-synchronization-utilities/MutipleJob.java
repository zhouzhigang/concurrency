/**
 * Controlling concurrent access to mutiple copies of a resource.
 * Simulate sending jobs to print.
 *
 * Dependencies: MutiplePrintQueue.java
 */
public class MutipleJob implements Runnable {

    private MutiplePrintQueue printQueue;

    public MutipleJob(MutiplePrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        // send a dcoument to the print
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MutiplePrintQueue printQueue = new MutiplePrintQueue();

        // create 10 thread, each one will execute a Job object that will send a document to the print queue
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new MutipleJob(printQueue), "Thread" + i);
        }

        // start the 10 threads
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}

