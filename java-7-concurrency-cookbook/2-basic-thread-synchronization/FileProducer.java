/**
 * File producer.
 */
public class FileProducer implements Runnable {

    private FileMock mock;

    private Buffer buffer;

    public FileProducer (FileMock mock, Buffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // set to true means there are more lines to be processed in the buffer
        buffer.setPendingLines(true);
        // read all lines created in the FileMock object and store them in the buffer
        while (mock.hasMoreLines()) {
            String line = mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
