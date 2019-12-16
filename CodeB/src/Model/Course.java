package Model;

import Enum.CourseType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    
    private static ArrayList<Course> courses = new ArrayList<Course>();

    private String title;
    private CourseType type;
    private int points;
    private int semester;
    private Teacher teacher;
    private ArrayList<Student> students;
    private ArrayList<Course> requiredCourses;
    
    public Course(String title, CourseType type, int points, int semester) {
        this.title = title;
        this.type = type;
        this.points = points;
        this.semester = semester;
        this.teacher = null;
        this.students = new ArrayList<Student>();
        this.requiredCourses = new ArrayList<Course>();
    }
    
    public Course(String title, CourseType type, int points, int semester, Teacher teacher) {
        this.title = title;
        this.type = type;
        this.points = points;
        this.semester = semester;
        this.teacher = teacher;
        this.students = new ArrayList<Student>();
        this.requiredCourses = new ArrayList<Course>();
    }
    
    public boolean hasTeacher() {
        return this.teacher != null;
    }
    
    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public void addRequiredCourse(Course course) {
        this.requiredCourses.add(course);
    }
    
    public boolean hasRequiredCourses() {
        return (!this.requiredCourses.isEmpty());
    }
    
    public ArrayList<Course> getRequiredCourses() {
        return this.requiredCourses;
    }
    
    public static ArrayList<Course> getCoursesWithoutTeacher() {
        ArrayList<Course> temp = new ArrayList<Course>();
        for(Course course: Course.courses)
            if(!course.hasTeacher())
                temp.add(course);
        return temp;
    }
    
    public static Course getCourse(String title) {
        for(Course course: Course.courses) {
            if(title.equals(
                    course.getTitle()))
                return course;
        }
        return null;
    }
    
    public static void addCourse(Course course) {
        Course.courses.add(course);
    }
    
    public static ArrayList<Course> getCourses() {
        return new ArrayList<Course>(Course.courses);
    }
    
    public String getTitle() {
        return this.title;
    }

    public CourseType getType() {
        return type;
    }

    public int getPoints() {
        return points;
    }
    
    public int getSemester(){
        return this.semester;
    }
    
    public static Course getCourse(int index) {
        return Course.courses.get(index);
    }
    
    
    public ArrayList<Student> getStudents() {
        return this.students;
    }
    
    public void addStudent(Student student) {
        this.students.add(student);
        student.addCourse(this);
    }
    
    public static boolean createCourse(String title, CourseType type, int points, int semester) {
        if(title.equals(""))
                return false;
        Course.courses.add(new Course(title, type, points, semester));
        return true;
    }
    

    @Override
    public String toString() {
        return "Course{" + "title=" + title + ", type=" + type + ", points=" + points + ", semester=" + semester + ", teacher=" + teacher + ", students=" + students + '}';
    }
    

    
    
    public static void writeToFile() {
        try{
            FileOutputStream writeData = new FileOutputStream("Courses.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(Course.courses);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void importFromFile() throws IOException {
        try{
            FileInputStream readData = new FileInputStream("Courses.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            Course.courses = (ArrayList<Course>) readStream.readObject();
            readStream.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
