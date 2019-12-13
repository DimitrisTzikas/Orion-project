package Controller;

import Model.Course;
import Model.Main;
import Model.Student;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ManageCoursesStudentCON {
    
    static ArrayList<Course> selectedCourses = new ArrayList<Course>();
    static ArrayList<Course> availableCourses = new ArrayList<Course>(((Student) Main.user).getAvaibleCourses());
    
    @FXML
    private Button cancelButton;
    @FXML 
    private TableView<Course> selectedCoursesTable, availableCoursesTable;
    @FXML
    private TableColumn<Course,String> selectedTitleCol, availableTitleCol;
        
    public void initialize() {
       this.selectedTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
       this.availableCoursesTable.setItems(FXCollections.observableArrayList(ManageCoursesStudentCON.availableCourses));
       
       this.availableTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
       this.selectedCoursesTable.setItems(FXCollections.observableArrayList(ManageCoursesStudentCON.selectedCourses)); // TODO
    }
    
    @FXML
    public void selectCourse(MouseEvent event) {
        if(event.getClickCount() == 2) {
            try{
                ManageCoursesStudentCON.selectedCourses.add(this.availableCoursesTable.getSelectionModel().getSelectedItem());
                ManageCoursesStudentCON.availableCourses.remove(this.availableCoursesTable.getSelectionModel().getSelectedItem());
                this.initialize();
            }catch(Exception ex){
                System.out.println("Empty cell");
            }
        }
    }
    
    @FXML
    public void unselectCourse(MouseEvent event) {
        if(event.getClickCount() == 2) {
            try{
                ManageCoursesStudentCON.selectedCourses.remove(this.selectedCoursesTable.getSelectionModel().getSelectedItem());
                ManageCoursesStudentCON.availableCourses.add(this.selectedCoursesTable.getSelectionModel().getSelectedItem());
                this.initialize();
            }catch(Exception ex){
                System.out.println("Empty cell");
            }
        }
    }
    
    @FXML
    public void addCourse() {
        for(Course tempCourse:ManageCoursesStudentCON.selectedCourses){
            ((Student) Main.user).addCourse(tempCourse);
            ((Student) Main.user).addDegree(tempCourse, -1);
            ManageCoursesStudentCON.selectedCourses = new ArrayList<Course>();
        }
        this.initialize();
    }
    
    @FXML        
    public void exit() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }

}
