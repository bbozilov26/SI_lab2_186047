import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function (User user, List<String> allUsers) { // node 1
        if (user==null) { // node 2
            throw new RuntimeException("The user argument is not initialized!"); // node 3
        }
        else {
            if (user.getUsername()==null || allUsers.contains(user.getUsername())) { // node 4
                throw new RuntimeException("User already exists!"); // node 5
            }
            else {
                if (user.getEmail()==null) // node 6
                    return false; // node 7
                boolean atChar = false, dotChar = false; // node 8
                for (int i=0;i<user.getEmail().length();i++) { // nodes 9.1, 9.2, 9.3
                    if (user.getEmail().charAt(i)=='@') // node 10
                        atChar = true; // node 11
                    if (atChar && user.getEmail().charAt(i)=='.') { // node 12
                        dotChar = true; // node 13
                    }
                } // node 14
                if (!atChar || !dotChar) { // node 15
                    return false; // node 16
                }
            }
        }
        return true; // node 17
    } // node 18
}