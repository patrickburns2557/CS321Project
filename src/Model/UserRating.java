package Model;

import Model.Movie;

/**
 * Class for storing user's rating of a movie.
 */
public class UserRating {
    String movie;
    Integer Rated;
    /**
     * Constructor for this class that will get and store the title of the movie that the user rated on and an integar value as the score.
     * @param inputmovie the movie that the user rated
     * @param score an integar value from 1 to 5 that is the score the user gave
     */
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
