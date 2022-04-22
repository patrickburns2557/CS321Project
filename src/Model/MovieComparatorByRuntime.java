package Model;

import java.util.Comparator;

/**
 * Compares by runtime (longest -> shortest)
 */
public class MovieComparatorByRuntime implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        Integer A = Integer.parseInt(a.getruntime().split(" ")[0]);
        Integer B = Integer.parseInt(b.getruntime().split(" ")[0]);
        return B.compareTo(A);
    }
}