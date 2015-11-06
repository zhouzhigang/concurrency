import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

/**
 * Search Job.
 * Each thread will handle some rows.
 */
public class Searcher implements Runnable {

    // the row range for current thread
    private int firstRow;
    private int lastRow;
    private MatrixMock mock;
    private Results results;
    private int number;// number to search
    private final CyclicBarrier barrier;

    public Searcher(int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.printf("%s: Processing lines form %d to %d.\n", Thread.currentThread().getName(), firstRow, lastRow);
        // process all the rows assigned to this thread
        for (int i = firstRow; i < lastRow; i++) {
            int row[] = mock.getRow(i);
            int counter = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == number) {
                    counter++;
                }
            }
            // update the result for each row
            results.setData(i, counter);
        }
        System.out.printf("%s: Lines processed.\n", Thread.currentThread().getName());
        // call the await method of the CyclicBarrier object(need catch BrokenBarrierException)
        try {
            barrier.await();
            // it will auto execute the runnable thread(passed to barrier in the constructer) after all threads finished
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
