package Controller;

import Model.Course;
import Model.Main;
import Model.Student;
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

public class AddCourseCON {
    
    @FXML
    private ComboBox comCourses;
    
    @FXML
    private Button cancelButton, addCourseButton;
    
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/AddCourseUI.fxml"));
	Scene scene = new Scene(root);
	stage.setTitle("Add Course");
	stage.setScene(scene);
	stage.show();
    }
    
    public void initialize() {
        
        ArrayList<Course> courses = new ArrayList<Course>(Course.getCourses());
        // TODO Change this when you implement mainCON
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
