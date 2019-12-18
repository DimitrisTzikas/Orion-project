package Model;

import static Enum.CourseType.Compulsory;
import java.util.ArrayList;
import java.util.Date;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TeacherNGTest {

    @DataProvider(name = "testAddCourse")
    public static Object[][] addCourseData() {
        return new Object[][]{
            {new Teacher("teacher1", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"), new Course("Math1", Compulsory, 120, 1)},
            {new Teacher("teacher2", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"), new Course("Math2", Compulsory, 120, 1)},
            {new Teacher("teacher3", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"), new Course("Math3", Compulsory, 120, 1)},
            {new Teacher("teacher4", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"), new Course("Math4", Compulsory, 120, 1)},
            {new Teacher("teacher5", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000"), new Course("Math5", Compulsory, 120, 1)},
        };
    }
    
    @Test(dataProvider = "testAddCourse")
    public void testAddCourse(Teacher teacher, Course course) {
        System.out.println("addCourse");
        teacher.addCourse(course);
    }
    
    @DataProvider(name = "testGetCourses")
    public static Object[][] getCoursesData() {
        Teacher teacher = new Teacher("teacher1", "123456", "Xaris", "Xariou", new Date(), "email@email.com", "6900000000");
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Math1", Compulsory, 120, 1));
        courses.add(new Course("Math2", Compulsory, 120, 1));
        courses.add(new Course("Math3", Compulsory, 120, 1));
        courses.add(new Course("Math4", Compulsory, 120, 1));
        courses.add(new Course("Math5", Compulsory, 120, 1));
        teacher.addCourse(courses.get(0));
        teacher.addCourse(courses.get(1));
        teacher.addCourse(courses.get(2));
        teacher.addCourse(courses.get(3));
        teacher.addCourse(courses.get(4));
        return new Object[][]{
            {teacher, courses}  
        };
    }

    @Test(dataProvider = "testGetCourses")
    public void testGetCourses(Teacher teacher, ArrayList<Course> courses) {
        System.out.println("getCourses");
        ArrayList result = teacher.getCourses();
        assertEquals(result, courses);
    }
    
}
