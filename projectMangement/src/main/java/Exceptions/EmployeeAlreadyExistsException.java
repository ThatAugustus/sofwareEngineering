package Exceptions;
import java.lang.Exception;

public class EmployeeAlreadyExistsException extends Exception {

    private static final String DEFAULT_MESSAGE = "Employee ID already exists.";

    public EmployeeAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    public EmployeeAlreadyExistsException(String employeeId) {
        super("Employee ID " + employeeId + " already exists.");
    }

    public EmployeeAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlreadyExistsException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }
}