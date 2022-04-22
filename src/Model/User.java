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

    /**
     * Gets the password of the user
     * @return String containing the password
     */

    public String getPassword() {
        return password;
    }
    /**
     * Gets the username of the user
     * @return String containing the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Gets the collection of movies of the user
     * @return Array list of movie collections of the user
     */
    public ArrayList<Collection> getCollections()
    {
        return Collections;
    }
    /**
     * Gets the movie ratings that the user had rated on
     * @return Array list containing the movies titles and the rating that the user rated
     */
    public ArrayList<UserRating> getUserRatings() {
        return UserRatings;
    }

    /**
     * Sets the password to input parameter
     * @param password The string that will replace current password string
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the password to input parameter
     * @param username The string that will replace the current string
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Add a movie collection to the user's collection of movies
     * @param input The collection to be added into the user's collection of movies
     */
    public void addCollection(Collection input)
    {
        Collections.add(input);
    }
    /**
     * Remove a movie collection from user's list of movie collections
     * @param collection The collection to be removed from user's list of movie collection
     */
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
