import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Creating a Fork/Join pool.
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        // generate products
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(10000);
        // Task(extends RecursiveAction) to update all products
        Task task = new Task(products, 0, products.size(), 0.20);
        // Create a ForkJoinPool and execute the task
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);

        // show information about the evolution of the pool every five milliseconds
        do {
            System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Thread Steal: %d\n", pool.getStealCount());
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());

            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        // shutdown the pool
        pool.shutdown();

        if (task.isCompletedNormally()) {
            System.out.printf("Main: The process has completed normally.\n");
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getPrice() != 12) {
                System.out.printf("Product %s: %f\n", product.getName(), product.getPrice());
            }
        }

        System.out.println("Main: End of the program.\n");
    }
}
