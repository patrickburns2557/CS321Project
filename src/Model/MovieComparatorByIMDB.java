package Model;

import java.util.Comparator;

public class MovieComparatorByIMDB implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        float A = a.getscore();
        float B = b.getscore();

        if(A == B)
        {
            return 1;
        }
        else{
            return 0;}
    }
}