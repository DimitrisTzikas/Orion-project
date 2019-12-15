package Model;

import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class TeacherNGTest {

    @Test
    public void testAddCourse() {
        System.out.println("addCourse");
        Course course = null;
        Teacher instance = null;
        instance.addCourse(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCourses() {
        System.out.println("getCourses");
        Teacher instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getCourses();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
