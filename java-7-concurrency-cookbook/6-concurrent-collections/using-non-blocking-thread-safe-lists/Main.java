import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    public static void main(String[] args) {

        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<String>();

        Thread threads[] = new Thread[100];

        // create 100 AddTask objects and threads
        for (int i = 0; i < threads.length; i++) {
            AddTask task = new AddTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);

        // wait for the completion of the threads using the join() method
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the List: %d\n", list.size());

        // create 100 PollTask objects and threads
        for (int i = 0; i < threads.length; i++) {
            PollTask task = new PollTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d PollTask threads have been launched\n", threads.length);

        // wait for the completion of the threads using the join() method
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the List: %d\n", list.size());
    }

}
