/**
 * Controlling concurrent access to a resource.
 * Simulate sending jobs to print.
 *
 * Dependencies: PrintQueue.java
 */
public class Job implements Runnable {

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
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
        PrintQueue printQueue = new PrintQueue();

        // create 10 thread, each one will execute a Job object that will send a document to the print queue
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        // start the 10 threads
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}

