import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Controlling the interruption of a thread.
 * A Thread that look for files with a determined name in a folder and all its subfolders.
 */
public class FileSearch implements Runnable {

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        // search from the init root path
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: The search has been interrupted\n", Thread.currentThread().getName());
            }
        }
    }

    /**
     * Search file recursively.
     */
    private void directoryProcess(File file) throws InterruptedException {
        File list[] = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    /**
     * Compare the name of the file it's processing and the name we are searching for.
     */
    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("Thread: %s; File: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("/", "FileSearch.java");
        Thread thread = new Thread(searcher);
        thread.start();
        // wait for 10 seconds and interrupt the search thread
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
