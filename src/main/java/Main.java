public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        switch (args[0]) {
            case "add":
                if (args.length < 2) {
                    System.out.println("task-cli add \"description\"");
                    return;
                }
                taskManager.addTask(args[1]);
                System.out.println("Task added succesfully (ID: " + (taskManager.getNewId() - 1) + ")");
                break;
            case "update":
                if (taskManager.updateTask(Integer.parseInt(args[1]), args[2])) {
                    System.out.println("Updated successfully");
                    return;
                }
                System.out.println("task-cli update <ID> \"description\"");
                break;
            default:
                System.out.println("Unrecognized");
        }
        FileIOManager fileIOManager = new FileIOManager(taskManager.getTasks());
        fileIOManager.writeToFile();
    }
}
