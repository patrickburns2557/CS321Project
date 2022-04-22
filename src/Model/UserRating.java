package Model;

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

    /**
     * Default Constructor for the Class
     */

    public UserRating() {
    }

    /**
     * Gets the name of the movie
     * @return - Returns String of movie name
     */
    public String getMovieTitle(){
        return this.movie;
    }

    /**
     * Gets the Rating for the User
     * @return - returns integer value of rating
     */
    public Integer getRated() {
        return this.Rated;
    }
}
