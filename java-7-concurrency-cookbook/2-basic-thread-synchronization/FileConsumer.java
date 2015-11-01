import java.util.Random;

/**
 * Fiel Consumer.
 */
public class FileConsumer implements Runnable {

    private Buffer buffer;

    public FileConsumer (Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // there are more lines to be processed in the buffer
        while (buffer.hasPendingLines()) {
            String line = buffer.get();
            processLine(line);
        }
    }

    /**
     * Sleep for 10 milliseconds to simulate some kind of processing with the line.
     */
    private void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
