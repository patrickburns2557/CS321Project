package Model;


import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Class for storing user's account information
 */

public class User {
    private String username;
    private String password;
    private ArrayList<Collection> Collections;
    private ArrayList<UserRating> UserRatings;
    private List Collection;
    /**
     * Constructor for this class that will set the username and password string automatically
     * @param ur The String that is the username of the user
     * @param pw The String that is the password of the user
     */
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
  
    public void removeCollection(Collection collection) {
        Collections.remove(collection);
    }
  
   /**
     * Add a movie and its rating rated by the user to the user's array list of rated movies
     * @param mov The movie that the user rated
     * @param score An integar value from 1 to 5 that the user rated the movie as
     */
    public void addUserRating(Movie mov, Integer score){
        UserRating rate = new UserRating(mov, score);
        this.UserRatings.add(rate);
    }
}
