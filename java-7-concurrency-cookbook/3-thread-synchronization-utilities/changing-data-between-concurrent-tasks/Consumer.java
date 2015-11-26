import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Consumer.
 */
public class Consumer implements Runnable {

    // the buffer structer that the producer will interchange with the consumer
    private List<String> buffer;

    // the exchanger object that will be used to synchronize producer and consumer
    private final Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Consumer: Cycle %d\n", cycle);
            // call the exchange method to synchronize with the producer
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer: " + buffer.size());
            // print the 10 strings the producer sent in the buffer and delete them from the buffer
            for (int j = 0; j < 10; j++) {
                String message = buffer.get(0);
                System.out.println("Consumer: " + message);
                buffer.remove(0);
            }
            cycle++;
        }
    }

}
