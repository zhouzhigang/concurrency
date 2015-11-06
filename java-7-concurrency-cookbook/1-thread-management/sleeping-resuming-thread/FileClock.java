import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Sleeping and Resuming a thread.
 * Use sleep() method to write the actual date every second.
 */
public class FileClock implements Runnable {
    @Override
    public void run() {
        // print the date every second
        // print 5 times, then interrupt, then 5 times again, teminated
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("The FileClock has been interrupted");
            }
        }
    }

    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();
        // interrupt the clock thread 5 seconds latter
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
