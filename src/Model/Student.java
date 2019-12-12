package Model;

import java.util.ArrayList;
import java.util.Date;

public class Student extends User {

    private int semester;
    private ArrayList<Course> courses;
    private ArrayList<Integer> degree;

    public Student(int semester, String username, String password, String name, String surname, Date birthday, String email, String phoneNumber) {
        super(username, password, name, surname, birthday, email, phoneNumber);
        this.semester = semester;
        this.courses = new ArrayList<Course>();
        this.degree = new ArrayList<Integer>();
    }
    
    public ArrayList<Course> getCourses() {
        return this.courses;
    }
    
    public ArrayList<Course> getAvaibleCourses() {
        ArrayList<Course> availableCourses = new ArrayList<Course>(Course.getCourses());
        availableCourses.removeAll(this.courses);
        return availableCourses;
    }
    
    public ArrayList<Course> getPassedCourses() {
        ArrayList<Course> passedCourses = new ArrayList<Course>(this.courses);
        int index = 0;
        for(Course temp:passedCourses){
            if(this.degree.get(index) < 5)
                passedCourses.remove(temp);
            index++;
        }
        return passedCourses;
    }
    
    public ArrayList<Course> getNotPassedCourses() {
        ArrayList<Course> notPassedCourses = new ArrayList<Course>(this.courses);
        int index = 0;
        for(Course temp:notPassedCourses){
            if(this.degree.get(index) >= 5)
                notPassedCourses.remove(temp);
            index++;
        }
        return notPassedCourses;
    }
    
    public ArrayList<Course> getRunningCourses() {
        ArrayList<Course> runningCourses = new ArrayList<Course>(this.courses);
        int index = 0;
        for(Course temp:runningCourses){
            if(this.degree.get(index) == -1)
                runningCourses.remove(temp);
            index++;
        }
        return runningCourses;
    }
    
    public boolean addDegree(Course course, int degree) {
        if(this.courses.indexOf(course) != -1){
            this.degree.add(this.courses.indexOf(course), degree);
            return true;
        }
        return false;
    }
    
    public void addCourse(Course course) {
        this.courses.add(course);
        this.degree.add(null);
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void addDegreeTo(int degree, String title) {
        this.degree.add(this.courses.indexOf(Course.getCourse(title)), degree);
    }
    
    public int getSemester() {
        return this.semester;
    }

    public ArrayList<Integer> getDegrees() {
        return degree;
    }
    
    @Override
    public String toString() {
        return "Student{" + "semester=" + semester + ", username=" + this.username + ", password=" + password + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday + ", email=" + email + ", phoneNumber=" + phoneNumber + ", registration=" + registration + '}';
    }

}
