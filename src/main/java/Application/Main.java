package Application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Application {

    private Random random;
    private List<Student> students;
    private List<String> classroomNames;
    private List<String> seatingArrangement;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Exam Seating Arrangement");

        random = new Random();
        students = new ArrayList<>();
        classroomNames = new ArrayList<>();
        seatingArrangement = new ArrayList<>();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setVgap(15);
        grid.setHgap(25);

        Label studentLabel = new Label("Number of students:");
        GridPane.setConstraints(studentLabel, 0, 0);
        TextField studentInput = new TextField();
        studentInput.setPromptText("Enter the number of students");
        GridPane.setConstraints(studentInput, 1, 0);

        Label classroomLabel = new Label("Number of classrooms:");
        GridPane.setConstraints(classroomLabel, 0, 1);
        TextField classroomInput = new TextField();
        classroomInput.setPromptText("Enter the number of classrooms");
        GridPane.setConstraints(classroomInput, 1, 1);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 3);

        submitButton.setOnAction(e -> {
            int numberOfStudents = Integer.parseInt(studentInput.getText());
            int numberOfClassrooms = Integer.parseInt(classroomInput.getText());

            generateStudents(numberOfStudents);
            generateClassroomNames(numberOfClassrooms);
            assignStudentsToClassrooms();

            // Generate and display seating arrangement
            generateSeatingArrangement();
            for (String arrangement : seatingArrangement) {
                System.out.println(arrangement);
            }
        });

        grid.getChildren().addAll(studentLabel, studentInput, classroomLabel, classroomInput, submitButton);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateStudents(int numStudents) {
        students.clear();
        RandomNameGenerator nameGenerator = new RandomNameGenerator();
        for (int i = 0; i < numStudents; i++) {
            students.add(new Student(nameGenerator.generateRandomName(), i + 1));
        }
    }

    private void generateClassroomNames(int numClassrooms) {
        classroomNames.clear();
        Randomclassroom classroomGenerator = new Randomclassroom();
        for (int i = 0; i < numClassrooms; i++) {
            classroomNames.add(classroomGenerator.generateRandomClass());
        }
    }

    private void assignStudentsToClassrooms() {
        seatingArrangement.clear();

        int studentIndex = 0;

        for (String classroom : classroomNames) {
            StringBuilder arrangement = new StringBuilder();
            arrangement.append("Classroom ").append(classroom).append(":\n");

            while (studentIndex < students.size()) {
                Student student = students.get(studentIndex);
                arrangement.append("- ").append(student.getName()).append(" (ID: ").append(student.getId()).append(")\n");
                studentIndex++;

                if (studentIndex % 10 == 0) {
                    break;
                }
            }

            seatingArrangement.add(arrangement.toString());
        }
    }

    private void generateSeatingArrangement() {
        // This method is now using the pre-generated seatingArrangement list
        // No need to modify this method
    }

    private class Student {
        private String name;
        private int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }
}
