package dtu.example.ui;

public class TimeRegistration {

    private String employeeId;
    private String projectId;
    private String activityId;
    private double hoursWorked;
    private String date;

    public TimeRegistration(String employeeId, String projectId, String activityId, double hoursWorked, String date) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.activityId = activityId;
        this.hoursWorked = hoursWorked;
        this.date = date;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getActivityId() {
        return activityId;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public String getDate() {
        return date;
    }
}
