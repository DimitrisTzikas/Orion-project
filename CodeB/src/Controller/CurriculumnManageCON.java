/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Course;
import Model.Curriculumn;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Christos
 */
public class CurriculumnManageCON {
    private ArrayList<Course> activeCourses = new ArrayList<Course>();//Courses that will be added
    private ArrayList<Course> nonActiveCourses = new ArrayList<Course>(Curriculumn.getNONCurriculum());// All courses - Already active curriculumn courses
    @FXML
    private Button cancelButton, applyButton;
    
    @FXML
    private TableView<Course> activeCurriculumnTable ,coursesTable;
    
    @FXML
    private TableColumn<Course, String> activeCurriculumnNameCol ,coursesNameCol;
    
   
    public void initialize(){   
        activeCurriculumnNameCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        coursesNameCol.setCellValueFactory(new PropertyValueFactory<>("title")); 
        
        activeCurriculumnTable.setItems(FXCollections.observableArrayList(activeCourses));
        coursesTable.setItems(FXCollections.observableArrayList(nonActiveCourses));
    }
   
    
    
     @FXML
    public void addSelectedCourse(MouseEvent event) {
        if(event.getClickCount() == 2) {
            try{
                Course tempC = this.coursesTable.getSelectionModel().getSelectedItem();
                nonActiveCourses.remove(tempC);
                activeCourses.add(tempC);
                this.initialize();
            }catch(Exception ex){
                System.out.println("Empty cell");
            }
        }
    }
    
    @FXML
    public void removeSelectedCourse(MouseEvent event) {
        if(event.getClickCount() == 2) {
            try{
                Course tempC = this.activeCurriculumnTable.getSelectionModel().getSelectedItem();
                nonActiveCourses.add(tempC);
                activeCourses.remove(tempC);
                this.initialize();
            }catch(Exception ex){
                System.out.println("Empty cell");
            }
        }
    }
    @FXML
    public void applyChanges() {
       Curriculumn.addCourse(activeCourses);
       exit();
    }
    
    @FXML
    public void exit() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
}
