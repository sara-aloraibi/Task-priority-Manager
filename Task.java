import java.time.LocalDate;
public class Task {
    public enum Priority { HIGH, MEDIUM, LOW }
    private final String id;
    private final String title;
    private final Priority priority;
    private final LocalDate dueDate;
    private boolean completed;
    public Task(String id, String title, Priority priority, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.dueDate = dueDate;
        this.completed = false;
    }
    public String getId() { return id; }
    public String getTitle() { return title; }
    public Priority getPriority() { return priority; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    @Override
    public String toString() {
        return String.format("[%s] %s | Priority: %s | Due: %s | Status: %s",
                id, title, priority, dueDate, completed ? "Completed" : "Pending");
    }
}