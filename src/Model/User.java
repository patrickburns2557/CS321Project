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
        return (ArrayList<Collection>)Collections.clone();
    }

    public ArrayList<UserRating> getUserRatings() {
        return (ArrayList<UserRating>)UserRatings.clone();
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

    /*public void removeCollection(String collectionName) {
        Collections.removeIf(collection -> collection.getName().equals(collectionName));
    }*/

    public void removeCollection(Collection collection) {
        Collections.remove(collection);
    }

    //other
    public void addUserRating(Movie mov, Integer score){
        UserRating rate = new UserRating(mov, score);
        this.UserRatings.add(rate);
    }
}
