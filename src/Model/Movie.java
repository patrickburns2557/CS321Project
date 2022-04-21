package Model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
/**
 * Standard class that stores information of a movie.
 * Reused in other classes
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



    public Movie() {}

    private ArrayList<String> toArrayList(String string) {
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, string.split(","));
        return strings;
    }

    /* Getter */
    public String gettitle()
    {
        return this.Title;
    }
    public Integer getyear()
    {
        return this.Year;
    }
    public String getplot()
    {
        return this.Plot;
    }
    public String getdirector() {
        return this.Director;
    }
    public ArrayList<String> getDirectors()
	  {
        return toArrayList(Director);
    }
    public String getruntime()
    {
        return this.Runtime;

    }
    public float getscore()
    {
        return this.imdbRating;
    }
    public String getgenre()
    {
        return this.Genre;
    }
    public ArrayList<String> getGenres()
    {
        return toArrayList(Genre);
    }

    public String getposter()
    {
        return this.Poster;
    }

    public String getagerating()
    {
        return this.Rated;
    }

    public String getlanguage()
    {
        return this.Language;
    }

    public ArrayList<String> getLanguages() {
        return toArrayList(Language);
    }

    public String getcountry()
    {
        return this.Country;
    }

    public ArrayList<String> getCountries() {
        return toArrayList(Country);
    }

    public String getActors()
    {
        return this.Actors;
    }

    public float getCriticRating() {
        return this.imdbRating;
    }
}