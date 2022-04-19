package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class System {
    private ArrayList<Movie> masterList;
    private ArrayList<User> userList;
    private static System instance = null;

    static
    {
        instance = new System();
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

    public static System getInstance()
    {
        return instance;
    }

    public ArrayList<Movie> getMasterList()
    {
        //will want to clone
        return (ArrayList<Movie>) masterList.clone();

    }

}