package Controller;

import Model.Course;
import Model.Main;
import Model.PassValues;
import Model.Student;
import Model.Teacher;
import Model.User;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ManageCoursesTeachertViewCON {
    
    @FXML
    private Button cancelButton;
    @FXML
    private TableView<Course> teacherCoursesTable;
    @FXML
    private TableColumn<Course, String> teacherCourseTitleCol;
    
    public void initialize() { 
        this.teacherCourseTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.teacherCoursesTable.setItems(FXCollections.observableArrayList(((Teacher) Main.user).getCourses()));
    }  

    @FXML
    public void exit() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }

}
