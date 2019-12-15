package Model;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class PassValuesNGTest {
    
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        PassValues instance = new PassValues("title", 5);
        String expResult = "title";
        String result = instance.getTitle();
        assertEquals(result, expResult);
    }

    @Test
    public void testGetDegree() {
        System.out.println("getDegree");
        PassValues instance = new PassValues("title", 5);
        Integer expResult = 5;
        Integer result = instance.getDegree();
        assertEquals(result, expResult);
    }
    
}
