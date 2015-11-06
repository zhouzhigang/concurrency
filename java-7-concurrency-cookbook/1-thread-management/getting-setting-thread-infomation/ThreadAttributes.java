import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Thread.State;

/**
 * Getting and setting thread information.
 * Create 10 threads and show their status until they finish.
 */
public class ThreadAttributes {
    public static void main(String[] args) {
        // create an array of 10 threads
        Thread threads[] = new Thread[10];
        // create an array of 10 Thread.State
        Thread.State status[] = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            // initialize each thread with a different number
            threads[i] = new Thread(new Calculator(i));
            // set different priority, might throw IllegalArgumentException if priority isn't between 1 and 10
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            // set thread name
            threads[i].setName("Thread " + i);
        }

        // Create a PrintWrite object to write to a file on the evolution of the status of the threads
        try (FileWriter file = new FileWriter("log.txt");
                PrintWriter pw = new PrintWriter(file);) {
            // write initial status: NEW
            for (int i = 0; i < 10; i++) {
                pw.println("Main: Status of Thread " + i + ": " + threads[i].getState());
                status[i] = threads[i].getState();
            }
            // start the execution of the 10 threads
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }
            // until the 10 threads end, check their status
            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    // if detect a change in the status of a thread, write them on the file
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    // finish means all status equals TERMINATED
                    finish = finish && (threads[i].getState() == State.TERMINATED);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Write the ID, name, priority, old status, and new status of Thread.
     */
    private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
        pw.printf("Main: id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main: priority: %d\n", thread.getPriority());
        pw.printf("Main: Old State: %s\n", state);
        pw.printf("Main: New State: %s\n", thread.getState());
        pw.printf("Main: *******************************\n");
    }
}
