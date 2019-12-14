package Controller;

import Model.Course;
import Model.Main;
import Model.Teacher;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class GetCourseCON {
    
    @FXML
    private ComboBox comCourses;
    
    @FXML
    private Button cancelButton, getCourseButton;

    public void initialize() {
        ArrayList<String> coursesTitle = new ArrayList<String>();
        Course.getCoursesWithoutTeacher().forEach((course) -> {
            coursesTitle.add(course.getTitle());
        });
        this.comCourses.setItems(FXCollections.observableList(coursesTitle));
        this.getCourseButton.setDisable(true);
    }
    
    @FXML
    public void cancel() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
    
    @FXML
    public void activate() {
        this.getCourseButton.setDisable(false);
    }
    
    @FXML
    public void getCourse() {
        Course course = Course.getCourse((String) this.comCourses.getValue());
        course.addTeacher((Teacher) Main.user);
        ((Teacher) Main.user).addCourse(course);
        this.initialize();
    }
    
}
