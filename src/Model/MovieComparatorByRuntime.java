package Model;

import java.util.Comparator;

public class MovieComparatorByRuntime implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        Float A = a.getruntime();
        Float B = b.getruntime();
        return A.compareTo(B);
    }
}
