import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Producer.
 */
public class Producer implements Runnable {

    // the buffer structer that the producer will interchange with the consumer
    private List<String> buffer;

    // the exchanger object that will be used to synchronize producer and consumer
    private final Exchanger<List<String>> exchanger;

    public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;

        // 10 cycle of exchange
        for (int i = 1; i < 10; i++) {
            System.out.printf("Producer: Cycle %d \n", cycle);
            // add 10 strings to the buffer
            for (int j = 0; j < 10; j++) {
                String message = "Event " + ((i*10)+j);
                System.out.printf("Producer: %s\n", message);
                buffer.add(message);
            }
            // call the exchange() method to interchange data with the consumer
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer: " + buffer.size());
            cycle++;
        }
    }
}
