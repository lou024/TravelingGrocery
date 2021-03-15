package edu.csc480.aisles.system.user;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRecords {
    private static UserRecords INSTANCE = new UserRecords();

    private UserRecords() { //key userID, value is User object
        //users.put("poop1", new User("poop1", "1204283h9dncxzjcnwx", "Joe Exotic"));
        //users.put("poop2", new User("poop2", "198ued8hq9js3x", "Carole Baskin"));
        //users.put("poop3", new User("poop3", "cj8du9h73b47f", "James Bond"));
        //users.put("poop4", new User("poop4", "dhc8h3f3j98ke2x", "Mark Zucc"));
    }

    public static UserRecords getUserRecords() { return INSTANCE; }

    private Map<String, User> users = new HashMap<>();

    // command to view all users
    // curl -X GET "http://localhost:8080/user/records" -H "accept: application/json"
    public Collection<User> viewAllUsers() {
        return users.values();
    }

    public User takeUser(String userID) {
        return users.remove(userID);
    }

    public void depositUser(User newUser) {
        users.put(newUser.getId(), newUser);
        System.out.println(newUser.getId());
    }

    public void updateUser(User updatedUser) {
        users.put(updatedUser.getId(), updatedUser);
    }

}
