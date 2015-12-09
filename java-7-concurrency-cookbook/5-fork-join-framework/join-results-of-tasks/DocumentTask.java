import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.ArrayList;

public class DocumentTask extends RecursiveTask<Integer> {

    private String document[][];
    private int start, end;
    private String word;

    public DocumentTask(String document[][], int start, int end, String word) {
        this.document = document;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (end -start < 10) {
            result = processLines(document, start, end, word);
        } else {
            // divide the group of lines in two objects
            int mid = (start + end) / 2;
            DocumentTask task1 = new DocumentTask(document, start, mid, word);
            DocumentTask task2 = new DocumentTask(document, mid, end, word);
            invokeAll(task1, task2);

            // add the values returned by both tasks 
            try {
                result = groupResults(task1.get(), task2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Integer processLines(String[][] document, int start, int end, String word) {
        List<LineTask> tasks = new ArrayList<LineTask>();
        for (int i = start; i < end; i++) {
            LineTask task = new LineTask(document[i], 0, document[i].length, word);
            tasks.add(task);
        }
        // execute all the tasks using invokeAll() method
        invokeAll(tasks);

        // sum the value returned by all the tasks and return the result
        int result = 0;
        for (int i = 0; i < tasks.size(); i++) {
            LineTask task = tasks.get(i);
            try {
                result = result + task.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return new Integer(result);
    }

    private Integer groupResults(Integer number1, Integer number2) {
        Integer result;
        result = number1 + number2;
        return result;
    }
}
