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

        // Add running courses to students
        StudentNGTest.students.get(0).addCourse(StudentNGTest.courses.get(3));

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
        courses1.add(StudentNGTest.students.get(0).getCourses().get(3));

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

        courses5.add(StudentNGTest.courses.get(4));

        return new Object[][]{
            {StudentNGTest.students.get(0), courses1},
            {StudentNGTest.students.get(1), courses2},
            {StudentNGTest.students.get(2), courses3},
            {StudentNGTest.students.get(3), courses4},
            {StudentNGTest.students.get(4), courses5}
        };
    }

    @Test(dataProvider = "testGetAvaibleCourses")
    public void testGetAvaibleCourses(Student student, ArrayList<Course> courses) {
        System.out.println("getAvaibleCourses");
        ArrayList result = student.getAvaibleCourses();
        assertEquals(result, courses);
    }

    @DataProvider(name = "testGetRunningCourses")
    public static Object[][] getRunningCoursesData() {
        ArrayList<Course> courses1 = new ArrayList<Course>();
        ArrayList<Course> courses2 = new ArrayList<Course>();
        ArrayList<Course> courses3 = new ArrayList<Course>();
        ArrayList<Course> courses4 = new ArrayList<Course>();
        ArrayList<Course> courses5 = new ArrayList<Course>();

        courses1.add(StudentNGTest.courses.get(3));

        return new Object[][]{
            {StudentNGTest.students.get(0), courses1},
            {StudentNGTest.students.get(1), courses2},
            {StudentNGTest.students.get(2), courses3},
            {StudentNGTest.students.get(3), courses4},
            {StudentNGTest.students.get(4), courses5}
        };
    }

    @Test(dataProvider = "testGetRunningCourses")
    public void testGetRunningCourses(Student student, ArrayList<Course> courses) {
        System.out.println("getRunningCourses");
        ArrayList result = student.getRunningCourses();
        assertEquals(result, courses);
    }

    @DataProvider(name = "testGetPassedCourses")
    public static Object[][] getPassedCoursesData() {
        ArrayList<Course> courses1 = new ArrayList<Course>();
        ArrayList<Course> courses2 = new ArrayList<Course>();
        ArrayList<Course> courses3 = new ArrayList<Course>();
        ArrayList<Course> courses4 = new ArrayList<Course>();
        ArrayList<Course> courses5 = new ArrayList<Course>();

        courses1.add(StudentNGTest.courses.get(0));
        courses1.add(StudentNGTest.courses.get(1));
        courses1.add(StudentNGTest.courses.get(2));

        courses3.add(StudentNGTest.courses.get(0));
        courses3.add(StudentNGTest.courses.get(2));

        courses4.add(StudentNGTest.courses.get(0));
        courses4.add(StudentNGTest.courses.get(1));

        courses5.add(StudentNGTest.courses.get(0));
        courses5.add(StudentNGTest.courses.get(1));
        courses5.add(StudentNGTest.courses.get(2));
        courses5.add(StudentNGTest.courses.get(3));

        return new Object[][]{
            {StudentNGTest.students.get(0), courses1},
            {StudentNGTest.students.get(1), courses2},
            {StudentNGTest.students.get(2), courses3},
            {StudentNGTest.students.get(3), courses4},
            {StudentNGTest.students.get(4), courses5}
        };
    }

    @Test(dataProvider = "testGetPassedCourses")
    public void testGetPassedCourses(Student student, ArrayList<Course> courses) {
        System.out.println("getPassedCourses");
        ArrayList result = student.getPassedCourses();
        assertEquals(result, courses);
    }

    @DataProvider(name = "testGetNotPassedCourses")
    public static Object[][] getNotPassedCoursesData() {
        ArrayList<Course> courses1 = new ArrayList<Course>();
        ArrayList<Course> courses2 = new ArrayList<Course>();
        ArrayList<Course> courses3 = new ArrayList<Course>();
        ArrayList<Course> courses4 = new ArrayList<Course>();
        ArrayList<Course> courses5 = new ArrayList<Course>();

        courses4.add(StudentNGTest.courses.get(2));

        return new Object[][]{
            {StudentNGTest.students.get(0), courses1},
            {StudentNGTest.students.get(1), courses2},
            {StudentNGTest.students.get(2), courses3},
            {StudentNGTest.students.get(3), courses4},
            {StudentNGTest.students.get(4), courses5}
        };
    }

    @Test(dataProvider = "testGetNotPassedCourses")
    public void testGetNotPassedCourses(Student student, ArrayList<Course> courses) {
        System.out.println("getNotPassedCourses");
        ArrayList result = student.getNotPassedCourses();
        assertEquals(result, courses);
    }

    @DataProvider(name = "testAddDegree")
    public static Object[][] addDegreeData() {
        return new Object[][]{
            {StudentNGTest.students.get(0), StudentNGTest.courses.get(0), 10, true},
            {StudentNGTest.students.get(1), StudentNGTest.courses.get(0), 9, false},
            {StudentNGTest.students.get(2), StudentNGTest.courses.get(2), 8, true},
            {StudentNGTest.students.get(3), StudentNGTest.courses.get(3), 7, false},
            {StudentNGTest.students.get(4), StudentNGTest.courses.get(4), 9, false}
        };
    }

    @Test(dataProvider = "testAddDegree")
    public void testAddDegree(Student student, Course course, Integer degree, boolean expResult) {
        System.out.println("addDegree");
        boolean result = student.addDegree(course, degree);
        assertEquals(result, expResult);
    }

    @DataProvider(name = "testGetUsername")
    public static Object[][] getUsernameData() {
        return new Object[][]{
            {StudentNGTest.students.get(0), "student1"},
            {StudentNGTest.students.get(1), "student2"},
            {StudentNGTest.students.get(2), "student3"},
            {StudentNGTest.students.get(3), "student4"},
            {StudentNGTest.students.get(4), "student5"}
        };
    }

    @Test(dataProvider = "testGetUsername")
    public void testGetUsername(Student student, String username) {
        System.out.println("getUsername");
        String result = student.getUsername();
        assertEquals(result, username);
    }

    @DataProvider(name = "testGetSemester")
    public static Object[][] getSemesterData() {
        return new Object[][]{
            {StudentNGTest.students.get(0), 1},
            {StudentNGTest.students.get(1), 2},
            {StudentNGTest.students.get(2), 3},
            {StudentNGTest.students.get(3), 4},
            {StudentNGTest.students.get(4), 5}
        };
    }

    @Test(dataProvider = "testGetSemester")
    public void testGetSemester(Student student, int semester) {
        System.out.println("getSemester");
        int result = student.getSemester();
        assertEquals(result, semester);
    }

}
