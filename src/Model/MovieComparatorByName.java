package Model;

import java.util.Comparator;

public class MovieComparatorByName implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        return a.getTitle().compareTo(b.getTitle());
    }
}
