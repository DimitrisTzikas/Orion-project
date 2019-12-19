package Model;

import Enum.AnnouncementType;
import Enum.CourseType;
import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Shell {

    private String prompt;
    private Console console;
    
    public Shell() {
        Main.user = null;
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
                case "profile": this.viewProfile(); break;
                case "help": this.help(); break;
                case "help secretariat": this.helpSecretariat();break;
                case "": break;
                // General Commands END
                // Admin's Commands
                case "createCourse": this.createCourse(); break;
                case "addRequiredCourse": this.addRequiredCourse(); break;
                case "createUser": this.createUser(); break;
                case "viewCurriculum": this.viewCurriculum(); break;
                case "viewAnnouncement": this.viewAnnouncement(); break;
                case "addDegreeToStudent": this.addDegreeToStudent(); break;
                case "createAnnouncement": this.createAnnouncement(); break;
                // Admin's Commands End
                // Teacher's Commands
                case "addDegree": this.addDegree(); break;
                case "addCourse": this.addCourse(); break;
                case "viewCourses": this.viewCourses(); break;
                // Teacher's Commands End
                // Student's Commands
                case "addCourseStudent": this.addCourseStudent(); break;
                case "viewCourseStudent": this.viewCourseStudent(); break;
                // Student's Commands End
                default: System.out.print("\"" + command + "\" is not a valid command\n");
            }
        }
    }
    
    // General Methods
    private void login() {
        if(Main.user != null){
            System.out.println("You are logged in");
        } else{
            String username = this.console.readLine("Username: ");
            char[] password = this.console.readPassword("Password: ");
            
            if(User.login(username, String.valueOf(password))){
                System.out.println("Logged in");
                Main.user = User.find(username);
                this.prompt = "[" + Main.user.username + "]$ ";
            } else{
                System.out.println("Wrong information");
            }
        }
    }
    
    private void logout() {
        if(Main.user == null){
            System.out.println("You aren't logged in");
        } else{
            System.out.println("Logged out");
            Main.user = null;
            this.prompt = "[none]$ ";
        }
    }
    
    private void whoami() {
        System.out.println("=====================================");
        if(Main.user == null){
            System.out.println("Guest");
        } else{
            System.out.println("Username: " + Main.user.username);
            System.out.println("Name: " + Main.user.name);
            System.out.println("Surname: " + Main.user.surname);
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
                + "\nprofile - prints user's profile"
                + "\nviewCurriculum - prints curriculum"
                + "\nviewAnnouncement - prints announcement"
                + "\ngui - starts default GUI"
                + "\nexit - exit action"
        );
    }
    
    private void helpSecretariat() {
        System.out.println("createCourse - creates a new course"
                + "\naddRequiredCourse - adds a required course to another course"
                + "\naddDegreeToStudent - adds degree to a student"
                + "\ncreateAnnouncement - create an announcement"                
        );
    }
    
    private void helpTeacher() {
        System.out.println("createAnnouncement - create an announcement"
                + "\naddDegree - add degree to student's course"
                + "\nviewCourses - view courses"
        );
    }
    
    private void helpStudent() {
        System.out.println("addCourseStudent - add course to student"
                + "\nviewCourseStudent - view student's courses"
        );
    }
    
    private void viewProfile() {
        if(Main.user != null){
            System.out.println("Username :" + Main.user.getUsername()
                    + "\nName: " + Main.user.getName()
                    + "\nSurname: " + Main.user.getSurname()
                    + "\nBirthday: " + new SimpleDateFormat("dd/MM/yyyy").format(Main.user.getBirthday())
                    + "\nEmail: " + Main.user.getEmail()
                    + "\nPhone: " + Main.user.getPhoneNumber()
                    + "\nRegistration date: " + new SimpleDateFormat("dd/MM/yyyy").format(Main.user.getRegistration())
            );
            if(Main.user instanceof Student){
                System.out.println("Semester: " + ((Student) Main.user).getSemester());
            }
        } else{
            System.out.println("You are guest");
        }
    }
    
    private void viewCurriculum() {
        if(Main.user != null){
            for(Course course:Curriculumn.getCurriculum(
                    Integer.valueOf(
                            this.console.readLine("Semester (1-10): ")
                    )
            )){
                System.out.println(course.getTitle());
            }
        } else{
            System.out.println("Permission denied");
        }
    }
    
    private void viewAnnouncement() {
        System.out.println(Announcement.getAnnouncement());
    }
    // General Methods End
    
    // Secretariat Methods 
    private boolean isSecretariat() {
        return Main.user != null && Main.user instanceof Secretariat;
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
    
    private void createUser() {
        if(this.isSecretariat()){
            String userType = this.console.readLine("What user do you want to create (1.Secretariat/2.Teacher/3.Student): ");
            switch (userType) {
                case "1":
                    {
                        String username = this.console.readLine("Username: ");
                        char[] password = this.console.readPassword("Password: ");
                        String name = this.console.readLine("Name: ");
                        String surname = this.console.readLine("Surname: ");
                        String date = this.console.readLine("Date (dd/MM/yyyy): ");
                        String email = this.console.readLine("Email: ");
                        String phoneNumber = this.console.readLine("Phone number: ");
                        try{
                            User.addUser(new Secretariat(username, String.valueOf(password), name, surname, (new SimpleDateFormat("dd/MM/yyyyyy")).parse(date), email, phoneNumber));
                            System.out.println("User Created");
                        } catch(ParseException ex){
                            System.out.println("Invalid date");
                        }       break;
                    }
                case "2":
                    {
                        String username = this.console.readLine("Username: ");
                        char[] password = this.console.readPassword("Password: ");
                        String name = this.console.readLine("Name: ");
                        String surname = this.console.readLine("Surname: ");
                        String date = this.console.readLine("Date (dd/MM/yyyy): ");
                        String email = this.console.readLine("Email: ");
                        String phoneNumber = this.console.readLine("Phone number: ");
                        try{
                            User.addUser(new Teacher(username, String.valueOf(password), name, surname, (new SimpleDateFormat("dd/MM/yyyyyy")).parse(date), email, phoneNumber));
                            System.out.println("User Created");
                        } catch(ParseException ex){
                            System.out.println("Invalid date");
                        }       break;
                    }
                case "3":
                    {
                        String username = this.console.readLine("Username: ");
                        char[] password = this.console.readPassword("Password: ");
                        String name = this.console.readLine("Name: ");
                        String surname = this.console.readLine("Surname: ");
                        String date = this.console.readLine("Date (dd/MM/yyyy): ");
                        String email = this.console.readLine("Email: ");
                        String phoneNumber = this.console.readLine("Phone number: ");
                        String semester = this.console.readLine("Semster (1-10): ");
                        try{
                            User.addUser(new Student(Integer.parseInt(semester), username, String.valueOf(password), name, surname, (new SimpleDateFormat("dd/MM/yyyyyy")).parse(date), email, phoneNumber));
                            System.out.println("User Created");
                        } catch(ParseException ex){
                            System.out.println("Invalid date");
                        }       break;
                    }
                default:
                    System.out.println("Not valid option");
                    break;
            }
        } else{
            System.out.println("Permission denied");
        }
    }
    
    private void addDegreeToStudent() {
        if(this.isSecretariat()){
            Student student = Student.getStudent(this.console.readLine("Student username: "));
            String title = this.console.readLine("Course title: ");
            int degree = Integer.parseInt(this.console.readLine("Degree (0-10): "));
            student.addDegreeTo(degree, title);
        } else{
            System.out.println("Permission denied");
        }
    }
    
    private void createAnnouncement() {
        if(this.isSecretariat() || this.isTeacher()){
            String title = this.console.readLine("Title: ");
            AnnouncementType announcementType = AnnouncementType.valueOf(this.console.readLine("AnnouncementType (General, Exam1-10): "));
            String description = this.console.readLine("Description: ");
            Announcement.createAnnouncement(title, announcementType, description);
        } else{
            System.out.println("Permission denied");
        }
    }
    // Secretariat Methods End
    
    // Teacher Methods    
    private boolean isTeacher() {
        return Main.user != null && Main.user instanceof Teacher;
    }
    
    private void addDegree() {
        if(this.isTeacher()){
            Student student = Student.getStudent(this.console.readLine("Student username: "));
            Course course = Course.getCourse(this.console.readLine("Course title: "));
            int degree = Integer.valueOf(this.console.readLine("Degree (0-10): "));
            student.addDegree(course, degree);
            System.out.println("Degree added");
        } else{
            System.out.println("Permission denied");
        }
    }

    private void addCourse() {
        if(this.isTeacher()){
            Course course = Course.getCourse(this.console.readLine("Course title: "));
            ((Teacher) Main.user).addCourse(course);
            System.out.println("Course added");
        } else{
            System.out.println("Permission denied");
        }
    }
    
    private void viewCourses() {
        if(this.isTeacher()){
            System.out.println(((Teacher) Main.user).getCourses());
        } else{
            System.out.println("Permission denied");
        }
    }
    // Teahcer Methods End
    
    // Student Methods   
    private boolean isStudent() {
        return Main.user != null && Main.user instanceof Student;
    }
    
    private void addCourseStudent() {
        if(this.isStudent()){
            ((Student) Main.user).addCourse(
                    Course.getCourse(
                            this.console.readLine("Course title: ")
                    )
            );
        } else{
            System.out.println("Permission denied");
        }
    }
    
    private void viewCourseStudent() {
        if(this.isStudent()){
            
        } else{
            System.out.println("Permission denied");
        }
    }
    // Student Methods End
    
}
