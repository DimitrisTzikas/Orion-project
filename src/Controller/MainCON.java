package Controller;

import Model.Main;
import Model.Secretariat;
import Model.Teacher;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainCON {
    
    @FXML
    private Button exitButton;
    
    public void startMain() throws IOException {
        this.start(new Stage());
    }

    public void start(Stage stage) throws IOException {
        Parent root;
        if (Main.user instanceof Secretariat)
            root = FXMLLoader.load(getClass().getResource("/View/MainUIAdmin.fxml"));
        else if (Main.user instanceof Teacher)
            root = FXMLLoader.load(getClass().getResource("/View/MainUITeacher.fxml"));
        else
            root = FXMLLoader.load(getClass().getResource("/View/MainUIStudent.fxml"));
	Scene scene = new Scene(root);
	stage.setTitle("Orion");
	stage.setScene(scene);
	stage.show();    
    }
    
    @FXML
    public void exit() {
        Main.exit();
    }

    @FXML
    public void profile() throws IOException
    {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/ViewAccountInfoUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
	stage.setTitle("Profile");
	stage.setScene(scene);
	stage.show();       
    }
    
    //Announcement
    @FXML
    public void viewAnnouncement() throws IOException
    {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/ViewAnnouncementUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
	stage.setTitle("Create Announcements");
	stage.setScene(scene);
	stage.show();       
    }
    
    @FXML
    public void createAnnouncement() throws IOException
    {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/CreateAnnouncementUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
	stage.setTitle("View Announcements");
	stage.setScene(scene);
	stage.show();       
    }
    //End Announcement
  
    //Admin
    @FXML
    public void adminAddCourse() throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/CreateCourseUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
	stage.setTitle("Add Course");
	stage.setScene(scene);
	stage.show();
    }
    
    @FXML
    public void adminAddUser() throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/CreateUserUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
	stage.setTitle("Add User");
	stage.setScene(scene);
	stage.show();
    }
    
    @FXML
    public void adminAddRequiredCourse() throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/AdminAddRequiredCourseUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
	stage.setTitle("Add Required Course");
	stage.setScene(scene);
	stage.show();
    }
    //End Admin
    
    //Teacher
    @FXML
    private Label teacherLabel;    
    
    @FXML
    public void teacherAddCourse() throws IOException
    {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/GetCourseUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
	stage.setTitle("Add Course");
	stage.setScene(scene);
	stage.show();
    }
    
    @FXML
    public void teacherAddDegree() throws IOException
    {      
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/AddDegreeUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
	stage.setTitle("Add Degree");
	stage.setScene(scene);
	stage.show();
    }
    //End Teacher
    
    //Student    
    @FXML
    public void studentCourses() throws IOException
    {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/ManageCoursesStudentUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
	stage.setTitle("Add Courses");
	stage.setScene(scene);
	stage.show();       
    }
    @FXML
    public void studentViewCourses() throws IOException
    {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/View/ManageCoursesStudentViewUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
	stage.setTitle("View Courses");
	stage.setScene(scene);
	stage.show();       
    }
    // End Student
    
    public void initialize() {
    }
    
}
