package View;

import Model.JsonInterface;
import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HomeView extends JPanel
{
    private MovieGrid grid;
    public HomeView()
    {

        this.setLayout(new BorderLayout());
        JPanel temp = new JPanel();
        temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
        JButton b1 = new JButton("tempbutton");
        JButton b2 = new JButton("tempbutton");
        JButton b3 = new JButton("tempbutton");
        JButton b4 = new JButton("tempbutton");
        temp.add(b1);
        temp.add(b2);
        temp.add(b3);
        temp.add(b4);
        this.add(temp, BorderLayout.WEST);

        //Setup Movie grid
        //JUST CALLING JSON BUILDMASTERLIST TEMPORARILY FOR NOW UNTIL WE ARE ABLE TO PASS IN WHAT MOVIE LIST WE'RE CURRENTLY WORKING ON
        Movie[] list;
        try
        {
            list = JsonInterface.buildmasterlist("src\\Model\\Movies.json");


            grid = new MovieGrid(list);
            JScrollPane jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            jp.getVerticalScrollBar().setUnitIncrement(20);

            this.add(jp, BorderLayout.CENTER);
            this.add(new SearchPanel(), BorderLayout.NORTH);
        } catch(Exception ex)
        {

        }


    }

}
