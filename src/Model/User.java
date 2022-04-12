package Model;

import java.util.List;

public class User {
    private String username;
    private String password;

    private List Collection;

    //Getter

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    //Setter

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}