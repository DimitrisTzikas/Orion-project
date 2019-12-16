package Model;

import Enum.AnnouncementType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Announcement implements Serializable {
    
    private static ArrayList<Announcement> announcements = new ArrayList<Announcement>();
    
    private String title;
    private AnnouncementType type;
    private String description;
    private String author;
    
    public Announcement(String title, AnnouncementType type, String description) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.author = Main.user.username;
    }
    
    
    public static boolean createAnnouncement(String title, AnnouncementType type, String description) {
        if(title.equals("") || type == null || description.equals(""))
            return false;
        
        Announcement.announcements.add(new Announcement(title, type, description));
        Announcement.writeToFile();
        return true;
    }

    public String getTitle() {
        return title;
    }

    public AnnouncementType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
    
     public String getAuthor() {
        return author;
    }
    
    public static ArrayList<Announcement> getAnnouncement()
    {
        return Announcement.announcements;
    }
     
    @Override
    public String toString() {
        return "Announcement{" + "title=" + title + ", type=" + type + ", description=" + description  + '}';
    }
    
    public static void writeToFile() {
        try{
            FileOutputStream writeData = new FileOutputStream("Announcements.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            
            writeStream.writeObject(Announcement.announcements);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            //e.printStackTrace();
            System.out.println("CANT save to ANNOUNCEMENTS");
        }
    }
    
    public static void importFromFile() throws IOException {
        try{
            FileInputStream readData = new FileInputStream("Announcements.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            Announcement.announcements = (ArrayList<Announcement>) readStream.readObject();
            readStream.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
