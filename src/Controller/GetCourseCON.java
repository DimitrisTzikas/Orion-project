package Controller;

import Model.Course;
import Model.Main;
import Model.Teacher;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class GetCourseCON {
    
    @FXML
    private ComboBox comCourses;
    
    @FXML
    private Button cancelButton, getCourseButton;

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/GetCourseUI.fxml"));
	Scene scene = new Scene(root);
	stage.setTitle("Create User");
	stage.setScene(scene);
	stage.show();
    }
    
    public void initialize() {
        ArrayList<String> coursesTitle = new ArrayList<String>();
        Course.getCoursesWithoutTeacher().forEach((course) -> {
            coursesTitle.add(course.getTitle());
        });
        this.comCourses.setItems(FXCollections.observableList(coursesTitle));
    }
    
    public void cancel() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
    
    public void getCourse() {
        Course course = Course.getCourse((String) this.comCourses.getValue());
        // TODO Change main to mainCON when you implement the program
        course.addTeacher((Teacher) Main.user);
        ((Teacher) Main.user).addCourse(course);
        this.initialize();
    }
    
}
