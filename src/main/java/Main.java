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
                if (args[1].contentEquals("done")) {
                    taskManager.getDoneTasks().forEach((id, task) -> System.out.println(id + " " + task.getDescription()));
                } else if (args[1].contentEquals("in-progress")) {
                    taskManager.getInProgressTasks().forEach((id, task) -> System.out.println(id + " " + task.getDescription()));
                } else if (args[1].contentEquals("todo")) {
                    taskManager.getToDoTasks().forEach((id, task) -> System.out.println(id + " " + task.getDescription()));
                } else {
                    taskManager.getAllTasks().forEach((id, task) -> System.out.println(id + " " + task.getDescription()));
                }
                break;
            case "update":
                if (taskManager.updateTask(Integer.parseInt(args[1]), args[2])) {
                    System.out.println("Updated successfully");
                    break;
                }
                System.out.println("task-cli update <ID> \"description\"");
                System.out.println("ID must be valid");
                return;
            case "delete":
                if (taskManager.deleteTask(Integer.parseInt(args[1]))) {
                    System.out.println("Task removed successfully");
                    break;
                }
                System.out.println("task-cli delete <ID>");
                System.out.println("ID must be valid");
                return;
            case "mark-in-progress":
                if (taskManager.updateCompletion(Integer.parseInt(args[1]), "in-progress")) {
                    System.out.println("Marked in-progress successfully");
                    break;
                }
                System.out.println("task-cli mark-in-progress <ID>");
                System.out.println("ID must be valid");
                return;
            case "mark-done":
                if (taskManager.updateCompletion(Integer.parseInt(args[1]), "done")) {
                    System.out.println("Marked done successfully");
                    break;
                }
                System.out.println("task-cli mark-in-progress <ID>");
                System.out.println("ID must be valid");
                return;
            default:
                System.out.println("Unrecognized");
        }
        fileIOManager.writeToFile();
    }
}
