import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    Map<Integer, Task> allTasks;

    public TaskManager() {
        allTasks = new HashMap<>();
    }

    public void addTask(String description) {
        int i = getNewId();
        Task t = new Task(i, description);
        allTasks.put(i, t);
    }

    public boolean updateTask(int id, String description) {
        Task oldValue = allTasks.replace(id, new Task(id, description));
        return oldValue != null;
    }

    public int getNewId() {
        if (allTasks.isEmpty()) {
            return 1;
        }
        return Collections.max(allTasks.keySet()) + 1;
    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> list = new ArrayList<>();
        allTasks.forEach((id, task) -> list.add(task));
        return list;
    }
}
