package Model;

import java.util.Comparator;

public class MovieComparatorByRuntime implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        return a.getRuntime().compareTo(b.getRuntime());
    }
}
