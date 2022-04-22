package Model;

import java.util.Comparator;

public class MovieComparatorByIMDB implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        float A = a.getCriticRating();
        float B = b.getCriticRating();

        if(A == B)
        {
            return 1;
        }
        else{
            return 0;}
    }
}