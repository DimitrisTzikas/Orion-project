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

    @Override
    public String toString() {
        return "Student{" + "semester=" + semester + ", username=" + this.username + ", password=" + password + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday + ", email=" + email + ", phoneNumber=" + phoneNumber + ", registration=" + registration + '}';
    }

    public ArrayList<Integer> getDegrees() {
        return degree;
    }

}
