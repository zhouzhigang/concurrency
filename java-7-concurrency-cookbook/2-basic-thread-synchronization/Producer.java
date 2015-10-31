/**
 * Producer.
 */
public class Producer implements Runnable {

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        // write more than the buffer maxSize(10)
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }

}
