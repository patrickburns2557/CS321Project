package Model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Movie
{
    private String title = "";
    private GregorianCalendar date = new GregorianCalendar();
    private Integer year = 0;
    private String description = "";
    private Float runtime = 0.0f;
    private Float criticRating = 0.0f;
    ArrayList<String> director = new ArrayList<>();
    ArrayList<String> genre = new ArrayList<>();
    private String posterLink = "";

    public Movie() {}

    /** Setter **/
    public void setTitle(String str)
    {
        this.title = str;
    }
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public void setPlot(String plot)
    {
        this.description = plot;
    }
    public void setRuntime(Float time)
    {
        this.runtime = time;
    }
    public void setCriticRating(Float criticRating) {
        this.criticRating = criticRating;
    }
    public void addDirector(String dr)
    {
        this.director.add(dr);
    }
    public void addGenre(String gn) {
        this.genre.add(gn);
    }
    public void setPosterLink(String link)
    {
        this.posterLink = link;
    }

    /** Getter **/
    public String getTitle()
    {
        return this.title;
    }
    public GregorianCalendar getDate() {
        return (GregorianCalendar)this.date.clone();
    }
    public Integer getYear() {
        return this.year;
    }
    public String getPlot()
    {
        return this.description;
    }
    public Float getRuntime() {
        return this.runtime;
    }
    public Float getCriticRating() {
        return this.criticRating;
    }
    public ArrayList<String> getDirectors() {
        return (ArrayList<String>)this.director.clone();
    }
    public ArrayList<String> getGenres()
    {
        return (ArrayList<String>)this.genre.clone();
    }
    public String getPoster()
    {
        return this.posterLink;
    }
}