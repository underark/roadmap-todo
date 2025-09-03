public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        FileIOManager fileIOManager = new FileIOManager(taskManager);
        fileIOManager.readFromFile();

        switch (args[0]) {
            case "add":
                if (args.length < 2) {
                    System.out.println("task-cli add \"description\"");
                    return;
                }
                taskManager.addNewTask(args[1]);
                System.out.println("Task added succesfully (ID: " + (taskManager.getNewId() - 1) + ")");
                break;
            case "list":
                taskManager.getTasks().forEach(task -> System.out.println(task.getDescription()));
                break;
//            case "update":
//                if (taskManager.updateTask(Integer.parseInt(args[1]), args[2])) {
//                    System.out.println("Updated successfully");
//                    return;
//                }
//                System.out.println("task-cli update <ID> \"description\"");
//                break;
            default:
                System.out.println("Unrecognized");
        }
        fileIOManager.writeToFile();
    }
}
