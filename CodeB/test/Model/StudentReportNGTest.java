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
public class StudentReportNGTest {
    
    public StudentReportNGTest() {
    }

    /**
     * Test of getAction method, of class StudentReport.
     */
    @Test
    public void testGetAction() {
        System.out.println("getAction");
        StudentReport instance = null;
        String expResult = "";
        String result = instance.getAction();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAm method, of class StudentReport.
     */
    @Test
    public void testGetAm() {
        System.out.println("getAm");
        StudentReport instance = null;
        String expResult = "";
        String result = instance.getAm();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourseTitle method, of class StudentReport.
     */
    @Test
    public void testGetCourseTitle() {
        System.out.println("getCourseTitle");
        StudentReport instance = null;
        String expResult = "";
        String result = instance.getCourseTitle();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJDate method, of class StudentReport.
     */
    @Test
    public void testGetJDate() {
        System.out.println("getJDate");
        StudentReport instance = null;
        String expResult = "";
        String result = instance.getJDate();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMsg method, of class StudentReport.
     */
    @Test
    public void testGetMsg() {
        System.out.println("getMsg");
        StudentReport instance = null;
        String expResult = "";
        String result = instance.getMsg();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExDate method, of class StudentReport.
     */
    @Test
    public void testGetExDate() {
        System.out.println("getExDate");
        StudentReport instance = null;
        String expResult = "";
        String result = instance.getExDate();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDegree method, of class StudentReport.
     */
    @Test
    public void testGetDegree() {
        System.out.println("getDegree");
        StudentReport instance = null;
        String expResult = "";
        String result = instance.getDegree();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentReports method, of class StudentReport.
     */
    @Test
    public void testGetStudentReports() {
        System.out.println("getStudentReports");
        ArrayList expResult = null;
        ArrayList result = StudentReport.getStudentReports();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
