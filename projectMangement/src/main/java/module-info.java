module hellofx {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens project.files to javafx.fxml; // Gives access to fxml files
    exports project.files;
    exports Not.in.use;
    opens Not.in.use to javafx.fxml; // Exports the class inheriting from javafx.application.Application
}