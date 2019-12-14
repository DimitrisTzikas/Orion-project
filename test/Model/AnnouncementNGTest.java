package Model;

import Enum.AnnouncementType;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AnnouncementNGTest {
    
    @BeforeMethod
    public void initialize() {
        Main.user = new Secretariat("admin", "123456", "add1", "add2", new Date(), "email@email.com", "6900000000");
    }
    
    @DataProvider(name = "testCreateAnnouncement")
    public static Object[][] createAnnouncementData() {
        return new Object[][]{
            {"", null, "", false},
            {"title", null, "description", false},
            {"title", AnnouncementType.Exam1, "", false},
            {"title", AnnouncementType.General, "description", true},
            {"title", AnnouncementType.Exam1, "description", true}
        };
    }
    
    @Test(dataProvider = "testCreateAnnouncement")
    public void testCreateAnnouncement(String title, AnnouncementType type, String description, boolean expResult) {
        System.out.println("createAnnouncement");
        boolean result = Announcement.createAnnouncement(title, type, description);
        assertEquals(result, expResult);
    }   

    @DataProvider(name = "testGetTitle")
    public static Object[][] getTitleData() {
        return new Object [][]{
            {new Announcement("test", AnnouncementType.Exam1, "description"), "test"},
            {new Announcement("test", AnnouncementType.Exam1, "description"), "test"},
            {new Announcement("foo", AnnouncementType.Exam1, "description"), "foo"},
            {new Announcement("oof", AnnouncementType.Exam1, "description"), "oof"},
            {new Announcement("orion", AnnouncementType.Exam1, "description"), "orion"}
        };
    }
    
    @Test(dataProvider = "testGetTitle")
    public void testGetTitle(Announcement announcement, String title) {
        System.out.println("getTitle");
        String result = announcement.getTitle();
        assertEquals(result, title);
    }

    @DataProvider(name = "testGetType")
    public static Object[][] getTypeData() {
        return new Object[][]{
            {new Announcement("test", AnnouncementType.General, "description"), AnnouncementType.General},
            {new Announcement("test", AnnouncementType.Exam1, "description"), AnnouncementType.Exam1},
            {new Announcement("foo", AnnouncementType.Exam2, "description"), AnnouncementType.Exam2},
            {new Announcement("oof", AnnouncementType.Exam3, "description"), AnnouncementType.Exam3},
            {new Announcement("orion", AnnouncementType.Exam4, "description"), AnnouncementType.Exam4}
        };
    }
    
    @Test(dataProvider = "testGetType")
    public void testGetType(Announcement announcement, AnnouncementType announcementType) {
        System.out.println("getType");
        AnnouncementType result = announcement.getType();
        assertEquals(result, announcementType);
    }

    @DataProvider(name = "testGetDescription")
    public static Object[][] getDescriptionData() {
        return new Object[][]{
            {new Announcement("test", AnnouncementType.General, "description"), "description"},
            {new Announcement("test", AnnouncementType.Exam1, "foo"), "foo"},
            {new Announcement("foo", AnnouncementType.Exam2, "oof oof foo"), "oof oof foo"},
            {new Announcement("oof", AnnouncementType.Exam3, "123 123"), "123 123"},
            {new Announcement("orion", AnnouncementType.Exam4, "321 321"), "321 321"}
        };
    }
    
    @Test(dataProvider = "testGetDescription")
    public void testGetDescription(Announcement announcement, String description) {
        System.out.println("getDescription");
        String result = announcement.getDescription();
        assertEquals(result, description);
    }

    @DataProvider(name = "testGetAuthor")
    public static Object[][] getAuthorData() {
        return new Object[][]{
            {new Announcement("test", AnnouncementType.General, "description")}
        };
    }
    
    @Test(dataProvider = "testGetAuthor")
    public void testGetAuthor(Announcement announcement) {
        System.out.println("getAuthor");
        String result = announcement.getAuthor();
        assertEquals(result, Main.user.username);
    }
    
}
