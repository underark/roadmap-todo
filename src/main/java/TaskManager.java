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
        String updatedAt = new Date().toString();
        Task oldValue = allTasks.replace(id, new Task(description, status, createdAt, updatedAt));
        return oldValue != null;
    }

    public boolean updateCompletion(int id, String completion) {
        Task t = getTaskById(id);
        boolean result = t.changeTaskInfo("status", completion);
        if (result) {
            t.changeTaskInfo("updatedAt", new Date().toString());
        }
        return result;
    }

    public boolean deleteTask(int id) {
        Task t = getTaskById(id);
        return allTasks.remove(id, t);
    }

    public int getNewId() {
        if (allTasks.isEmpty()) {
            return 1;
        }
        return Collections.max(allTasks.keySet()) + 1;
    }

    public Map<Integer, Task> getAllTasks() {
        return allTasks;
    }

    public Map<Integer, Task> getDoneTasks() {
        Map<Integer, Task> doneTasks = new HashMap<>();
        getAllTasks().forEach((id, task) -> {
            if (task.getStatus().contentEquals("done")) doneTasks.put(id, task);
        });
        return doneTasks;
    }

    public Map<Integer, Task> getToDoTasks() {
        Map<Integer, Task> todoTasks = new HashMap<>();
        getAllTasks().forEach((id, task) -> {
            if (task.getStatus().contentEquals("todo")) todoTasks.put(id, task);
        });
        return todoTasks;
    }

    public Map<Integer, Task> getInProgressTasks() {
        Map<Integer, Task> inProgressTasks = new HashMap<>();
        getAllTasks().forEach((id, task) -> {
            if (task.getStatus().contentEquals("in-progress")) inProgressTasks.put(id, task);
        });
        return inProgressTasks;
    }

    private Task getTaskById(int id) {
        return allTasks.getOrDefault(id, new Task("", "", "", ""));
    }
}
