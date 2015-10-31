/**
 * Consumer.
 */
public class Consumer implements Runnable {

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        // consumer more than the buffer maxSize(10)
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}
