package Model;

import java.util.Comparator;

public class MovieComparatorByCriticRating implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        return a.getscore().compareTo(b.getscore());
    }

}
