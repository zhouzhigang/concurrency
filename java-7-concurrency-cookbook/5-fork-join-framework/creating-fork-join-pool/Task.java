import java.util.concurrent.RecursiveAction;
import java.util.List;

public class Task extends RecursiveAction {

    // the parent class of RecursiveAcion class, The ForJoin class, implementes the Serializable interface
    private static final long serialVersionUID = 1L;

    private List<Product> products;

    // determine the divide of products this task has to process
    private int first;
    private int last;

    private double increment;


    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    public void compute() {
        if (last - first < 10) {
            updatePrices();
        } else {
            int middle = (last + first) / 2;
            System.out.printf("Task: Pending tasks: %s \n", getQueuedTaskCount());
            Task t1 = new Task(products, first, middle+1, increment);
            Task t2 = new Task(products, middle+1, last, increment);
            invokeAll(t1, t2);
        }
    }

    private void updatePrices() {
        for (int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice()*(1+increment));
        }
    }
}
