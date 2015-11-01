/**
 * Simulate a text File.
 * Producer will get content from the file.
 */
public class FileMock {

    private String content[];
    private int index;

    /**
     * Constructor: initializes the content of the file with random characters.
     */
    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int indice = (int)Math.random()*255;
                buffer.append((char)indice);
            }
            content[i] = buffer.toString();
        }
        index = 0;
    }

    /**
     * return true if the file has more lines to process,
     * or false if we have archieved the end of the simulated file.
     */
    public boolean hasMoreLines() {
        return index < content.length;
    }

    /**
     * return the line determined by the index attribute and increases its value.
     */
    public String getLine() {
        if (this.hasMoreLines()) {
            System.out.println("Mock: " + (content.length-index));
            return content[index++];
        }
        return null;
    }

}
        


