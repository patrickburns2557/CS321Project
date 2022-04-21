package Model;

import View.MainWindow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class to handle the program's masterList of movies,
 * the program's userList of all users,
 * and the currently logged-in user
 * IS A SINGLETON CLASS
 */
public class System {
    private ArrayList<Movie> masterList;
    private ArrayList<User> userList;
    private User currentUser;
    private static System instance = null;

    //Create the singleton class's one instance
    static
    {
        instance = new System();
    }

    /**
     * Private constructor to create the singleton class's one instance
     * Loads the movie masterList and userList from their respective JSON files
     */
    private System()
    {
        try
        {
            Movie[] list = JsonInterface.buildmasterlist("src\\Model\\Movies.json");
            masterList = new ArrayList<Movie>(Arrays.asList(list));

            User[] users = JsonInterface.getuserlist("src\\Model\\MasterUser.json");
            userList = new ArrayList<User>(Arrays.asList(users));
        }catch(IOException ex)
        {
            java.lang.System.out.println("Error loading movie masterList and userList, exiting program.");
            java.lang.System.exit(1);
        }

    }

    /**
     * Get the singleton instance of System
     * @return - System's singleton instance
     */
    public static System getInstance()
    {
        return instance;
    }

    /**
     * Returns the masterList
     * @return - Arraylist of all movies
     */
    public ArrayList<Movie> getMasterList()
    {
        return (ArrayList<Movie>) masterList.clone();

    }

    /**
     * Returns the userList
     * @return - Arraylist of all users
     */
    public ArrayList<User> getUserList()
    {
        return userList;
    }

    /**
     * Returns the currently logged-in user
     * @return - User object of currently logged-in user
     */
    public User getCurrentUser()
    {
        return currentUser;
    }

    /**
     * Attempts to set the currentUser to the user indicated by the username and password
     * @param userName - Username to login with
     * @param password - Password to login with
     * @return - Bool variable indicating if a user with matching username and password was found and loaded
     */
    public boolean loginUser(String userName, String password)
    {
        //Iterate through userList and see if any user's with matching username and password exist
        for(User u : userList)
        {
            //log into that user if so
            if(userName.equals(u.getUsername()) && password.equals(u.getPassword()))
            {
                currentUser = u;
                MainWindow.getInstance().ShowHomeOnLogin();
                return true;
            }
        }
        //no matching user found
        return false;
    }

    /**
     * Logs out currentUser by setting it to null
     * and refreshes homeView to reflect this change
     */
    public void logoutUser()
    {
        currentUser = null;
        MainWindow.getInstance().ShowHomeOnLogin();
    }

    /**
     * Create a new user
     * @param input - new user to add to userList
     */
    public void addUser(User input)
    {
        userList.add(input);
    }

    /**
     * Iterate through all users to calculate the userRating for indicated movie
     * @param movie - movie to calculate user rating for
     * @return - double value between 1 and 5, or 0 if no ratings exist yet, indicating average of all user ratings for said movie
     */
    public double calculateUserRatingForMovie(Movie movie)
    {
        int counter = 0;
        double rating = 0.0;
        for(User user : userList)
        {
            for(UserRating userRating : user.getUserRatings())
            {
                if(userRating.getMovieTitle().equals(movie.gettitle()))
                {
                    rating += (double) userRating.getRated();
                    counter++;
                }
            }
        }

        //avoid dividing by 0
        //indicates that there are no ratings for the current movie
        if(counter == 0)
        {
            return 0;
        }

        rating = rating / ((double) counter);
        return rating;
    }

    /**
     * Iterates through all users to count how many userRatings there are for the indicated movie
     * @param movie - Movie to count user ratings for
     * @return - int value indicating how many ratings are currently stored for said movie
     */
    public int calculateNumberUserRatingsForMovie(Movie movie)
    {
        int counter = 0;
        for(User user : userList)
        {
            for(UserRating userRating : user.getUserRatings())
            {
                if(userRating.getMovieTitle().equals(movie.gettitle()))
                {
                    counter++;
                }
            }
        }
        return counter;
    }

}