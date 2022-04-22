package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public Collection clone()
    {
        try
        {
            return (Collection) super.clone();
        } catch(CloneNotSupportedException ex)
        {
            return null;
        }
    }

    /**
     * Gets the name of the collection
     * @return
     */

    public String getName() {

        return name;
    }

    /**
     * Sets the name of the collection
     * @return
     */

    public void setName(String name) {

        this.name = name;
    }

    /**
     * Gets the movie from the Arrary List
     * @return
     */

    public ArrayList<Movie> getMovies() {

        return movies;
    }

    /**
     * Adds the movie to the Arrary List
     * @return
     */

    public void addMovie(Movie movie){

        movies.add(movie);
    }

    /**
     * Removes the movie from the Arrary List
     * @return
     */

    public void removeMovie(Movie movie){

        movies.remove(movie);
    }

    /**
     * Deletes the Collection
     * @return
     */

    public void deleteCollection(){

        movies.clear();
    }
}