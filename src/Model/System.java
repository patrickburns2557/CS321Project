package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class System
{
    private ArrayList<Movie> masterList;
    private static System instance = null;
    static{
        instance = new System();
    }

    public static System getInstance() {
        return instance;
    }
    public Movie getMovie(int m){
        return masterList.get(m);
    }

    private System()
    {
        try
        {
            Movie[] list = JsonInterface.buildmasterlist("src\\Model\\Movies.json");
            masterList = new ArrayList<Movie>(Arrays.asList(list));
        }catch(IOException ex)
        {

        }
    }


}