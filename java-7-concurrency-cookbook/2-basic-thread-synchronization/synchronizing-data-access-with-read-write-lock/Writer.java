/**
 * Modify the value of PricesInfo class attributes.
 */
public class Writer implements Runnable {

    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        // modify the value 3 times and sleep for 2 seconds between modification
        for (int i = 0; i < 3; i++) {
            System.out.printf("Writer: Attempt to modify the prices.\n");
            pricesInfo.setPrices(Math.random()*10, Math.random()*8);
            System.out.printf("Writer: Prices have been modified.\n");
            // sleep for a moment so that reader can get these changes
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
