package Controller;

import Model.Course;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminAddRequiredCourseCON {
    
    @FXML
    private Button exitButton, addCourseButton;
    
    @FXML
    private TableView<Course> courseTable, requiredCourseTable;
    
    @FXML
    private TableColumn<Course, String> courseTitleCol, requiredCourseTitleCol;

    public void initialize() {
        this.courseTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.courseTable.setItems(FXCollections.observableArrayList(Course.getCourses()));
        this.addCourseButton.setDisable(true);
    }    
    
    @FXML
    public void activateButton() {
        this.addCourseButton.setDisable(this.requiredCourseTable.getSelectionModel().getSelectedItem() == null);
    }
    
    @FXML
    public void selectCourseAction() {
        ArrayList<Course> courses = Course.getCourses();
        courses.remove(this.courseTable.getSelectionModel().getSelectedItem());
        courses.removeAll(this.courseTable.getSelectionModel().getSelectedItem().getRequiredCourses());
        
        try{
            this.requiredCourseTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
            this.requiredCourseTable.setItems(FXCollections.observableArrayList(courses));
        }catch(Exception ex){
            System.out.println("Empty cell");
        }
    }
    
    @FXML
    public void addCourseAction() {    
        try{
            this.courseTable.getSelectionModel().getSelectedItem().addRequiredCourse(this.requiredCourseTable.getSelectionModel().getSelectedItem());
            
            ArrayList<Course> courses = Course.getCourses();
            courses.remove(this.courseTable.getSelectionModel().getSelectedItem());
            courses.removeAll(this.courseTable.getSelectionModel().getSelectedItem().getRequiredCourses());
            
            this.requiredCourseTable.setItems(FXCollections.observableArrayList(courses));
        }catch(Exception ex){
            System.out.println("Empty cell");
        }

        this.activateButton();
    }
    
    @FXML
    public void exitAction() {
        ((Stage) exitButton.getScene().getWindow()).close();
    }
    
}
