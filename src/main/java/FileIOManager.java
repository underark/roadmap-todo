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
                if (line.contentEquals("[") || line.contentEquals("]")) {
                    line = reader.readLine();
                    continue;
                }
                // Creating an 'empty' task so that the map in the task is ready to compare keys against later
                Task t = new Task("", "", "", "");
                String[] noJsonLine = jsonStringBuilder.deJsonify(line);
                for (int i = 0; i < noJsonLine.length; i++) {
                    if (t.keyPresent(noJsonLine[i])) {
                        t.changeTaskInfo(noJsonLine[i], noJsonLine[i + 1]);
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
            writer.write("[" + "\n");
            for (Task task : tasks) {
                // Trailing commas aren't allowed in the official json standard
                if (tasks.indexOf(task) != tasks.size() - 1) {
                    writer.write("{" + jsonStringBuilder.getJsonLine(task.getDescription(), task.getStatus(),
                                    task.getCreatedAt(), task.getUpdatedAt()) + "}," + "\n"
                    );
                } else {
                    writer.write("{" + jsonStringBuilder.getJsonLine(task.getDescription(), task.getStatus(),
                                    task.getCreatedAt(), task.getUpdatedAt()) + "}" + "\n"
                    );
                }
            }
            writer.write("]" + "\n");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}