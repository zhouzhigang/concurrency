/**
 * Using multiple conditions in a Lock.
 *
 * Dependencies: FileMock.java, Buffer.java, FileProducer.java, FileConsumer.java
 */
public class FileProducerConsumerTest {

    public static void main(String[] args) {
        FileMock mock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);

        // create a producer object
        FileProducer producer = new FileProducer(mock, buffer);
        Thread threadProducer = new Thread(producer);

        // create three consumer objects
        FileConsumer consumers[] = new FileConsumer[3];
        Thread threadConsumers[] = new Thread[3];

        for (int i = 0; i < 3; i++) {
            consumers[i] = new FileConsumer(buffer);
            threadConsumers[i] = new Thread(consumers[i], "Consumer " + i);
        }

        // Start the producer and three consumers
        threadProducer.start();
        for (int i = 0; i < 3; i++) {
            threadConsumers[i].start();
        }
    }
}
