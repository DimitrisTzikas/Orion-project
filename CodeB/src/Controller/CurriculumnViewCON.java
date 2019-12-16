/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Enum.CourseType;
import Model.Course;
import Model.Curriculumn;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Christos
 */
public class CurriculumnViewCON {
    
    @FXML
    private Button cancelButton, semesterButton;
    @FXML
    private ComboBox semesterCombo;
    @FXML
    private TableView<Course> curriculumnTable;
    
    @FXML
    private TableColumn<Course, String> nameCol;
    
    @FXML
    private TableColumn<Course, Integer> pointsCol;
    
    @FXML
    private TableColumn<Course, CourseType> typeCol;
    
    public void initialize() 
    {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type")); 
        pointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));
        
        this.semesterCombo.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        this.semesterCombo.setValue("1");
        curriculumnTable.setItems(FXCollections.observableArrayList(Curriculumn.getCurriculum(1)));
    }
    
    
    
    @FXML
    public void semesterLoad(){
        curriculumnTable.setItems(FXCollections.observableArrayList(Curriculumn.getCurriculum(Integer.parseInt(this.semesterCombo.getValue()+""))));
    }
    
    @FXML
    public void exit() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
}
