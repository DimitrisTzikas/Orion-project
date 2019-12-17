package Model;

import Controller.LoginCON;
import Controller.MainCON;
import static Enum.CourseType.Compulsory;
import java.io.IOException;
import java.util.Date;
import javafx.stage.Stage;

public class Main extends javafx.application.Application {
    
    private static LoginCON loginCon;
    private static MainCON mainCon;
    public static User user;
    
    public static void main(String[] args) {
        
        try{
            // Import Data
            User.importFromFile();
            System.out.println("Users imported");
            Course.importFromFile();
            System.out.println("Courses imported");
            Announcement.importFromFile();
            System.out.println("Announcements imported");
            Curriculumn.importFromFile();
            System.out.println("Curriculumn imported");
            // End Import Data
           
            
            
        } catch(Exception e){
            User.addUser(new Student(1, "175042", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
            User.addUser(new Teacher("teacher1", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"));
            User.addUser(new Secretariat("admin", "123456", "add1", "add2", new Date(), "email@email.com", "6900000000"));
            Course.addCourse(new Course("courseA",Compulsory,1,1));
            Course.addCourse(new Course("courseB",Compulsory,1,1));
            Course.addCourse(new Course("courseC",Compulsory,1,2));
            User.writeToFile();
            Course.writeToFile();
            Announcement.writeToFile();
            Curriculumn.writeToFile();
            System.out.println("Class Changed: init completed");
        
        }
        
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws IOException {
        Main.loginCon = new LoginCON();
        loginCon.Start(stage);
    }
    
    public static void startMain(String username) throws IOException {
        Main.user = User.find(username);
        Main.loginCon = null;
        Main.mainCon = new MainCON();
        Main.mainCon.startMain();
    }
    
    public static void exit() {
        User.writeToFile();
        Course.writeToFile();
        Announcement.writeToFile();
        Curriculumn.writeToFile();
        System.exit(0);
    }
    
}
