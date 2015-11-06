import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Grouping threads into a group.
 * Ten threads sleeping during a random period of time(simulating a search, for example) and,
 * when one of them finishes, we are going to interrupt the rest.
 *
 * Dependencies: Result.java
 */
public class SearchTask implements Runnable {

    // store the name of thread that finishes first
    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s: Start\n", name);
        try {
            // call doTask and wait for it to finish or a InterruptedException
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Threa %s: Interrupted\n", name);
            return;
        }
        System.out.printf("Thread %s: End\n", name);
    }

    /**
     * Call the sleep method with a random number.
     */
    private void doTask() throws InterruptedException {
        Random random = new Random((new Date()).getTime());
        int value = (int)(random.nextDouble()*100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), value);
        TimeUnit.SECONDS.sleep(value);
    }


    public static void main(String[] args) {
        // create a thread group object
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        // create a SearchTask object and a Result object
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);

        // create 10 thread objects using the SearchTask object and pass it a thread group
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        // write information about the ThreadGroup object
        threadGroup.list();

        // use activeCount to know how many thread objects associated with the ThreadGroup objects
        Thread[] threads = new Thread[threadGroup.activeCount()];
        // use enumerate to get a list of active threads in thread group
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }

        waitFinish(threadGroup);

        threadGroup.interrupt();
    }

    /**
     * Use activeCount method to control the end of one of the threads.
     */
    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
