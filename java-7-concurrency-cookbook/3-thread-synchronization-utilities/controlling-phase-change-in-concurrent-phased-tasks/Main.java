/**
 * Controlling phase change in concurrent phased tasks.
 */
public class Main {
    public static void main(String[] args) {
        
        // Needn't specify the number of participants(use register instead)
        MyPhaser phaser = new MyPhaser();

        // Create Student object and register them in the phaser
        Student students[] = new Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(phaser);
            // register the participant in the phaser
            phaser.register();
        }
        
        // Create threads and start them
        Thread threads[] = new Thread[students.length];
        for (int i = 0; i < students.length; i++) {
            threads[i] = new Thread(students[i], "Student " + i);
            threads[i].start();
        }

        // Wait for finalization
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: The phaser has finished: %s.\n", phaser.isTerminated());
    }
}
