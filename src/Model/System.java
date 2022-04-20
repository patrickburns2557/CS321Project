package Model;

import View.MainWindow;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class System {
    private ArrayList<Movie> masterList;
    private ArrayList<User> userList;
    private User currentUser;
    private static System instance = null;

    static
    {
        instance = new System();
    }

    private System()
    {
        try
        {
            Movie[] list = JsonInterface.buildmasterlist("src\\Model\\Movies.json");
            masterList = new ArrayList<Movie>(Arrays.asList(list));

            User[] users = JsonInterface.getuserlist("src\\MasterUser.json");
            userList = new ArrayList<User>(Arrays.asList(users));
            //userList = new ArrayList<User>();


            //TEMP test users
            /*User admin = new User("admin", "password");
            Collection collectionA = new Collection("Collection A", new ArrayList<>(masterList.subList(0, 3)));
            Collection collectionB = new Collection("Collection B", new ArrayList<>(masterList.subList(9, 20)));
            Collection collectionC = new Collection("Collection C", new ArrayList<>(masterList.subList(21, 26)));
            Collection collectionD = new Collection("Collection D", new ArrayList<>(masterList.subList(17, 55)));
            Collection collectionE = new Collection("Collection E", new ArrayList<>(masterList.subList(3, 5)));
            Collection collectionF = new Collection("Collection F", new ArrayList<>(masterList.subList(2, 10)));
            admin.addCollection(collectionA);
            admin.addCollection(collectionB);
            admin.addCollection(collectionC);
            admin.addCollection(collectionD);
            admin.addCollection(collectionE);
            admin.addCollection(collectionF);
            currentUser = admin;
            addUser(admin);*/

            //loginUser("admin", "password");






        }catch(IOException ex)
        {

        }

    }

    public static System getInstance()
    {
        return instance;
    }

    public ArrayList<Movie> getMasterList()
    {
        return (ArrayList<Movie>) masterList.clone();

    }

    public ArrayList<User> getUserList()
    {
        return userList;
    }

    public User getCurrentUser()
    {
        return currentUser;
    }

    public boolean loginUser(String userName, String password)
    {
        for(User u : userList)
        {
            if(userName.equals(u.getUsername()) && password.equals(u.getPassword()))
            {
                currentUser = u;
                MainWindow.getInstance().ShowHomeOnLogin();
                return true;
            }
        }
        return false;
    }

    public void logoutUser()
    {
        currentUser = null;
        MainWindow.getInstance().ShowHomeOnLogin();
    }

    public void addUser(User input)
    {
        userList.add(input);
    }

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

        if(counter == 0)
        {
            return 0;
        }

        rating = rating / ((double) counter);
        return rating;
    }

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