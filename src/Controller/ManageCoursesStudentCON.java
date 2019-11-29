package Controller;

import Model.Course;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ManageCoursesStudentCON implements Initializable {
    ArrayList<Course> StudentCourses;
    ArrayList<Integer> degrees;
    ArrayList<Course> availableCourses;
   //@FXML
   // private ComboBox comCourses;
    
    @FXML
    private Button cancelButton;
    //n@FXML private TableView<TCourse> tTable ;
    //@FXML private TableColumn<TCourse,String> tNameColumn;
    //@FXML private TableColumn<TCourse,Float> tDegreeColumn;
   
    //available table
    //@FXML private TableView<ACourse> aTable;
    //@FXML private TableColumn<ACourse,String> aNameColumn;
    //@FXML private TableColumn<ACourse,String> aAddColumn;
    
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
       /*
       aNameColumn.setCellValueFactory(new PropertyValueFactory<ACourse,String>("name"));
       aAddColumn.setCellValueFactory(new PropertyValueFactory<ACourse,String>("add"));
       tNameColumn.setCellValueFactory(new PropertyValueFactory<TCourse,String>("name"));
       tDegreeColumn.setCellValueFactory(new PropertyValueFactory<TCourse,Float>("degree"));

       //load dummy data
       aTable.setItems(getCourses());
       tTable.setItems(getCourses2());
           
        
       availableCourses = new ArrayList(Course.getCourses());
       StudentCourses = ((Student)Main.user).getCourses();
       degrees = ((Student)Main.user).getDegrees();
        //get a copy from all courses then remove the ones that the student owns
        StudentCourses.forEach((course) -> {
            // for each course a student has display it
            availableCourses.remove(course);
        });
       populateTables();
*/
    }  
    
    public void populateTables(){
        
        System.out.println("Available Courses");
        availableCourses.forEach((course) -> {
            System.out.println(course.getTitle());
            // aTable.getItems().add(new ACourse(course.getTitle()));
        });
        System.out.println("Available Courses END");
       
        //// for each course a student has display it
        System.out.println("Selected Courses");
        for(int i = 0;i<StudentCourses.size();i++){
            if( StudentCourses.get(i).getTitle()==null){continue;}
            System.out.print(StudentCourses.get(i).getTitle()+" ");
            if( degrees.get(i)==null){
                System.out.println(0);
              //  tTable.getItems().add(new TCourse(StudentCourses.get(i).getTitle(),degrees.get(i)));
            }
            else{
             //   tTable.getItems().add(new TCourse(StudentCourses.get(i).getTitle(),0));
                System.out.print("  "+degrees.get(i)+"\n");
            }
        }
        System.out.println("Selected Courses END");
   
    }
    
//method for onclick on + in available courses
    public void addNewCourse(String courseName){
        Course course = Course.getCourse(courseName);
        availableCourses.remove(course);
        StudentCourses.add(course);
        populateTables();
        //save changes on files
    }

}
