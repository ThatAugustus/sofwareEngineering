package hellocucumber;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.*;

import Exceptions.EmployeeAlreadyExistsException;
import dtu.example.ui.CLIEngine;
import dtu.example.ui.Employee;
import io.cucumber.java.en.*;

public class ProjectSteps {
	
	CLIEngine cliEngine = new CLIEngine();
	Map<String, Employee> employees = new HashMap<>(); // List to store employees
	int choice = 1;
	String nameStr, surnameStr, employeeIdStr;
	boolean state;
	
	@When("an employee is created with name {string}, surname {string} and ID {string}")
	public void anEmployeeIsCreatedWithName(String name, String surname, String employeeId) {
		cliEngine.createNewEmployee(employees, name, surname, employeeId);
	}
	
	
	@Then("show the list of employees contains an employee with that name, surname and ID")
	public void theListOfEmployeesContainsAnEmployeeWithThatNameSurnameAndID() {
		cliEngine.createNewEmployee(employees, "John", "Smith", "jhsm");
		cliEngine.createNewEmployee(employees, "Anne", "Andersen", "anan");
		cliEngine.getlistOfEmployees(employees);
	    
	}
	
	@Given("employee with name {string}, surname {string} and ID {string} exists")
	public void employeeWithNameSurnameAndID(String firstname, String surname, String employeeId) throws EmployeeAlreadyExistsException {
		cliEngine.createNewEmployee(employees, firstname, surname, employeeId);
	    assertTrue(cliEngine.isEmployeeIdInUse(employeeId, employees));
	}
	
	@When("an employee is created with name {string}, surname {string} and a used ID {string}")
	public void anEmployeeIsCreatedWithNameSurnameAndAUsedID(String firstname, String surname, String employeeId) {
		nameStr = firstname;
		surnameStr = surname;
		employeeIdStr = employeeId;
		cliEngine.createNewEmployee(employees, firstname, surname, employeeId);
	}

	@Then("the system will return an error message.")
	public void theSystemWillReturnAnErrorMessage() {
		// Capture the output of System.out
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		// Call the method
		cliEngine.createNewEmployee(employees, nameStr, surnameStr, employeeIdStr);

		// Restore System.out
		System.setOut(System.out);

		// Assert that the output contains the expected error message
		String expectedMessage = "Employee Id already exists. Please find another id.";
		assertTrue(outContent.toString().contains(expectedMessage), "Expected error message not found in output.");
	}
	
	@When("an employee with ID {string} add activity with ID {string}, name {string}, start date {string}, end date {string}, budget hours {int} and status {string}")
	public void anEmployeeWithIDAddActivityWithIDNameStartDateEndDateBudgetHoursAndStatus(String employeeId,
																						  String activityId,
																						  String activityName,
																						  String startDateStr,
																						  String endDateStr,
																						  int activityBudgtedhour,
																						  String activityStatus) throws ParseException {
		cliEngine.createNewEmployee(employees, "Hubert", "Baumeister", "huba");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//LocalDate startDate = sdf.parse(startDateStr);
		LocalDate startDate = LocalDate.parse(startDateStr, timeFormatter);

		//Date endDate = sdf.parse(endDateStr);
		LocalDate endDate = LocalDate.parse(endDateStr, timeFormatter);

		cliEngine.addNewActivityToProject(employees, employeeId, activityId, activityName, startDate, endDate, activityBudgtedhour, activityStatus);
		
		startDate = LocalDate.parse("2025-04-22", timeFormatter);
		endDate = LocalDate.parse("2025-04-23", timeFormatter);
		cliEngine.addNewActivityToProject(employees, employeeId, "ana2", "analysis", startDate, endDate, 2, "in progross");
		
		startDate = LocalDate.parse("2025-04-18", timeFormatter);
		endDate = LocalDate.parse("2025-04-22", timeFormatter);
		cliEngine.addNewActivityToProject(employees, employeeId, "des1", "design", startDate, endDate, 4, "completed");
	}

	@Then("show the list of activities for the employee with ID {string}")
	public void showTheListOfActivities(String employeeId) {
		System.out.println("");
		cliEngine.displayActivites(employeeId, employees);	   
	}
	
	
	@Given("an employee with ID {string} exits")
	public void anEmployeeWithNameSurnameAndIDHubaExits(String employeeId) throws ParseException {
		cliEngine.createNewEmployee(employees, "Hubert", "Baumeister", "huba");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse("2025-04-21", timeFormatter);
		//Date endDate = sdf.parse("2025-04-23");
		LocalDate endDate = LocalDate.parse("2025-04-23", timeFormatter);
		cliEngine.addNewActivityToProject(employees, employeeId, "ana2", "analysis", startDate, endDate, 2, "in progross");

		//startDate = sdf.parse("2025-04-22");
		startDate = LocalDate.parse("2025-04-22", timeFormatter);
		//endDate = sdf.parse("2025-04-23");
		endDate = LocalDate.parse("2025-04-23", timeFormatter);
		cliEngine.addNewActivityToProject(employees, employeeId, "ana2", "analysis", startDate, endDate, 2, "in progross");
		
		//startDate = sdf.parse("2025-04-18");
		startDate = LocalDate.parse("2025-04-18", timeFormatter);
		//endDate = sdf.parse("2025-04-22");
		endDate = LocalDate.parse("2025-04-22", timeFormatter);
		cliEngine.addNewActivityToProject(employees, employeeId, "des1", "design", startDate, endDate, 4, "completed");
		
		assertFalse(state);
	}

	@When("the user select the employee with ID {string}")
	public void theUserSelectTheEmployeeWithID(String string) {
		assertFalse(state);	    
	}

	@Then("the system should display the number of activities that are not finished and the list of activites for the employee with ID {string}")
	public void theSystemShouldDisplayTheNumberOfActivitiesThatAreNotFinishedAndTheListOfActivitesForTheEmployee(String employeeId) {
		int numberOfNotCompletedActivities = cliEngine.getNumberOfNotCompletedActivities(employees, employeeId);
		System.out.println("\nNumber of not completed activites: " + numberOfNotCompletedActivities);
	    
	}
}


