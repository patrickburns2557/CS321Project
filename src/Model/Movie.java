package Model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Movie
{
    private String Title = "";
	private Integer Year = 0;
    private String Plot = "";
    private Float Runtime = 0.0f;
    private Float imdbRating = 0.0f;

    private String Poster = "";
	private String Director = "";
	private String Genre = "";
	private String Language = "";
	private String Rated = "";
	private String Country = "";

    public Movie() {}

    /** Getter **/
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

    //public ArrayList<String> getDirectors()
	//{
    //    return (ArrayList<String>)this.director.clone();
    //}
	
    //public ArrayList<String> getGenres()
    //{
    //    return (ArrayList<String>)this.genre.clone();
    //}

    public Float getruntime() {
        return this.Runtime;
    }
	
    public Float getscore()
	{
		return this.imdbRating;
	}
	
    public String getgenre()
    {
        return this.Genre;
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
    
	public String getcountry()
    {
        return this.Country;
    }
}

