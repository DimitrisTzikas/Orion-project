package Model;

import static Enum.CourseType.Compulsory;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SecretariatNGTest {
    
    @DataProvider(name = "testAddDegreeToStudent")
    public static Object[][] addDegreeToStudentData() {
        Secretariat secretariat = new Secretariat("admin", "123456", "add1", "add2", new Date(), "email@email.com", "6900000000");
        
        Student student1 = new Student(1, "student1", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000");
        Student student2 = new Student(2, "student2", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000");
        Student student3 = new Student(3, "student3", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000");
        Student student4 = new Student(4, "student4", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000");
        Student student5 = new Student(5, "student5", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000");
        
        Course course1 = new Course("Math1", Compulsory, 120, 1, null);
        Course course2 = new Course("Math2", Compulsory, 120, 1, null);
        
        student2.addCourse(course2);
        student4.addCourse(course2);
        
        return new Object[][]{
            {secretariat, student1, course1, 10, false},
            {secretariat, student2, course2, 8, true},
            {secretariat, student3, course1, 1, false},
            {secretariat, student4, course2, 0, true},
            {secretariat, student5, course1, 9, false},
        };
    }

    @Test(dataProvider = "testAddDegreeToStudent")
    public void testAddDegreeToStudent(Secretariat secretariat, Student student, Course course, int degree, boolean expResult) {
        System.out.println("addDegreeToStudent");
        boolean result = secretariat.addDegreeToStudent(student, course, degree);
        assertEquals(result, expResult);
    }
    
}
