package Model;

import java.util.Comparator;

/**
 * Compares by critic rating
 */
public class MovieComparatorByCriticRating implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        //return a.getCriticRating().compareTo(b.getCriticRating());
        return Double.compare(a.getCriticRating(), b.getCriticRating());

    }
}