/**
 * Createing a thread by implements Runnable interface.
 * Create and run 10 threads.
 * Each thread calculates and prints the multipication table of a number between 1 and 10.
 */
public class Calculator implements Runnable {
    private int number;
    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i*number);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            Calculator cal = new Calculator(i);
            Thread thread = new Thread(cal);
            // creating a new execution thread by calling start
            thread.start();
        }
    }
}

