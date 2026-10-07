import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    public void addTask(Task task) {
        tasks.add(task);
    }
    public List<Task> getAllTasks() {
        return tasks;
    }
    public Task findById(String id) {
        for (Task t : tasks) {
            if (t.getId().equalsIgnoreCase(id)) {
                return t;
            }
        }
        return null;
    }
    public boolean markAsCompleted(String id) {
        Task task = findById(id);
        if (task != null && !task.isCompleted()) {
            task.setCompleted(true);
            return true;
        }
        return false;
    }
    public List<Task> getPendingTasks() {
        List<Task> pending = new ArrayList<>();
        for (Task t : tasks) {
            if (!t.isCompleted()) {
                pending.add(t);
            }
        }
        return pending;
    }
}