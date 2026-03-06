import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    // Constructor: Initialize users list with a default user
    public AuthenticationService() {
        users = new ArrayList<>();
        // Adding a default user, e.g., username: "admin", password: "admin123"
        users.add(new User("admin", "admin123"));
    }

    @Override
    public User signUp(String username, String password) {
        // Check if username already exists
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return null; // Username is taken
            }
        }
        // Create and add new user
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    @Override
    public User logIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Successful login
            }
        }
        return null; // No matching user found
    }

    // Getter for users list
    public ArrayList<User> getUsers() {
        return users;
    }

    // Setter for users list
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}