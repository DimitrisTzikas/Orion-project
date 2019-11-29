package Model;

import java.util.ArrayList;
import java.util.Date;

public class Teacher extends User {
    
    private ArrayList<Course> courses;

    public Teacher(String username, String password, String name, String surname, Date birthday, String email, String phoneNumber) {
        super(username, password, name, surname, birthday, email, phoneNumber);
        this.courses = new ArrayList<Course>();
    }

    @Override
    public String toString() {
        return "Teacher{" + "username=" + this.username + ", password=" + password + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday + ", email=" + email + ", phoneNumber=" + phoneNumber + ", registration=" + registration + '}';
    }
    
    public void addCourse(Course course) {
        this.courses.add(course);
    }
    
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

}
