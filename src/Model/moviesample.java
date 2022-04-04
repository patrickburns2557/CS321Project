package Model;

import java.util.ArrayList;

public class moviesample {
    private String title = "SAMPLE";

    private float year = 2002;
    private int month = 2;
    private int day = 31;

    private String description = " Alien invasion. Humanity extincted.";
    private float runtime = 300;
    ArrayList director = new ArrayList();

    public ArrayList genre = new ArrayList();
    private String posterlink = "https://m.media-amazon.com/images/M/MV5BMjMxNTdiNWMtOWY0My00MjM4LTkwNzMtOGI0YThhN2Q4M2I4XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg";
    /** GETTER **/
    public String gettitle()
    {
        return this.title;
    }
    public float getyear()
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
