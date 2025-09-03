import java.util.HashMap;
import java.util.Map;

public class Task {
    private Map<String, String> taskInfo;

    public Task(String description, String status, String createdAt, String updatedAt) {
        taskInfo = new HashMap<>();
        taskInfo.put("description", description);
        taskInfo.put("status", status);
        taskInfo.put("createdAt", createdAt);
        taskInfo.put("updatedAt", updatedAt);

    }

    public String getDescription() {
        return taskInfo.getOrDefault("description", "");
    }

    public String getStatus() {
        return taskInfo.getOrDefault("status", "");
    }

    public String getCreatedAt() {
        return taskInfo.getOrDefault("createdAt", "");
    }

    public String getUpdatedAt() {
        return taskInfo.getOrDefault("updatedAt", "");
    }

    public boolean changeTaskInfo(String key, String value) {
        return taskInfo.replace(key, value) != null;
    }

    public boolean keyPresent(String key) {
        return taskInfo.containsKey(key);
    }
}
