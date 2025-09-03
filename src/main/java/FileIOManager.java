import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileIOManager {
    private final JsonStringBuilder jsonStringBuilder;
    private final String fileName;
    private final TaskManager taskManager;

    public FileIOManager(TaskManager taskManager) {
        jsonStringBuilder = new JsonStringBuilder();
        fileName = "tasks.json";
        this.taskManager = taskManager;
    }

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                Task t = new Task("", "", "", "");
                line = line.replace("{", "")
                        .replace("\"", "")
                        .replace(":", ",");
                String[] lineArray = line.split(", ");
                for (int i = 0; i < lineArray.length; i++) {
                    if (t.keyPresent(lineArray[i])) {
                        t.changeTaskInfo(lineArray[i], lineArray[i + 1]);
                    }
                }
                taskManager.addTaskFromExistingData(t);
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void writeToFile() {
        ArrayList<Task> tasks = taskManager.getTasks();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Task task : tasks) {
                writer.write("{" +
                        jsonStringBuilder.getStringWithComma("description", task.getDescription()) +
                        jsonStringBuilder.getStringWithComma("status", task.getStatus()) +
                        jsonStringBuilder.getStringWithComma("createdAt", task.getCreatedAt()) +
                        jsonStringBuilder.getStringWithoutComma("updatedAt", task.getUpdatedAt()) +
                        "}" + "\n"
                );
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}