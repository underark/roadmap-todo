public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        switch (args[0]) {
            case "add":
                taskManager.addTask(args[1]);
                break;
            default:
                System.out.println("Unrecognized");
        }

        taskManager.getTasks().forEach(task -> System.out.println(task.getDescription()));
    }
}
