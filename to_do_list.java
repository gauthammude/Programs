import java.util.ArrayList;
import java.util.Scanner;

public class to_do_list {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            choice = getUserChoice();
            switch (choice) {
                case 1 -> addTask();
                case 2 -> displayTasks();
                case 3 -> removeTask();
                case 4 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void showMenu() {
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid choice
        }
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added.");
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("\n--- Task List ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }

        System.out.print("Remove by (1) Index or (2) Name? ");
        String option = scanner.nextLine();

        if (option.equals("1")) {
            displayTasks();
            System.out.print("Enter task index to remove: ");
            try {
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                if (index >= 0 && index < tasks.size()) {
                    String removed = tasks.remove(index);
                    System.out.println("Removed: " + removed);
                } else {
                    System.out.println("Invalid index.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        } else if (option.equals("2")) {
            System.out.print("Enter task name to remove: ");
            String name = scanner.nextLine();
            if (tasks.remove(name)) {
                System.out.println("Removed: " + name);
            } else {
                System.out.println("Task not found.");
            }
        } else {
            System.out.println("Invalid option.");
        }
    }
}