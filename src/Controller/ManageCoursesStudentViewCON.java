package Controller;

import Model.Course;
import Model.Main;
import Model.Student;
import Utilities.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ManageCoursesStudentViewCON implements Initializable {
    ArrayList<Course> StudentCourses;
    ArrayList<Integer> degrees;
   //@FXML
   // private ComboBox comCourses;
    
    @FXML
    private Button cancelButton;
    @FXML private TableView<TableViewTakenCourse> tTable ;
    @FXML private TableColumn<TableViewTakenCourse,String> tNameColumn;
    @FXML private TableColumn<TableViewTakenCourse,Integer> tDegreeColumn;
   

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/CoursesUIStudentView.fxml"));
	Scene scene = new Scene(root);
	stage.setTitle("Courses");
	stage.setScene(scene);
	stage.show();
    }
    
    
    public void exit() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       tNameColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
       tDegreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
       StudentCourses = ((Student)Main.user).getCourses();
       degrees = ((Student)Main.user).getDegrees();
       displaySelectedCourse();
    }  
    
  

 
    
    private void displaySelectedCourse(){
        //// for each course a student has display it
        ArrayList<TableViewTakenCourse> aCourseTV = new ArrayList();//the array that containts the courses with a +
        System.out.println("selected available Courses Courses");
        for(int i = 0;i<StudentCourses.size();i++){
            if(degrees.get(i) == null){
                aCourseTV.add(new TableViewTakenCourse(StudentCourses.get(i).getTitle(),0));
            
            }else{
                aCourseTV.add(new TableViewTakenCourse(StudentCourses.get(i).getTitle(),degrees.get(i)));
            }
        
        
        }
        
        
       System.out.println("selected available Courses END");
       ObservableList<TableViewTakenCourse> model = FXCollections.observableArrayList(aCourseTV);
       tTable.setItems(model);
    }

}
