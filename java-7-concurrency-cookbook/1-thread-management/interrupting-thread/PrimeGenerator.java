/**
 * Interrupt a thread.
 * Create a thread and, after 5 seconds, will force its finalization using the interruption mechanism.
 */
public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;
        // process consecutive numbers beginning at one.
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }
            // check if the thread has been interrupted
            // isInterrupted() method return whether a thread interrupted or not
            if (isInterrupted()) {
                System.out.printf("The prime Generator has been Interrupted\n");
                // if interrupted, end the execution of the thread
                return;
            }
            number++;
        }
    }

    /**
     * Check if a number is a prime.
     */
    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        // sleep Main thread 5 seconds to prevent it execute interrupt immediatedly
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // The thread class has an attribute that stores a boolean value
        // indicating whether the thread has been interrupted or not.
        // The attribute will set to true when you call the interrupt() method of a thread.
        task.interrupt();
    }
}
