package Controller;

import Model.Course;
import Model.Student;
import Model.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddDegreeToStudentCON {
    
    @FXML
    private TableView<Student> studentsTable;
    
    @FXML
    private TableView<Course> coursesTable;
    
    @FXML
    private TableColumn<Student, String> studentsCol;
    
    @FXML
    private TableColumn<Course, String> coursesCol;
    
    @FXML
    private Button backButton;
    
    @FXML
    private ComboBox degreesCom;
    
    @FXML
    private Label outputLabel;

    public void initialize() {
        this.studentsCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.studentsTable.setItems(FXCollections.observableArrayList(User.getStudents()));
        this.coursesCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.degreesCom.setItems(FXCollections.observableArrayList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        this.degreesCom.setValue("");
    }    
    
    @FXML
    public void addDegreeAction() {
        if(this.degreesCom.getValue().equals("") || this.coursesTable.getSelectionModel().getSelectedItem() == null || this.studentsTable.getSelectionModel().getSelectedItem() == null){
            this.outputLabel.setText("Something is wrong");
            this.outputLabel.setStyle("-fx-background-color: #ff8888");
        } else {
            this.studentsTable.getSelectionModel().getSelectedItem().addDegree(this.coursesTable.getSelectionModel().getSelectedItem(), Integer.parseInt((String) this.degreesCom.getValue()));
            this.outputLabel.setText("Degree added");
            this.outputLabel.setStyle("");
        }
        
    }
    
    @FXML
    public void onClickAction(MouseEvent event) {
        if(event.getClickCount() == 2) {
            this.coursesTable.setItems(FXCollections.observableArrayList(this.studentsTable.getSelectionModel().getSelectedItem().getCourses()));
        }
    }
    
    @FXML
    public void backAction() {
        ((Stage) backButton.getScene().getWindow()).close();
    }
    
}
