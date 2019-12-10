package Controller;

import Enum.CourseType;
import Model.Course;
import Model.Main;
import Model.Student;
import Model.User;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ManageCoursesStudentCON implements Initializable {
    ArrayList<Course> StudentCourses;
    ArrayList<Integer> degrees;
    ArrayList<Course> availableCourses;
    ArrayList<Course> coursesToAdd = new ArrayList();
   //@FXML
   // private ComboBox comCourses;
    
    @FXML
    private Button cancelButton;
    @FXML private TableView<TableViewAvailableCourse> tTable ;
    @FXML private TableColumn<TableViewAvailableCourse,String> tNameColumn;
    @FXML private TableColumn<TableViewAvailableCourse,String> tDegreeColumn;
   
    //available table
    @FXML private TableView<TableViewAvailableCourse> aTable;
    @FXML private TableColumn<TableViewAvailableCourse,String> aNameColumn;
    @FXML private TableColumn<TableViewAvailableCourse,String> aAddColumn;
    
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/CoursesUIStudent.fxml"));
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
       
       aNameColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
       aAddColumn.setCellValueFactory(new PropertyValueFactory<>("add"));
       
       tNameColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
       tDegreeColumn.setCellValueFactory(new PropertyValueFactory<>("add"));
       
     
       StudentCourses = ((Student)Main.user).getCourses();
       
       degrees = ((Student)Main.user).getDegrees();
        //get a copy from all courses then remove the ones that the student owns
        availableCourses = new ArrayList(Course.getCourses());
        StudentCourses.forEach((course) -> {
            // for each course a student has display it
            availableCourses.remove(course);
        });
       displayAvailableCourses();
       displaySelectedCourse();


    }  
    
 
    @FXML
    public void clickItem(MouseEvent event)
    {
        if (event.getClickCount() == 2) //Checking double click
        {
            try{
                addNewCourse(aTable.getSelectionModel().getSelectedItem().getCourse());
            }catch(Exception ex){System.out.println("click on empty space");}
        }
    }
    @FXML
    public void clickItemR(MouseEvent event)
    {
        if (event.getClickCount() == 2) //Checking double click
        {
            try{
                removeNewCourse(tTable.getSelectionModel().getSelectedItem().getCourse());
            }catch(Exception ex){System.out.println("click on empty space");}
        }
    }
  
//method for onclick on + in available courses
    public void addNewCourse(String courseName){
        Course course = Course.getCourse(courseName);//bres to courses apo ton pinaka
        availableCourses.remove(course);
        coursesToAdd.add(course);
        displayAvailableCourses();  
        displaySelectedCourse();
             
    }
    public void removeNewCourse(String courseName){
        Course course = Course.getCourse(courseName);
        coursesToAdd.remove(course);
        availableCourses.add(course);
        displayAvailableCourses();
        displaySelectedCourse();
    }
    public void addCourses(){
        //for each course in coursesToAdd add them to student
        coursesToAdd.forEach((course) -> {
            System.out.println("Add"+course.getTitle()+" course to student");
            course.addStudent(((Student)Main.user));
        });
        exit();
    }
    
    private void displayAvailableCourses(){
        ArrayList<TableViewAvailableCourse> aCourseTV = new ArrayList();//the array that containts the courses with a +
        System.out.println("Available Courses");
        availableCourses.forEach((course) -> {
            System.out.println(course.getTitle());
            aCourseTV.add(new TableViewAvailableCourse(course.getTitle()));
        });
       System.out.println("Available Courses END");
       ObservableList<TableViewAvailableCourse> model = FXCollections.observableArrayList(aCourseTV);
       aTable.setItems(model);
    }
    
    private void displaySelectedCourse(){
        //// for each course a student has display it
        ArrayList<TableViewAvailableCourse> aCourseTV = new ArrayList();//the array that containts the courses with a +
        System.out.println("selected available Courses Courses");
        coursesToAdd.forEach((course) -> {
            System.out.println(course.getTitle());
            aCourseTV.add(new TableViewAvailableCourse(course.getTitle()));
        });
       System.out.println("selected available Courses END");
       ObservableList<TableViewAvailableCourse> model = FXCollections.observableArrayList(aCourseTV);
       tTable.setItems(model);
    }

}
