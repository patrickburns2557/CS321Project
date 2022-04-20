package Model;

import java.util.ArrayList;
import java.util.Collections;

public class User {
    private String username;
    private String password;
    private ArrayList<Collection> Collections;
    private ArrayList<UserRating> UserRatings;

    public User(String ur, String pw)
    {
        this.password = pw;
        this.username = ur;
        Collections = new ArrayList<Collection>();
        UserRatings = new ArrayList<UserRating>();
    }
    //Getter

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Collection> getCollections()
    {
        return Collections;
    }

    public ArrayList<UserRating> getUserRatings() {
        return UserRatings;
    }

    //Setter

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addCollection(Collection input)
    {
        Collections.add(input);
    }


    //other
    public void addUserRating(Movie mov, Integer score){
        UserRating rate = new UserRating(mov, score);
        this.UserRatings.add(rate);
    }
}
