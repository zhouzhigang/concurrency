import java.util.concurrent.CompletionService;

/**
 * Report request that execute RepoetGenerator tasks.
 */
public class ReportRequest implements Runnable {

    // thread name
    private String name;

    // CompletionService
    private CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String> service) {
        this.name = name;
        this.service = service;
    }

    @Override
    public void run() {
        ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
        // send to CompletionService object using submit() method
        service.submit(reportGenerator);
    }
}


