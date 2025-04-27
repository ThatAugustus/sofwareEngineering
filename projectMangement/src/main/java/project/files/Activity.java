package project.files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Activity {
   private final String activityId;
   private String activityName;
   private Project activitiesAssignedProject;
   private String activityStatus;
   //private Activity activityType;
   private double budgetedHours;
   private double currentSpentHours;
   private LocalDate startDate;
   private LocalDate endDate;
   private List<Employee> assignedEmployees;
   private List<TimeRegistration> timeRegistrations = new ArrayList<>();


   public Activity(String activityName, String activityStatus, LocalDate startDate, LocalDate endDate) {
    this.activityName = activityName;
    this.activityStatus = activityStatus;
    this.startDate = startDate;
    this.endDate = endDate;
    this.activityId = generateActivityId();
   }

   public Activity(String activityName, String activityStatus, LocalDate startDate, LocalDate endDate, double budgetedHours) {
    this.activityName = activityName;
    this.activityStatus = activityStatus;
    this.startDate = startDate;
    this.endDate = endDate;
    this.budgetedHours = budgetedHours;
    this.activityId = generateActivityId();
   }

   public Activity(String activityName, LocalDate startDate, LocalDate endDate, double budgetedHours) {
    this.activityName = activityName;
    this.startDate = startDate;
    this.endDate = endDate;
    this.budgetedHours = budgetedHours;
    this.activityId = generateActivityId();
   }

    // Test-only constructor
    Activity(String activityId, String activityName, String activityStatus, LocalDate startDate, LocalDate endDate, double budgetedHours) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityStatus = activityStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budgetedHours = budgetedHours;
    }

   public void assignEmployee(Employee employee) {
       assignedEmployees.add(employee);
   }
    public void removeEmployee(Employee employee) {
         assignedEmployees.remove(employee);
    }
    public void assignProject(Project project) {
        this.activitiesAssignedProject = project;
    }
    public void removeProject() {
        this.activitiesAssignedProject = null;
    }
    public void setBudgetedHours(double hours) {
        this.budgetedHours = hours;
    }
    public void setCurrentSpentHours(double hours) {
        this.currentSpentHours = hours;
    }
    public void setStartDate(LocalDate date) {
        this.startDate = date;
    }
    public void setEndDate(LocalDate date) {
        this.endDate = date;
    }
    public void setActivityName(String name) {
        this.activityName = name;
    }
    public void setActivityId(String id) {
        // this.activityId = id; // activityId is final, cannot be changed
    }
    private String generateActivityId() {
        return UUID.randomUUID().toString();
    }


    public void addTimeRegistration(TimeRegistration timeRegistration) {
        timeRegistrations.add(timeRegistration);
    }


    // Getters and Setters
    public String getActivityId() {
        return activityId;
    }
    public String getActivityName() {
        return activityName;
    }
    public String getActivityStatus() {
        return activityStatus;
    }
    public double getBudgetedHours() {
        return budgetedHours;
    }
    public double getCurrentSpentHours() {
        return currentSpentHours;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public Project getActivitiesAssignedProject() {
        return activitiesAssignedProject;
    }
    public List<Employee> getAssignedEmployees() {
        return assignedEmployees;
    }
    public void setAssignedEmployees(List<Employee> assignedEmployees) {
        this.assignedEmployees = assignedEmployees;
    }
    public void setActivitiesAssignedProject(Project activitiesAssignedProject) {
        this.activitiesAssignedProject = activitiesAssignedProject;
    }
    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }
    public boolean isOverdue() {
        LocalDate currentDate = LocalDate.now();
        return endDate.isBefore(currentDate);
    }
    public boolean isCompleted() {
        return activityStatus.equals("Completed");
    }
    public boolean isInProgress() {
        return activityStatus.equals("In Progress");
    }
    public boolean isNotStarted() {
        return activityStatus.equals("Not Started");
    }
    public boolean isOnHold() {
        return activityStatus.equals("On Hold");
    }
    public boolean isCancelled() {
        return activityStatus.equals("Cancelled");
    }   
    


    
}

