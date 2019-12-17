/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Enum.CourseType;
import Model.Course;
import Model.Curriculumn;
import Model.StudentReport;
import java.util.Date;
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
public class StudentReportCON {
    @FXML
    Button cancelButton;
    
    @FXML
    private TableView<StudentReport> studentReportTable;
    
    @FXML
    private TableColumn<StudentReport, String> actionCol, amCol, courseCol, msgCol,jDateCol, examDateCol, degreeCol;
    
    
    public void initialize() 
    {
        this.actionCol.setCellValueFactory(new PropertyValueFactory<>("action"));
        this.amCol.setCellValueFactory(new PropertyValueFactory<>("am"));
        this.courseCol.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
        this.jDateCol.setCellValueFactory(new PropertyValueFactory<>("jDate"));
        this.msgCol.setCellValueFactory(new PropertyValueFactory<>("msg"));
        this.examDateCol.setCellValueFactory(new PropertyValueFactory<>("exDate"));
        this.degreeCol.setCellValueFactory(new PropertyValueFactory<>("degree"));
        //studentReportTable.setItems(FXCollections.observableArrayList(new StudentReport("Marks","kapouos","course",new Date(),1)));
        studentReportTable.setItems(FXCollections.observableArrayList(StudentReport.getStudentReports()));
    }
    
    
    @FXML
    public void exit() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
}
