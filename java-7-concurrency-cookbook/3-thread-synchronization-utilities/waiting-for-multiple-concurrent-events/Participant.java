import java.util.concurrent.TimeUnit;

/**
 * Simulate the Participant.
 */
public class Participant implements Runnable {

    private VideoConference conference;

    private String name;

    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        // wait a moment
        long duration = (long)(Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // use arrive method of VideoConference indicate the arrical of the participant
        conference.arrive(name);
    }
}
