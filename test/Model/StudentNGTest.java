package Model;

import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class StudentNGTest {
    
    @Test
    public void testCheckCourseRequirements() {
        System.out.println("checkCourseRequirements");
        Course course = null;
        Student instance = null;
        boolean expResult = false;
        boolean result = instance.checkCourseRequirements(course);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCourses() {
        System.out.println("getCourses");
        Student instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getCourses();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAvaibleCourses() {
        System.out.println("getAvaibleCourses");
        Student instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getAvaibleCourses();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

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
    public void testGetDegrees() {
        System.out.println("getDegrees");
        Student instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getDegrees();
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

    @Test
    public void testToString() {
        System.out.println("toString");
        Student instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
