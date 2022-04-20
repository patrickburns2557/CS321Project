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

    public String getMovieTitle(){
        return this.movie;
    }

    public Integer getRated() {
        return this.Rated;
    }
}
