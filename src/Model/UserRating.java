package Model;

import Model.Movie;

public class UserRating {
    String movie;
    Integer Rated;

    UserRating(Movie inputmovie, Integer score)
    {
        this.movie = inputmovie.gettitle();
        this.Rated = score;
    }


}
