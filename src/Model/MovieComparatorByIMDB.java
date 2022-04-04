package Model;

import java.util.Comparator;

public class MovieComparatorByIMDB implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        return a.getScore().compareTo(b.getScore());
    }
}
