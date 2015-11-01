import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/**
 * The buffer shared by producer and consumer(using locks).
 */
public class Buffer {

    // store the shared data
    private LinkedList<String> buffer;
    // length of the buffer
    private int maxSize;

    // control the access to the blocks of code that modify the buffer
    private ReentrantLock lock;

    // check empty conditions
    private Condition lines;
    // check full condtion
    private Condition space;

    // check if there are lines in the buffer
    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<String>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    /**
     * Try to store the parameter string in the buffer.
     */
    public void insert(String line) {
        // get the control of the lock
        lock.lock();
        try {
            // check if there is empty space in the buffer
            while (buffer.size() == maxSize) {
                // wait for free space if the buffer is full
                // the thread will be woken up when another thread calls the signal() or signalAll() method in the space Condition
                space.await();
            }
            // store the line in the buffer
            buffer.offer(line);
            System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
            // call signalAll() method over the lines condition to wake up all the threads that were waiting for lines in the buffer
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Get the first string stored in the buffer.
     */
    public String get() {
        String line = null;
        lock.lock();
        try {
            // check if there are lines in the buffer
            while ((buffer.size() == 0) && (hasPendingLines())) {
                // wait for lines in the buffer
                lines.await();
            }
            if (hasPendingLines()) {
                line = buffer.poll();
                System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(), buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;
    }

    /**
     * Establishes the value of the attribute pendingLines.
     * It will be called by producer when it has no more lines to produce.
     */
    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }

    /**
     * returns true if there are more lines to beprocesses, or false otherwise.
     */
    public boolean hasPendingLines() {
        return pendingLines || buffer.size() > 0;
    }
}
