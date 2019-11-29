package Controller;

import Model.Course;
import Model.Main;
import Model.Student;
import Model.Teacher;
import Model.User;
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

public class AddDegreeCON {
    
    @FXML
    Button cancelButton, addDegreeButton;
    
    @FXML
    ComboBox comCourse, comStudent, comDegree;
    
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/AddDegreeUI.fxml"));
	Scene scene = new Scene(root);
	stage.setTitle("Add Course");
	stage.setScene(scene);
	stage.show();
    }
    
    public void initialize() {
        
        this.comDegree.setDisable(true);
        this.comStudent.setDisable(true);
        this.addDegreeButton.setDisable(true);

        this.comDegree.setItems(FXCollections.observableArrayList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        
         ArrayList<String> coursesTitle = new ArrayList<String>();
        
        // TODO when program implemented right change main to MainCON
        ((Teacher) Main.user).getCourses().forEach((course) -> {
            coursesTitle.add(course.getTitle());
        });
        
        this.comCourse.setItems(FXCollections.observableList(coursesTitle));
        
    }
    
    public void courseSelected() {
        this.comStudent.setDisable(false);
        
        ArrayList<Student> students = new ArrayList<Student>((Course.getCourse((String) this.comCourse.getValue())).getStudents());
        ArrayList<String> studentsUsername = new ArrayList<String>();
        
        students.forEach((student) -> {
            studentsUsername.add(student.getUsername());
        });
        
        this.comStudent.setItems(FXCollections.observableList(studentsUsername));
                
    }
    
    public void studentSelected() {
        this.comDegree.setDisable(false);
    }
    
    public void degreeSelected() {
        this.addDegreeButton.setDisable(false);
    }
    
    public void cancel() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
    
    public void addDegree() {
        User.getStudent((String) this.comStudent.getValue()).addDegreeTo(
                Integer.parseInt((String) this.comDegree.getValue()), 
                (String) this.comCourse.getValue()
        );
        this.initialize();
    }
    
}
