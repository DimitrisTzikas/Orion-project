/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author dimitris
 */
public class CurriculumnNGTest {
    
    public CurriculumnNGTest() {
    }

    /**
     * Test of addCourse method, of class Curriculumn.
     */
    @Test
    public void testAddCourse_Course() {
        System.out.println("addCourse");
        Course course = null;
        Curriculumn.addCourse(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCourse method, of class Curriculumn.
     */
    @Test
    public void testAddCourse_ArrayList() {
        System.out.println("addCourse");
        ArrayList<Course> course = null;
        Curriculumn.addCourse(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCourse method, of class Curriculumn.
     */
    @Test
    public void testRemoveCourse() {
        System.out.println("removeCourse");
        Course course = null;
        Curriculumn.removeCourse(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurriculum method, of class Curriculumn.
     */
    @Test
    public void testGetCurriculum_0args() {
        System.out.println("getCurriculum");
        ArrayList expResult = null;
        ArrayList result = Curriculumn.getCurriculum();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurriculum method, of class Curriculumn.
     */
    @Test
    public void testGetCurriculum_int() {
        System.out.println("getCurriculum");
        int semester = 0;
        ArrayList expResult = null;
        ArrayList result = Curriculumn.getCurriculum(semester);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurriculumConsole method, of class Curriculumn.
     */
    @Test
    public void testGetCurriculumConsole() {
        System.out.println("getCurriculumConsole");
        int semester = 0;
        Curriculumn.getCurriculumConsole(semester);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNonCurriculum method, of class Curriculumn.
     */
    @Test
    public void testGetNonCurriculum() {
        System.out.println("getNonCurriculum");
        ArrayList expResult = null;
        ArrayList result = Curriculumn.getNonCurriculum();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToFile method, of class Curriculumn.
     */
    @Test
    public void testWriteToFile() {
        System.out.println("writeToFile");
        Curriculumn.writeToFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importFromFile method, of class Curriculumn.
     */
    @Test
    public void testImportFromFile() throws Exception {
        System.out.println("importFromFile");
        Curriculumn.importFromFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
