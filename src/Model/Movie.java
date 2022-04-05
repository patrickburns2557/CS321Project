package Model;

import java.util.ArrayList;
import java.util.Date;

public class Movie
{
    private String title = "";
    private Date date;
    private String description = "";
    private Float runtime = 0.0f;
    ArrayList<String> director = new ArrayList();
    ArrayList<String> genre = new ArrayList();
    private String posterlink = "";

    /** Setter **/
    public void setTitle(String str)
    {
        this.title = str;
    }
    public void setDate(Date date) { this.date = date; }
    public void setPlot(String plot)
    {
        this.description = plot;
    }
    public void setRuntime(float time)
    {
        this.runtime = time;
    }
    public void addDirector(String dr)
    {
        this.director.add(dr);
    }
    public void addGenre(String gn) { this.genre.add(gn); }
    public void setPosterLink(String link)
    {
        this.posterlink = link;
    }

    /** Getter **/
    public String getTitle()
    {
        return this.title;
    }
    public Date getDate() {return (Date)this.date.clone(); }
    public String getPlot()
    {
        return this.description;
    }
    public Float getRuntime() { return this.runtime; }
    public ArrayList<String> getGenre()
    {
        return (ArrayList<String>)this.genre.clone();
    }
    public String getPoster()
    {
        return this.posterlink;
    }
}