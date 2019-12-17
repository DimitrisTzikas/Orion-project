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
         /*/====================================================//
       //--------=CUSTOM DATA REQUIRED BY THE TEACHER--------//
      //====================================================//
        //NOTE!!! commented code would be imported through ui and the countroller would stop them ,printing an error to the user
       
        //User story 4: Δήλωση μαθήματος (από φοιτητή)
        //Course.getCourse("Μηχανική Λογισμικού").addStudent((Student) User.getStudent("151234"));
        //Course.getCourse("Αντικειμενοστρεφής Προγραμματισμός (E)").addStudent((Student) User.getStudent("163217"));
        //Course.getCourse("Δομές Δεδομένων και Ανάλυση Αλγορίθμων").addStudent((Student) User.getStudent("163217"));
        //Course.getCourse("Μηχανική Λογισμικού").addStudent((Student) User.getStudent("163217"));
        //Course.getCourse("Μηχανική Λογισμικού").addStudent((Student) User.getStudent("172278"));
          //====================================================//
         //--------=CUSTOM DATA REQUIRED BY THE TEACHER--------//
        //====================================================/*/
           
            
            
        } catch(Exception e){
            User.addUser(new Student(1, "175042", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
            User.addUser(new Teacher("teacher1", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"));
            User.addUser(new Secretariat("admin", "123456", "add1", "add2", new Date(), "email@email.com", "6900000000"));
            
              //===================================================================//
             //                 CUSTOM DATA REQUIRED BY THE TEACHER               //
            //===================================================================//
            
            //User story 1: Εγγραφή φοιτητή (works)
            User.addUser(new Student(1, "151234", "123", "Κίμων", "Αθανασίου", new Date(), "email@email.com", "6900000000"));
            User.addUser(new Student(1, "163217", "123", "Ανδρομάχη", "Βασιλειάδου", new Date(), "email@email.com", "6900000000"));
            User.addUser(new Student(1, "172278", "123", "Dimitris", "Αλκης", new Date(), "email@email.com", "6900000000"));
            
            //User story 2: Εισαγωγή μαθήματος στο πρόγραμμα σπουδών (works)
            Course.addCourse(new Course("Αντικειμενοστρεφής Προγραμματισμός (Θ)", Compulsory, 120, 1));
            Course.addCourse(new Course("Αντικειμενοστρεφής Προγραμματισμός (Ε)", Compulsory, 220, 1));
            Course.addCourse(new Course("Δομές Δεδομένων και Ανάλυση Αλγορίθμων", Compulsory, 320, 2));
            Course.addCourse(new Course("Μηχανική Λογισμικού", Compulsory, 420, 4));
           
            //User story 3: Εισαγωγή προαπαιτούμενων μαθήματος (works)
            Course.getCourse("Δομές Δεδομένων και Ανάλυση Αλγορίθμων").addRequiredCourse(Course.getCourse("Αντικειμενοστρεφής Προγραμματισμός (Θ)"));
            Course.getCourse("Μηχανική Λογισμικού").addRequiredCourse(Course.getCourse("Αντικειμενοστρεφής Προγραμματισμός (Θ)"));
            
            //User story 4: Δήλωση μαθήματος (από φοιτητή)(working)
            Course.getCourse("Αντικειμενοστρεφής Προγραμματισμός (Θ)").addStudent((Student) User.getStudent("151234"));
            Course.getCourse("Δομές Δεδομένων και Ανάλυση Αλγορίθμων").addStudent((Student) User.getStudent("151234"));
            Course.getCourse("Αντικειμενοστρεφής Προγραμματισμός (Θ)").addStudent((Student) User.getStudent("172278"));
            Course.getCourse("Δομές Δεδομένων και Ανάλυση Αλγορίθμων").addStudent((Student) User.getStudent("172278"));
            
            //User story 5: Εισαγωγή βαθμολογιών (από γραμματεία ή καθηγητή)
            ((Student) User.getStudent("151234")).addDegreeTo(6,"Αντικειμενοστρεφής Προγραμματισμός (Θ)");
            ((Student) User.getStudent("172278")).addDegreeTo(7,"Αντικειμενοστρεφής Προγραμματισμός (Θ)");
            ((Student) User.getStudent("172278")).addDegreeTo(4,"Δομές Δεδομένων και Ανάλυση Αλγορίθμων"); 
            
              //==================================================================//
             //                 CUSTOM DATA REQUIRED BY THE TEACHER END          //
            //==================================================================//
            
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
        System.out.println("Class Changed: data saved");
        User.writeToFile();
        Course.writeToFile();
        Announcement.writeToFile();
        Curriculumn.writeToFile();
        System.exit(0);
    }
    
}
