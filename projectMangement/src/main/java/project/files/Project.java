package project.files;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Project {
    private String projectId;
    private String projectName;
    private Date deadline;
    private Employee projectManager;
    // private Customer customer;
    private Map<String, Activity> activities = new HashMap<>();

    public void addActivity(Activity activity) {
        // Add activity to the project
    }

    public void removeActivity(Activity activity) {
        // Remove activity from the project
    }

    public void assignProjectManager(Employee employee) {
        this.projectManager = employee;
    }

    public boolean isOverdue() {
        Date currentDate = new Date();
        return deadline.before(currentDate);
    }

    public boolean isCompleted() {
        // Check if all activities are completed
       return false;
    }

    public String getProjectId() {
        return projectId;
    }
}

