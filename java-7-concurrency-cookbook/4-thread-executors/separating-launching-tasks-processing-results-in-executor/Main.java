import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.TimeUnit;

/**
 * Separating the launching of tasks and the processing of their results in an executor.
 */
public class Main {
    public static void main(String[] args) {
        // create ThreadPoolExecutor
        ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();

        // create CompletionService using the executor as a paramter of the constructor
        CompletionService<String> service = new ExecutorCompletionService<String>(executor);
        
        // create two ReportRequest that process ReportGenerator tasks
        ReportRequest faceRequest = new ReportRequest("Face", service);
        ReportRequest onlineRequest = new ReportRequest("Online", service);
        Thread faceThread = new Thread(faceRequest);
        Thread onlineThread = new Thread(onlineRequest);

        // createa a ReportProcessor that process the result
        ReportProcessor processor = new ReportProcessor(service);
        Thread senderThread = new Thread(processor);

        // start the threads
        System.out.printf("Main: Starting the Thread\n");
        faceThread.start();
        onlineThread.start();
        senderThread.start();

        // wait for finalization of the ReportRequest threads
        try {
            System.out.printf("Main: Waiting for the report generators.\n");
            faceThread.join();
            onlineThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // finish the executor
        System.out.printf("Main: Shutting down the executor.\n");
        executor.shutdown();
        // wait for the finalization of the tasks
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // finish the execution of the ReportSender object
        processor.setEnd(true);
        System.out.println("Main: Ends");
    }
}
