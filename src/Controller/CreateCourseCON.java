package Controller;

import Enum.CourseType;
import Model.Course;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateCourseCON {
    
    @FXML
    private Button cancelButton, createCourseButton;
    
    @FXML
    private TextField titleInput;
    
    @FXML
    private ComboBox comType, comPoints, comSemester;
    
    @FXML
    private Label output;
    
    public void initialize() {
        this.comType.setItems(FXCollections.observableArrayList("Compulsory", "Optional"));
        this.comPoints.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        this.comSemester.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        
        this.titleInput.setText("");
        this.comType.setValue("");
        this.comSemester.setValue("");
        this.comPoints.setValue("");

        this.createCourseButton.setDisable(true);
    }
    
    public void cancel() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
    
    public void changeAction() {
        this.createCourseButton.setDisable(
                this.titleInput.getText().equals("") || this.comPoints.getValue().equals("") || this.comSemester.getValue().equals("") || this.comType.getValue().equals("")
        );
    }
    
    public void createCourse() {
        if(
                Course.createCourse(
                        this.titleInput.getText(),
                        CourseType.valueOf((String) this.comType.getValue()), 
                        Integer.parseInt((String) this.comPoints.getValue()),
                        Integer.parseInt((String) this.comSemester.getValue())
                )
                ){
            this.output.setText("Course Created");
            this.titleInput.setText("");
            this.comType.setValue("");
            this.comSemester.setValue("");
            this.comPoints.setValue("");
        }
        else{
            this.output.setText("Error");
        }

    }
    
}
