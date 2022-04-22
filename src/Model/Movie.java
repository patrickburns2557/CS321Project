package Model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
/**
 * Standard class that stores information of a movie. Reused in other classes
 */
public class Movie
{
    private String Title = "";
    private Integer Year = 0;
    private String Plot = "";
    private String Runtime = "";
    private Float imdbRating = 0.0f;
    private String Poster = "";
    private String Director = "";
    private String Actors = "";
    private String Genre = "";
    private String Language = "";
    private String Rated = "";
    private String Country = "";

    /**
     *  Default constructor
     */
    public Movie() {}

    /**
     *  Takes a string list of objects and split them into an array
     * @param string The string list of objects separated by commas.
     * @return Array list of objects separated from string parameter
     */
    private ArrayList<String> toArrayList(String string) {
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, string.split(","));
        return strings;
    }

    /**
     * Get the title of the movie
     * @return String that contains the title of the movie
     */
    public String gettitle()
    {
        return this.Title;
    }
    /**
     * Gets the year of when the movie is released
     * @return Integar value representing the released year.
     */
    public Integer getyear()
    {
        return this.Year;
    }
    /**
     * Gets the plot of the movie
     * @return String that contains the description of the movie
     */
    public String getplot()
    {
        return this.Plot;
    }
    /**
     * Gets the list of directors of the movie
     * @return String contains all the directors
     */
    public String getdirector() {
        return this.Director;
    }
    /**
     *  Gets the list of directors of the movie as an array
     * @return Array list containing all the directors of the movie
     */
    public ArrayList<String> getDirectors()
	  {
        return toArrayList(Director);
    }
    /**
     * Gets the runtime of the movie
     * @return String containing how long the movie is
     */
    public String getruntime()
    {
        return this.Runtime;

    }
    /**
     * Gets the genre of the movie
     * @return String containing the genre of the movie
     */
    public String getgenre()
    {
        return this.Genre;
    }
    /**
     * Gets the genre of the movie as an array
     * @return Array list containing all the genre of the movie
     */
    public ArrayList<String> getGenres()
    {
        return toArrayList(Genre);
    }
    /**
     *
     * Get link address for the poster of the movie
     * @return String containing the web address for the poster of the movie
     */
    public String getposter()
    {
        return this.Poster;
    }
    /**
     * Gets the age rating for the movie
     * @return String containing the age rating of the movie
     */
    public String getagerating()
    {
        return this.Rated;
    }
    /**
     * Gets the languages that the movie is availalbe in
     * @return String containing the languages the movie is available in
     */
    public String getlanguage()
    {
        return this.Language;
    }
    /**
     * gets the languages the movie is available in as an array
     * @return Array list containing the languages the movie is available in
     */
    public ArrayList<String> getLanguages() {
        return toArrayList(Language);
    }
    /**
     * Gets the country of origin that the movie is in
     * @return String containing the country of origin
     */
    public String getcountry()
    {
        return this.Country;
    }
    /**
     * Gets the countries of origin that the movie is in as an array
     * @return Array list containing the countries of origin
     */
    public ArrayList<String> getCountries() {
        return toArrayList(Country);
    }
    /**
     *
     * @param
     * @return
     */
    public String getActors()
    {
        return this.Actors;
    }
    /**
     * Gets the imdb score of the movie
     * @return Float value that represents the imdb score of the movie
     */
    public float getCriticRating() {
        return this.imdbRating;
    }
}