import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void displayTasks() {
        System.out.println("Current Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void markTaskCompleted(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            System.out.println("Task \"" + tasks.get(taskIndex) + "\" marked as completed.");
            tasks.remove(taskIndex);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    todoList.addTask(taskDescription);
                    break;
                case 2:
                    todoList.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter the index of the task to mark as completed: ");
                    int taskIndex = scanner.nextInt() - 1;
                    todoList.markTaskCompleted(taskIndex);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
