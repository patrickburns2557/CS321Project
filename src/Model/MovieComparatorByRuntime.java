package Model;

import java.util.Comparator;

public class MovieComparatorByRuntime implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        String A = a.getruntime();
        String B = b.getruntime();
        return A.compareTo(B);
    }
}