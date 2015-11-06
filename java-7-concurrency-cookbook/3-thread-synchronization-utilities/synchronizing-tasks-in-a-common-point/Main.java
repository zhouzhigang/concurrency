import java.util.concurrent.CyclicBarrier;

/**
 * Synchronizing tasks in a common point.
 *
 */
public class Main {

    public static void main(String[] args) {

        final int ROWS = 10000; // rows of the matrix
        final int NUMBERS = 1000; // length of the matrix
        final int SEARCH = 5; // the number to search
        final int PARTICIPANTS = 5; // the number of threads
        final int LINES_PARTICIPANT = ROWS / PARTICIPANTS; // the rows each thread should handle

        // create the matrix and result
        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
        Results results = new Results(ROWS);
        // calculate the final result after all thread finished
        Grouper groups = new Grouper(results);
        // create a CyclicBarrier(first param is the number of the threads need to wait, second Runnable will be execute after the thread finish)
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, groups);
        // create multiple threads to search the number
        Searcher[] searchers = new Searcher[PARTICIPANTS];
        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new Searcher(i*LINES_PARTICIPANT, (i*LINES_PARTICIPANT)+LINES_PARTICIPANT,
                                        mock, results, SEARCH, barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.printf("Main: The main thread has finished.\n");
    }
}
