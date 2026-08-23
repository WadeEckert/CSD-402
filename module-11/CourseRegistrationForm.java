/* Author: Wade Eckert
 * Course: CSD 402 - Java for Programmers
 * Professor: Professor Darrell Payne
 * Assignment: Module 11.2 - JavaFX Course Registration Form
 * Date: August 22, 2026
 *
 * Description:
 * This program demonstrates how BorderPane and GridPane can work
 * together in a JavaFX application. BorderPane organizes the main sections
 * of the window, while GridPane arranges the controls in a registration form.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CourseRegistrationForm extends Application {

    @Override
    public void start(Stage stage) {

        /*
         * BorderPane is the root layout for the scene. It divides a window into
         * top, bottom, left, right, and center regions. This program uses the top
         * for the title, the center for the form, and the bottom for feedback.
         */
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        // Create the heading and place it in the top region of the BorderPane.
        Label titleLabel = new Label("Course Registration Form");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        BorderPane.setMargin(titleLabel, new Insets(0, 0, 20, 0));
        root.setTop(titleLabel);

        /*
         * GridPane places controls into rows and columns. The labels use column
         * zero, and the input controls use column one. Horizontal and vertical
         * gaps keep the form from looking crowded.
         */
        GridPane formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(12);
        formGrid.setVgap(12);
        formGrid.setPadding(new Insets(10));

        /*
         * The first column stays wide enough for the labels. The second column
         * is allowed to grow, so the input controls can use extra window space.
         */
        ColumnConstraints labelColumn = new ColumnConstraints();
        ColumnConstraints inputColumn = new ColumnConstraints();
        inputColumn.setHgrow(Priority.ALWAYS); // Allow the second column to grow with the window.
        inputColumn.setFillWidth(true); // Ensure that the input controls fill the available width.
        formGrid.getColumnConstraints().addAll(labelColumn, inputColumn);

        // Create the fields that collect the student's name and identification number.
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your full name");
        nameField.setMaxWidth(Double.MAX_VALUE); // Allow the TextField to expand to fill the available width.

        TextField idField = new TextField();
        idField.setPromptText("Enter your student ID");
        idField.setMaxWidth(Double.MAX_VALUE); // Allow the TextField to expand to fill the available width.

        // ComboBox controls limit the course and term entries to the available choices.
        ComboBox<String> courseBox = new ComboBox<>();
        courseBox.getItems().addAll(
                "Java Programming",
                "Web Development",
                "Database Development");
        courseBox.setPromptText("Select a course");
        courseBox.setMaxWidth(Double.MAX_VALUE); // Allow the ComboBox to expand to fill the available width.

        ComboBox<String> termBox = new ComboBox<>();
        termBox.getItems().addAll("Fall 2026", "Winter 2027", "Spring 2027");
        termBox.setPromptText("Select a term");
        termBox.setMaxWidth(Double.MAX_VALUE); // Allow the ComboBox to expand to fill the available width.

        /*
         * Each call to add() uses a column index followed by a row index. JavaFX
         * starts both indexes at zero, so the name label begins in column 0, row 0.
         */
        formGrid.add(new Label("Student Name:"), 0, 0);
        formGrid.add(nameField, 1, 0);
        formGrid.add(new Label("Student ID:"), 0, 1);
        formGrid.add(idField, 1, 1);
        formGrid.add(new Label("Course:"), 0, 2);
        formGrid.add(courseBox, 1, 2);
        formGrid.add(new Label("Term:"), 0, 3);
        formGrid.add(termBox, 1, 3);

        // Add the action buttons to the final row of the GridPane.
        Button clearButton = new Button("Clear");
        Button registerButton = new Button("Register");
        clearButton.setMaxWidth(Double.MAX_VALUE); // Allow the Clear button to expand to fill the available width.
        registerButton.setMaxWidth(Double.MAX_VALUE); // Allow the Register button to expand to fill the available width.
        formGrid.add(clearButton, 0, 4);
        formGrid.add(registerButton, 1, 4);

        // Place the completed form in the expandable center region of the BorderPane.
        root.setCenter(formGrid);

        /*
         * The status label begins with instructions. The event handlers below
         * update this same label after the user selects Register or Clear.
         */
        Label statusLabel = new Label("Complete all fields, and then select Register.");
        statusLabel.setWrapText(true); // Allow the label to wrap text if it exceeds the available width.
        BorderPane.setAlignment(statusLabel, Pos.CENTER); // Center the status label horizontally in the bottom region of the BorderPane.
        BorderPane.setMargin(statusLabel, new Insets(20, 0, 0, 0));
        root.setBottom(statusLabel);

        /*
         * The Register button uses a lambda expression as its event handler. It
         * reads the current values and verifies that every field has an entry.
         * If something is missing, the program displays an error message instead
         * of treating the incomplete form as a successful registration.
         */
        registerButton.setOnAction(event -> {
            String studentName = nameField.getText().trim();
            String studentId = idField.getText().trim();
            String selectedCourse = courseBox.getValue();
            String selectedTerm = termBox.getValue();

            if (studentName.isEmpty() || studentId.isEmpty() || selectedCourse == null || selectedTerm == null) {
                statusLabel.setText("Please complete every field before registering.");
                statusLabel.setStyle("-fx-text-fill: #b00020;"); // Set the text color to red for error messages.
            } else {
                statusLabel.setText(studentName + " is registered for " + selectedCourse + " in " + selectedTerm + ".");
                statusLabel.setStyle("-fx-text-fill: #1b5e20;"); // Set the text color to green for success messages.
            }
        });

        /*
         * The Clear button returns every control to its original state. TextField
         * values are erased, ComboBox selections are removed, and the status label
         * confirms that the form is ready for a new entry.
         */
        clearButton.setOnAction(event -> {
            nameField.clear();
            idField.clear();
            courseBox.getSelectionModel().clearSelection();
            termBox.getSelectionModel().clearSelection();
            statusLabel.setText("The form has been cleared.");
            statusLabel.setStyle("-fx-text-fill: #1a4f8b;"); // Set the text color to blue for informational messages.
            nameField.requestFocus(); // Set focus back to the name field for convenience.
        });

        /* Create the scene, connect it to the stage, and display the application.
         * The scene is the container for all the visual elements, and the stage is the window that holds the scene.
         */ 
        Scene scene = new Scene(root, 560, 360); // Set the initial size of the window to 560x360 pixels.
        stage.setTitle("JavaFX Course Registration");
        stage.setMinWidth(500); // Set the minimum width of the window to 500 pixels to prevent the form from becoming too narrow.
        stage.setMinHeight(340); // Set the minimum height of the window to 340 pixels to prevent the form from becoming too short.
        stage.setScene(scene); // Connect the scene to the stage.
        stage.show(); // Display the window on the screen.
    }

    public static void main(String[] args) {
        
        // launch() starts the JavaFX application and later calls the start() method.
        launch(args);
    }
}