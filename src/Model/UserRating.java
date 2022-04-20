package Model;

import Model.Movie;

public class UserRating {
    String movie;
    Integer Rated;

    public UserRating(Movie inputmovie, Integer score)
    {
        this.movie = inputmovie.gettitle();
        this.Rated = score;
    }

    public UserRating() {
    }
}
