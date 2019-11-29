package Model;

import Controller.LoginCON;
import Controller.MainCON;
import static Enum.CourseType.Compulsory;
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
        // End Import Data
        
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
