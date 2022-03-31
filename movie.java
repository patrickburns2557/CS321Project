import java.util.ArrayList;

public class movie {
    private String title = " ";

        private int year = 0;
        private int month = 0;
        private int day = 0;

    private String description = " ";
    private float runtime = 0;
    ArrayList director = new ArrayList();

    ArrayList genre = new ArrayList();
    private String posterlink = " ";

    /** Setter **/
    public void setTitle(String str)
    {
        this.title = str;
    }
    public void setreleaseyear(int yr)
    {
        this.year = yr;
    }
    public void setreleasemonth(int mn)
    {
        this.month = mn;
    }
    public void setreleaseday(int day)
    {
        this.day = day;
    }
    public void setplot(String plot)
    {
        this.description = plot;
    }
    public void setruntime(float time)
    {
        this.runtime = time;
    }
    public void adddirector(String dr)
    {
        this.director.add(dr);
    }
    public void addgenre(String gn)
    {
        this.genre.add(gn);
    }
    public void setposterlink(String link)
    {
        this.posterlink = link;
    }

    /** GETTER **/
    public String gettitle()
    {
        return this.title;
    }
    public int getyear()
    {
        return this.year;
    }
    public int getmonth()
    {
        return this.month;
    }
    public int getday()
    {
        return this.day;
    }
    public String getplot()
    {
        return this.description;
    }
    public float getruntime()
    {
        return this.runtime;

    }
    public ArrayList getgenre()
    {
        return this.genre;
    }
    public String getposter()
    {
        return this.posterlink;
    }







}
