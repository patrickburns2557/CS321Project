package Model;

import java.util.Comparator;

/**
 * Compares by name (alphabetically a-z)
 */
public class MovieComparatorByName implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        String A = a.gettitle();
        String B = b.gettitle();

        return A.compareTo(B);
    }
}