package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Collection implements Cloneable {
    private String name;
    private ArrayList<Movie> movies;

    public Collection(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public Collection(String name, ArrayList<Movie> movies)
    {
        this.name = name;
        this.movies = movies;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public void removeMovie(Movie movie){
        movies.remove(movie);
    }

    public void deleteCollection(){
        movies.clear();
    }
}