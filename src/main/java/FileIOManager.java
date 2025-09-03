import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileIOManager {
    private final JsonStringBuilder stringBuilder;
    private final String fileName;
    private final ArrayList<Task> tasks;

    public FileIOManager(ArrayList<Task> tasks) {
        stringBuilder = new JsonStringBuilder();
        fileName = "tasks.json";
        this.tasks = tasks;
    }

    public void readFromFile(String fileName) {

    }

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Task task : tasks) {
                writer.write("{" +
                        stringBuilder.getStringWithComma("description", task.getDescription()) +
                        stringBuilder.getStringWithComma("status", task.getStatus()) +
                        stringBuilder.getStringWithComma("createdAt", task.getCreatedAt()) +
                        stringBuilder.getStringWithoutComma("updatedAt", task.getUpdatedAt()) +
                        "}"
                );
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}