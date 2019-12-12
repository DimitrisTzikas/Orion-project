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
        // Import Data
        /*
        User.importFromFile();
        System.out.println("Users imported");
        Course.importFromFile();
        System.out.println("Courses imported");
        Announcement.importFromFile();
        System.out.println("Announcements imported");
        */
//        User.addUser(new Student(100,"st","123","A","B", new Date(),"AB","ABB"));
        // End Import Data
        
        
        User.addUser(new Student(1, "175042", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        User.addUser(new Teacher("teacher1", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"));
        User.addUser(new Secretariat("admin", "123456", "add1", "add2", new Date(), "email@email.com", "6900000000"));
        
        
        User.writeToFile();
        
        

        Course.addCourse(new Course("Math1", Compulsory, 120, 1, (Teacher) User.getUser(1)));
        Course.addCourse(new Course("Math2", Compulsory, 120, 1, (Teacher) User.getUser(1)));
        Course.addCourse(new Course("Math3", Compulsory, 120, 1, (Teacher) User.getUser(1)));
        Course.addCourse(new Course("Math4", Compulsory, 120, 1, (Teacher) User.getUser(1)));
        Course.writeToFile();
        
        ((Teacher) User.getUser(1)).addCourse(Course.getCourse(0));
        ((Teacher) User.getUser(1)).addCourse(Course.getCourse(1));
        ((Teacher) User.getUser(1)).addCourse(Course.getCourse(2));
        ((Teacher) User.getUser(1)).addCourse(Course.getCourse(3));
        Course.addCourse(new Course("Math5", Compulsory, 120, 1, null));
        Course.addCourse(new Course("Math6", Compulsory, 120, 1, null));
        Course.getCourse(0).addStudent((Student) User.getUser(0));
        Course.getCourse(0).addStudent(new Student(1, "189032", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        Course.getCourse(0).addStudent(new Student(1, "213321", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        Course.getCourse(1).addStudent(new Student(1, "312321", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        Course.getCourse(2).addStudent(new Student(1, "876876", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        Course.getCourse(3).addStudent(new Student(1, "346546", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        
        
        
        
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
    
}
