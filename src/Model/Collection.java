package Model;

import java.util.ArrayList;

public class Collection {
    private String name;
    private ArrayList<Integer> movies;

    public Collection(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public ArrayList<Integer> getMovies() {

        return movies;
    }

    public void addMovie(Integer movie){

        movies.add(movie);
    }

    public void removeMovie(Integer movie){

        movies.remove(movie);
    }

    public void deleteCollection(){

        movies.clear();
    }
}
