import java.util.*;

public class TaskManager {
    Map<Integer, Task> allTasks;

    public TaskManager() {
        allTasks = new HashMap<>();
    }

    public void addNewTask(String description) {
        int i = getNewId();
        String currentDate = new Date().toString();
        Task t = new Task(description, "todo", currentDate, currentDate);
        allTasks.put(i, t);
    }

    public void addTaskFromExistingData(Task task) {
        allTasks.put(getNewId(), task);
    }

    public boolean updateTask(int id, String description) {
        Task t = getTaskById(id);
        String status = t.getStatus();
        String createdAt = t.getCreatedAt();
        String updatedAt = t.getUpdatedAt();
        Task oldValue = allTasks.replace(id, new Task(description, status, createdAt, updatedAt));
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

    private Task getTaskById(int id) {
        return allTasks.getOrDefault(id, new Task("", "", "", ""));
    }
}
