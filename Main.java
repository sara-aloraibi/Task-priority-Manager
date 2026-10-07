import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner sc = new Scanner(System.in);
        // Initial sample data
        manager.addTask(new Task("T01", "Submit Software Assignment", Task.Priority.HIGH, LocalDate.now().plusDays(2)));
        manager.addTask(new Task("T02", "Review Linear Algebra Notes", Task.Priority.MEDIUM, LocalDate.now().plusDays(5)));
        boolean running = true;
        while (running) {
            System.out.println("\n--- Student Task Manager ---");
            System.out.println("1. View All Tasks");
            System.out.println("2. View Pending Tasks");
            System.out.println("3. Add New Task");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Exit");
            System.out.print("Select option: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    if (manager.getAllTasks().isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        manager.getAllTasks().forEach(System.out::println);
                    }
                }
                case "2" -> {
                    var pending = manager.getPendingTasks();
                    if (pending.isEmpty()) {
                        System.out.println("No pending tasks.");
                    } else {
                        pending.forEach(System.out::println);
                    }
                }
                case "3" -> {
                    System.out.print("Task ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Title: ");
                    String title = sc.nextLine().trim();
                    System.out.print("Priority (HIGH, MEDIUM, LOW): ");
                    Task.Priority priority;
                    try {
                        priority = Task.Priority.valueOf(sc.nextLine().trim().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        priority = Task.Priority.LOW;
                    }
                    System.out.print("Due Date (YYYY-MM-DD): ");
                    LocalDate date;
                    try {
                        date = LocalDate.parse(sc.nextLine().trim());
                    } catch (DateTimeParseException e) {
                        date = LocalDate.now().plusDays(1);
                    }
                    manager.addTask(new Task(id, title, priority, date));
                    System.out.println("Task added successfully.");
                }
                case "4" -> {
                    System.out.print("Enter Task ID: ");
                    String id = sc.nextLine().trim();
                    if (manager.markAsCompleted(id)) {
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("Task not found or already completed.");
                    }
                }
                case "5" -> {
                    running = false;
                    System.out.println("Session closed.");
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
        sc.close();
    }
}