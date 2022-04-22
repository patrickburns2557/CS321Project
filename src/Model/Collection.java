package Model;

import java.util.ArrayList;

/**
 * Class to hold collections that the user creates.
 * Contains an ArrayList of movies and the name of the collection.
 */
public class Collection implements Cloneable {
    private String name;
    private ArrayList<Movie> movies;

    /**
     * Public constructor that holds the variable name and Array List
     * @param name
     */
    public Collection(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    /**
     * Public constructor that holds the variable name and Array List object movie
     * @param name
     */
    public Collection(String name, ArrayList<Movie> movies)
    {
        this.name = name;
        this.movies = movies;
    }
  
    /**
     * Public Clone method used to make the Collection class Cloneable
     * @return
     */
    public Object clone()
    {
        try
        {
            Collection deepCopy = (Collection)super.clone();
            deepCopy.movies = (ArrayList)this.movies.clone();
            return deepCopy;
        } catch(CloneNotSupportedException ex)
        {
            return null;
        }
    }

    /**
     * Gets the name of the collection
     * @return - String of collection name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the collection
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the movie from the Array List
     * @return - ArrayList of movies contained in collection
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * Adds the movie to the Array List
     */

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    /**
     * Removes the movie from the Array Lisl
     */
    public void removeMovie(Movie movie){
        movies.remove(movie);
    }

    /**
     * Deletes the Collection
     */
    public void deleteCollection(){
        movies.clear();
    }
}