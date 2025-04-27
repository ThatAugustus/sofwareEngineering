package project.files;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class User {
    private static final Map<String, Employee> employees = new HashMap<>();
    private static final CLIEngine cliEngine = new CLIEngine();

    public static void main(String[] args) throws ParseException {
        runApplication();
    }

    private static void runApplication() throws ParseException {
        int choice = cliEngine.displayChoices();

        while (choice != 9) {
            cliEngine.executeChoice(choice, employees);
            System.out.println();
            choice = cliEngine.displayChoices();
        }
    }
}

