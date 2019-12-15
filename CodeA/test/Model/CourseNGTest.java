package Model;

import static Enum.CourseType.Compulsory;
import java.util.ArrayList;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CourseNGTest {
    
    @DataProvider(name = "testHasTeacher")
    public static Object[][] hasTeacherData() {
        return new Object[][]{
            {new Course("Math1", Compulsory, 120, 1, null), false},
            {new Course("Math2", Compulsory, 120, 1, null), false},
            {new Course("Math3", Compulsory, 120, 1, new Teacher("teacher1", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000")), true},
            {new Course("Math4", Compulsory, 120, 1, new Teacher("teacher2", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000")), true},
            {new Course("Math5", Compulsory, 120, 1, new Teacher("teacher3", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000")), true},
        };
    }
    
    @Test(dataProvider = "testHasTeacher")
    public void testHasTeacher(Course course, boolean expResult) {
        System.out.println("hasTeacher");
        boolean result = course.hasTeacher();
        assertEquals(result, expResult);
    }
    
    @DataProvider(name = "testAddTeacher")
    public static Object[][] addTeacherData() {
        return new Object[][]{
            {new Teacher("teacher1", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"), new Course("Math1", Compulsory, 120, 1, null)},
            {new Teacher("teacher2", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"), new Course("Math2", Compulsory, 120, 1, null)},
            {new Teacher("teacher3", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"), new Course("Math3", Compulsory, 120, 1, null)},
            {new Teacher("teacher4", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"), new Course("Math4", Compulsory, 120, 1, null)},
            {new Teacher("teacher5", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"), new Course("Math5", Compulsory, 120, 1, null)}
        };
    }

    @Test(dataProvider = "testAddTeacher")
    public void testAddTeacher(Teacher teacher, Course course) {
        System.out.println("addTeacher");
        course.addTeacher(teacher);
    }
    
    @DataProvider(name = "testRequiredCourse")
    public static Object[][] addRequiredCourseData(){
        return new Object[][]{
            {new Course("Math1", Compulsory, 120, 1, null), new Course("Math2", Compulsory, 120, 1, null)},
            {new Course("Math3", Compulsory, 120, 1, null), new Course("Math4", Compulsory, 120, 1, null)},
            {new Course("Math5", Compulsory, 120, 1, null), new Course("Math6", Compulsory, 120, 1, null)},
            {new Course("Math7", Compulsory, 120, 1, null), new Course("Math8", Compulsory, 120, 1, null)},
            {new Course("Math9", Compulsory, 120, 1, null), new Course("Math10", Compulsory, 120, 1, null)},
        };
    }
    
    @Test(dataProvider = "testRequiredCourse")
    public void testAddRequiredCourse(Course course, Course course2) {
        System.out.println("addRequiredCourse");
        course.addRequiredCourse(course2);
    }
    
    @DataProvider(name = "testHasRequiredCourse")
    public static Object[][] hasRequiredCourseData() {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Math1", Compulsory, 120, 1, null));
        courses.add(new Course("Math3", Compulsory, 120, 1, null));
        courses.add(new Course("Math5", Compulsory, 120, 1, null));
        courses.add(new Course("Math7", Compulsory, 120, 1, null));
        courses.add(new Course("Math10", Compulsory, 120, 1, null));
        courses.get(2).addRequiredCourse(new Course("Math2", Compulsory, 120, 1, null));
        courses.get(3).addRequiredCourse(new Course("Math4", Compulsory, 120, 1, null));
        courses.get(3).addRequiredCourse(new Course("Math3", Compulsory, 120, 1, null));
        courses.get(3).addRequiredCourse(new Course("Math2", Compulsory, 120, 1, null));
        courses.get(4).addRequiredCourse(new Course("Math5", Compulsory, 120, 1, null));
        return new Object[][]{
            {courses.get(0), false},
            {courses.get(1), false},
            {courses.get(2), true},
            {courses.get(3), true},
            {courses.get(4), true},
        };
    }

    @Test(dataProvider = "testHasRequiredCourse")
    public void testHasRequiredCourses(Course course, boolean expResult) {
        boolean result = course.hasRequiredCourses();
        assertEquals(result, expResult);
    }
    
    @DataProvider(name = "testGetCoursesWithoutTeacher")
    public static Object[][] getCoursesWithoutTeacherData() {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Math1", Compulsory, 120, 1, null));
        courses.add(new Course("Math3", Compulsory, 120, 1, null));
        courses.add(new Course("Math5", Compulsory, 120, 1, null));
        Course.addCourse(courses.get(0));
        Course.addCourse(courses.get(1));
        Course.addCourse(courses.get(2));
        Course.addCourse(new Course("Math7", Compulsory, 120, 1, new Teacher("teacher3", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000")));
        Course.addCourse(new Course("Math10", Compulsory, 120, 1, new Teacher("teacher3", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000")));
        return new Object[][]{
            {courses}
        };
    }

    @Test(dataProvider = "testGetCoursesWithoutTeacher")
    public void testGetCoursesWithoutTeacher(ArrayList<Course> courses) {
        System.out.println("getCoursesWithoutTeacher");
        ArrayList result = Course.getCoursesWithoutTeacher();
        assertEquals(result, courses);
    }
    
    @DataProvider(name = "testGetTitle")
    public static Object[][] getTitleData() {
        return new Object[][]{
            {new Course("Math1", Compulsory, 120, 1, null), "Math1"},
            {new Course("Math2", Compulsory, 120, 1, null), "Math2"},
            {new Course("Math3", Compulsory, 120, 1, null), "Math3"},
            {new Course("Math4", Compulsory, 120, 1, null), "Math4"},
            {new Course("Math5", Compulsory, 120, 1, null), "Math5"},
            {new Course("Math6", Compulsory, 120, 1, null), "Math6"},
        };
    }
    
    @Test(dataProvider = "testGetTitle")
    public void testGetTitle(Course course, String title) {
        System.out.println("getTitle");
        String result = course.getTitle();
        assertEquals(result, title);
    }

    @DataProvider(name = "testGetStudents")
    public static Object[][] getStudentsData() {
        Course course = new Course("Math1", Compulsory, 120, 1, null);
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "student1", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        students.add(new Student(2, "student2", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        students.add(new Student(3, "student3", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        students.add(new Student(4, "student4", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        course.addStudent(students.get(0));
        course.addStudent(students.get(1));
        course.addStudent(students.get(2));
        course.addStudent(students.get(3));
        return new Object[][]{
            {course, students}
        };
    }
    
    @Test(dataProvider = "testGetStudents")
    public void testGetStudents(Course course, ArrayList<Student> students) {
        System.out.println("getStudents");
        ArrayList<Student> result = course.getStudents();
        assertEquals(result, students);
    }
    
}
