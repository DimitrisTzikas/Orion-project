package Framework;

import java.util.ArrayList;

public class Users {
    
    private static ArrayList<User> users;
    
    public static boolean addUser(User user) {
        // Adds a user to users
        // Returns false if user exists
        if(Users.users.contains(user)){
            return false;
        }
        return Users.users.add(user);
    }
    
    public static boolean removeUser(User user) {
        // Removes a user from users
        return Users.users.remove(user);
    }
    
    public static ArrayList<User> getUsers() {
        // Returns a copy of users
        return new ArrayList<User>(Users.users);
    }
    
    public static boolean updateUser(User user) {
        // User defined method
        return user.updateUser(user);
    }
    
}
