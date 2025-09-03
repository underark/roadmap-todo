import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    Map<Integer, Task> allTasks;

    public TaskManager() {
        allTasks = new HashMap<>();
    }

    public void addTask(String title) {
        int i = getNewId();
        Task t = new Task(i, title);
        allTasks.put(i, t);
    }

    public int getNewId() {
        switch (allTasks.size()) {
            case 0:
                return 1;
            default:
                return Collections.max(allTasks.keySet()) + 1;
        }
    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> list = new ArrayList<>();
        allTasks.forEach((id, task) -> list.add(task));
        return list;
    }
}
