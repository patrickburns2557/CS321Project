package Model;

import java.util.Comparator;

public class MovieComparatorByDate implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        return a.getDate().compareTo(b.getDate());
    }
}
