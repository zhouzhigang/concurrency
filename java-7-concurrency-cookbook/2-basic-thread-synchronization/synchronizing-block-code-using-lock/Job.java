/**
 * Synchonizing a block of code with a Lock.
 * Simulate many print jobs.
 *
 * Dependencies: PrintQueue.java
 */
public class Job implements Runnable {
    // shared print queue object
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
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
        PrintQueue printQueue = new PrintQueue();

        // create 10 Job objects and 10 threads to run them
        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }
        // start the 10 threads
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}
