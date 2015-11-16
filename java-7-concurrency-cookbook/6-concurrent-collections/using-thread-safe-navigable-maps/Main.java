import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.Map;

/**
 * Using thread-safe navigable maps.
 * Useing ConcurrentSkipListMap to implement a map of contacts.
 */
public class Main {
    public static void main(String[] args) {

        ConcurrentSkipListMap<String, Contact> map;
        map = new ConcurrentSkipListMap<String, Contact>();

        Thread threads[] = new Thread[25];
        int counter = 0;
        // create and lanunch task objects
        for (char i = 'A'; i < 'Z'; i++) {
            Task task = new Task(map, String.valueOf(i));
            threads[counter] = new Thread(task);
            threads[counter].start();
            counter++;
        }

        // wait for finalization of threads
        for (int i = 0; i < 25; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Size of the map: %d\n", map.size());

        Map.Entry<String, Contact> element;
        Contact contact;

        // get the first entry of the map
        element = map.firstEntry();
        contact = element.getValue();
        System.out.printf("Main: First Entry: %s: %s\n", contact.getName(), contact.getPhone());

        // get the last entry of the map
        element = map.lastEntry();
        contact = element.getValue();
        System.out.printf("Main: last Entry: %s: %s\n", contact.getName(), contact.getPhone());

        // get a submap of the map
        System.out.printf("Main: Submap for A1996 to B1002: \n");
        ConcurrentNavigableMap<String, Contact> submap = map.subMap("A1996", "B1002");
        do {
            element = submap.pollFirstEntry();
            if (element != null) {
                contact = element.getValue();
                System.out.printf("%s: %s\n", contact.getName(), contact.getPhone());
            }
        } while (element != null);

    }
}
