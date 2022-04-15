package Model;


import java.util.ArrayList;

public class Collection implements Cloneable {

    public Collection clone() throws CloneNotSupportedException {
        try {
            return (Collection) super.clone();
        } catch (CloneNotSupportedException e) {

            return null;
        }


    }



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
