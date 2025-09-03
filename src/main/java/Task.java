import java.util.Date;

public class Task {
    private int id;
    private String description;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        status = "todo";
        createdAt = new Date();
        updatedAt = new Date();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void changeCompletion(String newStatus) {
        status = newStatus;
    }

    public String getCreatedAt() {
        return createdAt.toString();
    }

    public String getUpdatedAt() {
        return updatedAt.toString();
    }
}
