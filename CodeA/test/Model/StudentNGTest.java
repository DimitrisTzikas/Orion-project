package Model;

import static Enum.CourseType.Compulsory;
import java.util.ArrayList;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StudentNGTest {
    
    private static ArrayList<Student> students = new ArrayList<Student>();
    private static ArrayList<Course> courses = new ArrayList<Course>();
    
    public StudentNGTest() {
        // Create Students
        StudentNGTest.students.add(new Student(1, "student1", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        StudentNGTest.students.add(new Student(2, "student2", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        StudentNGTest.students.add(new Student(3, "student3", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        StudentNGTest.students.add(new Student(4, "student4", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        StudentNGTest.students.add(new Student(5, "student5", "123456", "Dimitris", "Tzikas", new Date(), "email@email.com", "6900000000"));
        
        // Create Courses
        StudentNGTest.courses.add(new Course("Math1", Compulsory, 120, 1));
        StudentNGTest.courses.add(new Course("Math2", Compulsory, 120, 1));
        StudentNGTest.courses.add(new Course("Math3", Compulsory, 120, 1));
        StudentNGTest.courses.add(new Course("Math4", Compulsory, 120, 1));
        StudentNGTest.courses.add(new Course("Math5", Compulsory, 120, 1));
        
        // Add to courses required courses
        StudentNGTest.courses.get(3).addRequiredCourse(StudentNGTest.courses.get(0));
        StudentNGTest.courses.get(3).addRequiredCourse(StudentNGTest.courses.get(1));
        StudentNGTest.courses.get(3).addRequiredCourse(StudentNGTest.courses.get(2));
        StudentNGTest.courses.get(4).addRequiredCourse(StudentNGTest.courses.get(3));
        
        // Add courses to students
        StudentNGTest.students.get(0).addCourse(StudentNGTest.courses.get(0));
        StudentNGTest.students.get(0).addCourse(StudentNGTest.courses.get(1));
        StudentNGTest.students.get(0).addCourse(StudentNGTest.courses.get(2));
        StudentNGTest.students.get(2).addCourse(StudentNGTest.courses.get(0));
        StudentNGTest.students.get(2).addCourse(StudentNGTest.courses.get(2));
        StudentNGTest.students.get(3).addCourse(StudentNGTest.courses.get(0));
        StudentNGTest.students.get(3).addCourse(StudentNGTest.courses.get(1));
        StudentNGTest.students.get(3).addCourse(StudentNGTest.courses.get(2));
        StudentNGTest.students.get(4).addCourse(StudentNGTest.courses.get(0));
        StudentNGTest.students.get(4).addCourse(StudentNGTest.courses.get(1));
        StudentNGTest.students.get(4).addCourse(StudentNGTest.courses.get(2));
        StudentNGTest.students.get(4).addCourse(StudentNGTest.courses.get(3));
        
        // Add degree to students courses
        StudentNGTest.students.get(0).addDegree(StudentNGTest.courses.get(0), 10);
        StudentNGTest.students.get(0).addDegree(StudentNGTest.courses.get(1), 8);
        StudentNGTest.students.get(0).addDegree(StudentNGTest.courses.get(2), 7);
        StudentNGTest.students.get(2).addDegree(StudentNGTest.courses.get(0), 6);
        StudentNGTest.students.get(2).addDegree(StudentNGTest.courses.get(2), 9);
        StudentNGTest.students.get(3).addDegree(StudentNGTest.courses.get(0), 10);
        StudentNGTest.students.get(3).addDegree(StudentNGTest.courses.get(1), 8);
        StudentNGTest.students.get(3).addDegree(StudentNGTest.courses.get(2), 4);
        StudentNGTest.students.get(4).addDegree(StudentNGTest.courses.get(0), 9);
        StudentNGTest.students.get(4).addDegree(StudentNGTest.courses.get(1), 8);
        StudentNGTest.students.get(4).addDegree(StudentNGTest.courses.get(2), 7);
        StudentNGTest.students.get(4).addDegree(StudentNGTest.courses.get(3), 8);
        
        // Add courses to Course class
        Course.addCourse(StudentNGTest.courses.get(0));
        Course.addCourse(StudentNGTest.courses.get(1));
        Course.addCourse(StudentNGTest.courses.get(2));
        Course.addCourse(StudentNGTest.courses.get(3));
        Course.addCourse(StudentNGTest.courses.get(4));
    }
    
    @DataProvider(name = "testCheckCourseRequirements")
    public static Object[][] checkCourseRequirementsData() {
        return new Object[][]{
            // Student passed all required courses
            {StudentNGTest.students.get(0), StudentNGTest.courses.get(3), true},
            // Student without courses
            {StudentNGTest.students.get(1), StudentNGTest.courses.get(3), false},
            // Student with 2 of 3 required courses
            {StudentNGTest.students.get(2), StudentNGTest.courses.get(3), false},
            // Student with 3 of 3 required courses but one has degree 4
            {StudentNGTest.students.get(3), StudentNGTest.courses.get(3), false},
            {StudentNGTest.students.get(4), StudentNGTest.courses.get(4), true}
        };
    }
    
    @Test(dataProvider = "testCheckCourseRequirements")
    public void testCheckCourseRequirements(Student student, Course course, boolean expResult) {
        System.out.println("checkCourseRequirements");
        boolean result = student.checkCourseRequirements(course);
        assertEquals(result, expResult);
    }

    @DataProvider(name = "testGetCourses")
    public static Object[][] getCoursesData() {
        ArrayList<Course> courses1 = new ArrayList<Course>();
        ArrayList<Course> courses2 = new ArrayList<Course>();
        ArrayList<Course> courses3 = new ArrayList<Course>();
        ArrayList<Course> courses4 = new ArrayList<Course>();
        ArrayList<Course> courses5 = new ArrayList<Course>();
        
        courses1.add(StudentNGTest.students.get(0).getCourses().get(0));
        courses1.add(StudentNGTest.students.get(0).getCourses().get(1));
        courses1.add(StudentNGTest.students.get(0).getCourses().get(2));
        
        courses3.add(StudentNGTest.students.get(2).getCourses().get(0));
        courses3.add(StudentNGTest.students.get(2).getCourses().get(1));
        
        courses4.add(StudentNGTest.students.get(3).getCourses().get(0));
        courses4.add(StudentNGTest.students.get(3).getCourses().get(1));
        courses4.add(StudentNGTest.students.get(3).getCourses().get(2));
        
        courses5.add(StudentNGTest.students.get(4).getCourses().get(0));
        courses5.add(StudentNGTest.students.get(4).getCourses().get(1));
        courses5.add(StudentNGTest.students.get(4).getCourses().get(2));
        courses5.add(StudentNGTest.students.get(4).getCourses().get(3));
        
        return new Object[][]{
            {StudentNGTest.students.get(0), courses1},
            {StudentNGTest.students.get(1), courses2},
            {StudentNGTest.students.get(2), courses3},
            {StudentNGTest.students.get(3), courses4},
            {StudentNGTest.students.get(4), courses5}
        };
    }
    
    @Test(dataProvider = "testGetCourses")
    public void testGetCourses(Student student, ArrayList<Course> courses) {
        System.out.println("getCourses");
        ArrayList result = student.getCourses();
        assertEquals(result, courses);
    }
    
    @DataProvider(name = "testGetAvaibleCourses")
    public static Object[][] getAvailableCoursesData() {
        ArrayList<Course> courses1 = new ArrayList<Course>();
        ArrayList<Course> courses2 = new ArrayList<Course>(Course.getCourses());
        ArrayList<Course> courses3 = new ArrayList<Course>();
        ArrayList<Course> courses4 = new ArrayList<Course>();
        ArrayList<Course> courses5 = new ArrayList<Course>();
        
        courses1.add(StudentNGTest.courses.get(3));
        courses1.add(StudentNGTest.courses.get(4));
        
        courses3.add(StudentNGTest.courses.get(1));
        courses3.add(StudentNGTest.courses.get(3));
        courses3.add(StudentNGTest.courses.get(4));
        
        courses4.add(StudentNGTest.courses.get(2));
        courses4.add(StudentNGTest.courses.get(3));
        courses4.add(StudentNGTest.courses.get(4));
        
        return new Object[][]{
            {StudentNGTest.students.get(0), courses1},
            {StudentNGTest.students.get(1), courses2},
            {StudentNGTest.students.get(2), courses3},
            {StudentNGTest.students.get(3), courses4}
        };
    }

    @Test(dataProvider = "testGetAvaibleCourses")
    public void testGetAvaibleCourses(Student student, ArrayList<Course> courses) {
        System.out.println("getAvaibleCourses");
        ArrayList result = student.getAvaibleCourses();
        assertEquals(result, courses);
    }

    /*
    @Test
    public void testGetRunningCourses() {
        System.out.println("getRunningCourses");
        Student instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getRunningCourses();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPassedCourses() {
        System.out.println("getPassedCourses");
        Student instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getPassedCourses();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNotPassedCourses() {
        System.out.println("getNotPassedCourses");
        Student instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getNotPassedCourses();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddDegree() {
        System.out.println("addDegree");
        Course course = null;
        int degree = 0;
        Student instance = null;
        boolean expResult = false;
        boolean result = instance.addDegree(course, degree);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddCourse() {
        System.out.println("addCourse");
        Course course = null;
        Student instance = null;
        instance.addCourse(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Student instance = null;
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddDegreeTo() {
        System.out.println("addDegreeTo");
        int degree = 0;
        String title = "";
        Student instance = null;
        instance.addDegreeTo(degree, title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetSemester() {
        System.out.println("getSemester");
        Student instance = null;
        int expResult = 0;
        int result = instance.getSemester();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDegree() {
        System.out.println("getDegree");
        Course course = null;
        Student instance = null;
        Integer expResult = null;
        Integer result = instance.getDegree(course);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
}
