import java.util.Random;

/**
 * Processing uncontrolled exceptions in a group of threads.
 *
 * Dependencies: ThreadGroupHandler.java
 */
public class GroupExceptionTask implements Runnable {

    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            // divide 1000 between random numbers until the randmon number is zero and the ArithmethicExceptin is thrown
            result = 1000 / (int)(random.nextDouble()*1000);
            System.out.printf("%s : %d\n", Thread.currentThread().getId(), result);
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
                return;
            }
        }
    }

    public static void main(String[] args) {
        ThreadGroupHandler threadGroup = new ThreadGroupHandler("ThreadGroupHandler");
        GroupExceptionTask task = new GroupExceptionTask();

        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(threadGroup, task);
            t.start();
        }
    }
}
