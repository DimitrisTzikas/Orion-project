package Controller;

import Model.Course;
import Model.Main;
import Model.PassValues;
import Model.Student;
import Model.User;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ManageCoursesStudentViewCON {
    
    @FXML
    private Button cancelButton;
    @FXML
    private TableView<PassValues> runningCoursesTable, passedCoursesTable, notPassedCoursesTable;
    @FXML
    private TableColumn<PassValues, String> runningCoursesTitleCol, passedCoursesTitleCol, notPassedCoursesTitleCol;
    @FXML
    private TableColumn<PassValues, Integer> passedCoursesDegreeCol, notPassedCoursesDegreeCol;
    
    public void initialize() {
   
        ArrayList<PassValues> passValuesArray = new ArrayList<PassValues>();
        for(Course course:((Student) Main.user).getRunningCourses())
            passValuesArray.add(new PassValues(course.getTitle(), (Integer) ((Student) Main.user).getDegree(course)));
        
        this.runningCoursesTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.runningCoursesTable.setItems(FXCollections.observableArrayList(passValuesArray));

        passValuesArray = new ArrayList<PassValues>();
        for(Course course:((Student) Main.user).getPassedCourses())
            passValuesArray.add(new PassValues(course.getTitle(), ((Student) Main.user).getDegree(course)));

        this.passedCoursesTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.passedCoursesDegreeCol.setCellValueFactory(new PropertyValueFactory<>("degree"));
        this.passedCoursesTable.setItems(FXCollections.observableArrayList(passValuesArray));
        
        passValuesArray = new ArrayList<PassValues>();
        for(Course course:((Student) Main.user).getNotPassedCourses())
            passValuesArray.add(new PassValues(course.getTitle(), ((Student) Main.user).getDegree(course)));
        
        this.notPassedCoursesTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.notPassedCoursesDegreeCol.setCellValueFactory(new PropertyValueFactory<>("degree"));
        this.notPassedCoursesTable.setItems(FXCollections.observableArrayList(passValuesArray));

    }  

    @FXML
    public void exit() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }

}
