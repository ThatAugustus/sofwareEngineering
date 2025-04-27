package project.files;

import java.util.HashMap;
import java.util.Map;

public class SystemStorage {
    private static final Map<String, Employee> employees = new HashMap<>();
    private static final Map<String, Project> projects = new HashMap<>();
    private static final Map<String, Activity> activities = new HashMap<>();

    public static void addEmployee(Employee employee) {
        if (employee != null && !employees.containsKey(employee.getEmployeeId())) {
            employees.put(employee.getEmployeeId(), employee);
        }
    }

    public static Employee getEmployee(String employeeId) {
        return employees.get(employeeId);
    }

    public static Map<String, Employee> getEmployees() {
        return new HashMap<>(employees);
    }

    public static void addProject(Project project) {
        if (project != null && !projects.containsKey(project.getProjectId())) {
            projects.put(project.getProjectId(), project);
        }
    }

    public static Project getProject(String projectId) {
        return projects.get(projectId);
    }

    public static Map<String, Project> getProjects() {
        return new HashMap<>(projects);
    }

    public static void addActivity(Activity activity) {
        if (activity != null && !activities.containsKey(activity.getActivityId())) {
            activities.put(activity.getActivityId(), activity);
        }
    }

    public static Activity getActivity(String activityId) {
        return activities.get(activityId);
    }

    public static Map<String, Activity> getActivities() {
        return new HashMap<>(activities);
    }
}
