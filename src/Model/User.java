package Model;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Collection> Collections;
    private ArrayList<UserRating> UserRatings;

    public User(String ur, String pw)
    {
        this.password = pw;
        this.username = ur;
    }
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