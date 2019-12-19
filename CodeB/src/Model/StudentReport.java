package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentReport {
    private String action;
    private String am;
    private String courseTitle;
    private String jDate;
    private String msg;
    private String exDate;
    private String degree;

    public StudentReport(String action, String am, String courseTitle){
        this.action = action;
        this.am = am;
        this.courseTitle = courseTitle;  
    }
    
    public StudentReport(String action, String am, String courseTitle, Date exDate, int degree) {
        this(action, am, courseTitle);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        this.exDate = dateFormat.format(exDate); 
        this.degree = degree+"";
        this.jDate = "-";
        this.msg = "-";
    }
    
    public StudentReport(String action, String am, String courseTitle, Date jDate, String msg) {
        this(action, am, courseTitle);
        DateFormat dateFormat1 = new SimpleDateFormat("dd-mm-yyyy");   
        this.jDate = dateFormat1.format(jDate);
        this.msg = msg;
        this.exDate = "-";
        this.degree = "-";
    }

    public String getAction() {
        return action;
    }

    public String getAm() {
        return am;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getJDate() {
        return jDate;
    }

    public String getMsg() {
        return msg;
    }

    public String getExDate() {
        return exDate;
    }

    public String getDegree() {
        return degree;
    }
    
    public static ArrayList<StudentReport> getStudentReports(){
       ArrayList<StudentReport> studentsReport = new ArrayList<StudentReport>();
       //first get action = marks
       User.getStudents().forEach(student ->{
            //for each course a student add it to the report
            student.getCourses().forEach(course ->{
                if(student.dictionary.get(course) > -1){// > -1 so it has a degree
                    studentsReport.add(new StudentReport("Marks",student.username,course.getTitle(),student.dictionaryDates.get(course),student.dictionary.get(course)));
                }
            });
        });
        //second get action = registration
       Course.getCourses().forEach(course ->{
           course.getStudents().forEach(student->{
                studentsReport.add(new StudentReport("registration",student.username,course.getTitle(),course.dictionary.get(student),"sucessfull"));
           });
       });
       return studentsReport;
    }
  
}
