package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student extends User {

    private int semester;
    private ArrayList<Course> courses;
    private ArrayList<Integer> degree;
    Map<Course, Integer> dictionary;

    public Student(int semester, String username, String password, String name, String surname, Date birthday, String email, String phoneNumber) {
        super(username, password, name, surname, birthday, email, phoneNumber);
        this.semester = semester;
        this.courses = new ArrayList<Course>();
        this.degree = new ArrayList<Integer>();
        this.dictionary = new HashMap<Course, Integer>();
    }
    
    public ArrayList<Course> getCourses() {
        return new ArrayList<Course>(this.courses);
    }
    
    public ArrayList<Course> getAvaibleCourses() {
        ArrayList<Course> availableCourses = new ArrayList<Course>(Course.getCourses());
        availableCourses.removeAll(this.courses);
        return availableCourses;
    }
    
    public ArrayList<Course> getRunningCourses() { 
        ArrayList<Course> runningCourses = new ArrayList<Course>(this.getCourses());
        int size = runningCourses.size();
        for(int index = 0;index < size;index++)
            if(this.dictionary.get(this.getCourses().get(index)) != -1)
                runningCourses.remove(this.getCourses().get(index));
        return runningCourses;
    }
    
    public ArrayList<Course> getPassedCourses() { 
        ArrayList<Course> passedCourses = new ArrayList<Course>(this.getCourses());
        int size = passedCourses.size();
        for(int index = 0;index < size;index++)
            if(this.dictionary.get(this.getCourses().get(index)) < 5)
                passedCourses.remove(this.getCourses().get(index));
        return passedCourses;
    }
    
    public ArrayList<Course> getNotPassedCourses() { 
        ArrayList<Course> notPassedCourses = new ArrayList<Course>(this.getCourses());
        int size = notPassedCourses.size();
        for(int index = 0;index < size;index++)
            if(this.dictionary.get(this.getCourses().get(index)) < 0 || this.dictionary.get(this.getCourses().get(index)) >= 5)
                notPassedCourses.remove(this.getCourses().get(index));
        return notPassedCourses;
    }
    
    public boolean addDegree(Course course, int degree) {
        if(this.courses.indexOf(course) != -1){
            this.degree.add(this.courses.indexOf(course), degree);
            this.dictionary.replace(course, degree);
            return true;
        }
        return false;
    }
    
    public void addCourse(Course course) {
        this.courses.add(course);
        this.degree.add(-1);
        this.dictionary.put(course, -1);
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void addDegreeTo(int degree, String title) {
        this.degree.add(this.courses.indexOf(Course.getCourse(title)), degree);
        this.dictionary.replace(Course.getCourse(title), degree);
    }
    
    public int getSemester() {
        return this.semester;
    }

    public ArrayList<Integer> getDegrees() {
        return degree;
    }
    
    public Integer getDegree(Course course) {
        return this.dictionary.get(course);
    }
    
    @Override
    public String toString() {
        return "Student{" + "semester=" + semester + ", username=" + this.username + ", password=" + password + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday + ", email=" + email + ", phoneNumber=" + phoneNumber + ", registration=" + registration + '}';
    }

}
