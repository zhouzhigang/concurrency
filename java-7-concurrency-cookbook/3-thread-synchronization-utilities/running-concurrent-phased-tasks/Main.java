import java.util.concurrent.Phaser;

public class Main {

    public static void main(String[] args) {
        
        Phaser phaser = new Phaser(3);

        String[] folders = {"/etc", "/var/log", "/dev/log"};
        String[] extensions = {"log", "log", "log"};

        Thread[] threads = new Thread[folders.length];
        for (int i = 0; i < folders.length; i++) {
            FileSearch search = new FileSearch(folders[i], extensions[i], phaser);
            threads[i] = new Thread(search, "FileSearch " + i);
            threads[i].start();
        }

        // wait for the finialization of these threads
        try {
            threads[0].join();
            threads[1].join();
            threads[2].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Terminated: " + phaser.isTerminated());

    }
}
