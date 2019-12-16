package Controller;

import Model.Course;
import Model.Main;
import Model.Student;
import Model.Teacher;
import Model.User;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class AddDegreeCON {
    
    @FXML
    Button cancelButton, addDegreeButton;
    
    @FXML
    ComboBox comCourse, comStudent, comDegree;
    
    public void initialize() {
        
        this.comDegree.setDisable(true);
        this.comStudent.setDisable(true);
        this.addDegreeButton.setDisable(true);

        this.comDegree.setItems(FXCollections.observableArrayList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        
         ArrayList<String> coursesTitle = new ArrayList<String>();
        
        ((Teacher) Main.user).getCourses().forEach((course) -> {
            coursesTitle.add(course.getTitle());
        });
        
        this.comCourse.setItems(FXCollections.observableList(coursesTitle));
        
    }
    
    public void courseSelected() {

        try{
            this.comStudent.setDisable(false);
            
            ArrayList<Student> students = new ArrayList<Student>((Course.getCourse((String) this.comCourse.getValue())).getStudents());
            ArrayList<String> studentsUsername = new ArrayList<String>();
        
            students.forEach((student) -> {
                studentsUsername.add(student.getUsername());
            });
        
            this.comStudent.setItems(FXCollections.observableList(studentsUsername));
        } catch(NullPointerException e){
            System.out.println(e);
        }
                
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
        
        this.comDegree.setOnAction(null);
        this.comCourse.setOnAction(null);
        this.comStudent.setOnAction(null);
        
        this.comDegree.setDisable(true);
        this.comStudent.setDisable(true);
        this.addDegreeButton.setDisable(true);
        
        this.comDegree.setValue(null);
        this.comStudent.setValue(null);
        this.comCourse.setValue(null);
        
        this.comDegree.setOnAction((Event event) -> {this.degreeSelected();});
        this.comCourse.setOnAction((Event event) -> {this.courseSelected();});
        this.comStudent.setOnAction((Event event) -> {this.studentSelected();});
    }
    
}
