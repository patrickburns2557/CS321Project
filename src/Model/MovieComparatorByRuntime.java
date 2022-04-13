package Model;

import java.util.Comparator;

public class MovieComparatorByRuntime implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        Integer A = a.getruntime();
        Integer B = b.getruntime();
        return A.compareTo(B);
    }
}
