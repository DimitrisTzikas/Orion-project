package Model;

import Enum.CourseType;
import java.io.Console;

public class Shell {

    private User user;
    private String prompt;
    private Console console;
    
    public Shell() {
        this.user = null;
        this.prompt = "[none]$ ";
        this.console = System.console();
    }
    
    public void start() {
        String command = "";
        
        while(true){
            command = this.console.readLine(this.prompt);
            
            switch(command) {
                // General Commands
                case "exit": this.exit();
                case "login": this.login(); break;
                case "logout": this.logout(); break;
                case "gui": this.gui(); break;
                case "whoami": this.whoami(); break;
                case "help": this.help(); break;
                case "help secretariat": this.helpSecretariat();break;
                case "": break;
                // General Commands END
                // Admin's Commands
                case "createCourse": this.createCourse(); break;
                case "addRequiredCourse": this.addRequiredCourse(); break;
                // Admin's Commands End
                // Teacher's Commands
                // Teacher's Commands End
                // Student's Commands
                // Student's Commands End
                default: System.out.print("\"" + command + "\" is not a valid command\n");
            }
        }
    }
    
    // General Methods
    private void login() {
        if(this.user != null){
            System.out.println("You are logged in");
        } else{
            String username = this.console.readLine("Username: ");
            char[] password = this.console.readPassword("Password: ");
            
            if(User.login(username, String.valueOf(password))){
                System.out.println("Logged in");
                this.user = User.find(username);
                this.prompt = "[" + this.user.username + "]$ ";
            } else{
                System.out.println("Wrong information");
            }
        }
    }
    
    private void logout() {
        if(this.user == null){
            System.out.println("You aren't logged in");
        } else{
            System.out.println("Logged out");
            this.user = null;
            this.prompt = "[none]$ ";
        }
    }
    
    private void whoami() {
        System.out.println("=====================================");
        if(this.user == null){
            System.out.println("Guest");
        } else{
            System.out.println("Username: " + this.user.username);
            System.out.println("Name: " + this.user.name);
            System.out.println("Surname: " + this.user.surname);
        }
        System.out.println("=====================================");
    }
    
    private void gui() {
        String[] args = {};
        Main.main(args);
    }
    
    private void exit() {
        User.writeToFile();
        Course.writeToFile();
        Announcement.writeToFile();
        Curriculumn.writeToFile();
        System.exit(0);
    }
    
    private void help() {
        System.out.println("help - prints this message"
                + "\nhelp secretariat - help for secretariat's commands"
                + "\nhelp teacher- help for tacher's commands"
                + "\nhelp student- help for student's commands"
                + "\nlogin - login action"
                + "\nlogout - logout action"
                + "\nwhoami - prints user's information"
                + "\ngui - starts default GUI"
                + "\nexit - exit action"
        );
    }
    
    private void helpSecretariat() {
        System.out.println("createCourse - creates a new course"
                + "\naddRequiredCourse - adds a required course to another course"
        );
    }
    
    private void helpTeacher() {
        
    }
    
    private void helpStudent() {
        
    }
    // General Methods End
    
    // Secretariat Methods 
    private boolean isSecretariat() {
        return this.user != null && this.user instanceof Secretariat;
    }
    
    private void createCourse() {
        if(this.isSecretariat()){
            String title = this.console.readLine("Title: ");
            CourseType courseType = CourseType.valueOf(this.console.readLine("Course Type (Compulsory, Optional): "));
            int points = Integer.parseInt(this.console.readLine("Points (0-10): "));
            int value = Integer.parseInt(this.console.readLine("value (0-10): "));
            
            if("y".equals(this.console.readLine("Create course (y/n): "))){
                Course.createCourse(title, courseType, points, value);
                System.out.println("Course created");
            } else{
                System.out.println("Canceled");
            }           
        } else{
            System.out.println("Permission denied");
        }
    }
    
    private void addRequiredCourse() {
        if(this.isSecretariat()){
            Course course = Course.getCourse(this.console.readLine("Course title: "));
            Course requiredCourse = Course.getCourse(this.console.readLine("Required course title: "));
            
            if("y".equals(this.console.readLine("Add required course (y/n): "))){
                course.addRequiredCourse(requiredCourse);
                System.out.println(requiredCourse.getTitle() + " added as required course to " + course.getTitle());
            } else{
                System.out.println("Canceled");
            }
        } else{
            System.out.println("Permission denied");
        }
    }
    
    // View profile
    // Add User
    // Add Degree To student
    // view curriculum
    // create Announcement
    // view Announcement
    // Mannage Curriculum
    
    // Secretariat Methods End
    
    // Teacher Methods    
    private boolean isTeacher() {
        return this.user != null && this.user instanceof Teacher;
    }
    
    // Add degree
    // Add course
    // View courses
    // View profile
    // View Curriculum
    // Create Anouncements
    // View announcement
    
    // Teahcer Methods End
    
    // Student Methods   
    private boolean isStudent() {
        return this.user != null && this.user instanceof Student;
    }
    
    // Add course
    // View profile
    // View Announcements
    // View course
    // View Curriculum
    
    // Student Methods End
    
}
