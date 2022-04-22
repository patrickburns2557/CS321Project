package Model;

import java.util.Comparator;

/**
 * Compares by date
 */
public class MovieComparatorByDate implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        Integer A = a.getyear();
        Integer B = b.getyear();
        return A.compareTo(B);
    }
}