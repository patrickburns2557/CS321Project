import java.util.ArrayList;

public class Collection {
    private String name;
    private ArrayList<Movie> movies;

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
