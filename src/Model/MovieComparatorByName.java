package Model;

import java.util.Comparator;

public class MovieComparatorByName implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        String A = a.gettitle();
        String B = b.gettitle();

        return A.compareTo(B);
    }
}
