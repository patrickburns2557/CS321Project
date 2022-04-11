package Model;

import java.util.ArrayList;

public class Movie
{
    private String Title;

    private Integer Year;
    private String month;
    private Integer day;

    private String Plot;
    private String Runtime;
    private float imdbRating;
    private String Director;
    private String Genre;
    private String Poster ;

    private String Language;
    private String Rated;
    private String Country;

    /** Setter **/
    public void setTitle(String str)
    {
        this.Title = str;
    }
    public void setreleaseyear(int yr)
    {
        this.Year = yr;
    }
    public void setreleasemonth(String mn)
    {
        this.month = mn;
    }
    public void setreleaseday(int day)
    {
        this.day = day;
    }
    public void setplot(String plot)
    {
        this.Plot = plot;
    }
    public void setruntime(String time)
    {
        this.Runtime = time;
    }
    public void setimdbscore(int score){this.imdbRating = score;}
   /* public void adddirector(String dr)
    {
        this.Director.add(dr);
    }
    public void addgenre(String gn)
    {
        this.Genre.add(gn);
    }*/
    public void setposterlink(String link)
    {
        this.Poster = link;
    }
    /*
        public void addlanguage(String lg)
        {
            this.Genre.add(lg);
        }
        public void addcountry(String cc)
        {
            this.Genre.add(cc);
        }*/
    public void setagerating(String rate)
    {
        this.Rated = rate;
    }

    /** GETTER **/
    public String gettitle()
    {
        return this.Title;
    }
    public int getyear()
    {
        return this.Year;
    }
    public String getmonth()
    {
        return this.month;
    }
    public int getday()
    {
        return this.day;
    }
    public String getplot()
    {
        return this.Plot;
    }
    public String getruntime()
    {
        return this.Runtime;

    }
    public float getscore(){return this.imdbRating;}
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
