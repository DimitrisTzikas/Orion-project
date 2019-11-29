package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public abstract class User implements Serializable {

    private static ArrayList<User> users = new ArrayList<User>();
    String username;
    String password;
    String name;
    String surname;
    Date birthday;
    String email;
    String phoneNumber;
    Date registration;

    public User(String username, String password, String name, String surname, Date birthday, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registration = new Date();
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getRegistration() {
        return registration;
    }
    
    public static boolean addUser(User user) {
        // TODO Check Data
        User.users.add(user);
        return true;
    }
    
    public static User getUser(int index) {
        return User.users.get(index);
    }
    
    public static boolean login(String username, String password) {
        for(User user: users) {
            if(user.username.equals(username) && user.password.equals(password))
                return true;
        }
        return false;
    }
    
    public static Student getStudent(String username) {
        for(User user:User.users) {
            if(user instanceof Student && ((Student) user).getUsername().equals(username))
                return (Student) user;
        }
        return null;
    }
    
    public static User find(String username) {
        for(User user: users) {
            if(user.username.equals(username))
                return user;
        }
        return null;
    }
    
    public static void writeToFile() {
        try{
            FileOutputStream writeData = new FileOutputStream("Users.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(User.users);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void importFromFile() {
        try{
            FileInputStream readData = new FileInputStream("Users.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            User.users = (ArrayList<User>) readStream.readObject();
            readStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

