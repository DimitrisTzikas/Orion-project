package Model;

import Controller.LoginCON;
import Controller.MainCON;
import java.io.IOException;
import javafx.stage.Stage;

public class Main extends javafx.application.Application {
    
    private static LoginCON loginCon;
    private static MainCON mainCon;
    public static User user;
    
    public static void main(String[] args) {
        // Import Data
        User.importFromFile();
        System.out.println("Users imported");
        Course.importFromFile();
        System.out.println("Courses imported");
        Announcement.importFromFile();
        System.out.println("Announcements imported");
        // End Import Data
        
        /*
        User.addUser(new Student(1, "175042", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        User.addUser(new Teacher("teacher1", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"));
        User.addUser(new Secretariat("admin", "123456", "add1", "add2", new Date(), "email@email.com", "6900000000"));
        User.writeToFile();
        Course.writeToFile();
        */
        
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
        System.exit(0);
    }
    
}
