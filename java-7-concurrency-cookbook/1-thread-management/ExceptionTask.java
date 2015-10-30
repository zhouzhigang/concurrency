/**
 * Processing uncontrolled exceptions in a thread.
 *
 * Dependencies: ExceptionHandler.java
 */
public class ExceptionTask implements Runnable {
    @Override
    public void run() {
        // an uncaught exception
        int number = Integer.parseInt("abc");
    }

    public static void main(String[] args) {
        ExceptionTask task = new ExceptionTask();
        Thread thread = new Thread(task);
        // set the unchecked exception hander
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
