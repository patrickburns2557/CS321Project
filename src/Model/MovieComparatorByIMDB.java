package Model;

import java.util.Comparator;

public class MovieComparatorByIMDB implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        Integer A = a.getscore();
        Integer B = b.getscore();
        return A.compareTo(B);
    }
}
