package Controller;

import Model.Course;
import Model.Main;
import Model.Student;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class AddCourseCON {
    
    @FXML
    private ComboBox comCourses;
    
    @FXML
    private Button cancelButton;
    
    public void initialize() {
        
        ArrayList<Course> courses = new ArrayList<Course>(Course.getCourses());
        ArrayList<Course> stCourses = ((Student) Main.user).getCourses();
        
        for(Course course: stCourses) {
            courses.remove(course);
        }
        
        ArrayList<String> coursesTitle = new ArrayList<String>();
        
        for(Course course: courses) {
            coursesTitle.add(course.getTitle());
        }
        
        this.comCourses.setItems(FXCollections.observableList(coursesTitle));
                
    }
    
    public void addCourse() {
        ((Student) Main.user).addCourse(Course.getCourse((String) this.comCourses.getValue()));
        this.initialize();
    }
    
    public void cancel() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
    
}
