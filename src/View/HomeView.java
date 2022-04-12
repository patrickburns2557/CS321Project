package View;

import Model.JsonInterface;
import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HomeView extends JPanel
{
    public HomeView()
    {

        this.setLayout(new BorderLayout());

        //TEMP FOR NOW
        ArrayList<String> tempMovieList = new ArrayList<String>();
        for(int i = 0; i<100; i++)
        {
            tempMovieList.add("Movie " + (i+1));
        }



        //Setup Movie grid
        //JUST CALLING JSON BUILDMASTERLIST TEMPORARILY FOR NOW UNTIL WE ARE ABLE TO PASS IN WHAT MOVIE LIST WE'RE CURRENTLY WORKING ON
        Movie[] list;
        try
        {
            list = JsonInterface.buildmasterlist("src\\Model\\Movies.json");


            MovieGrid grid = new MovieGrid(list);
            JScrollPane jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            jp.getVerticalScrollBar().setUnitIncrement(20);

            this.add(jp, BorderLayout.CENTER);
            this.add(new SearchPanel(), BorderLayout.NORTH);
        } catch(Exception ex)
        {

        }


    }

}
