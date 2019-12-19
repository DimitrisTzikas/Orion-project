package Framework;

public abstract class User {
    
    private String name;
    private String surname;
    private String username;
    
    public abstract boolean updateUser(User user);
    public abstract String showUser();
    
}
