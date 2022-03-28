package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JFrame
{


    public MainView()
    {
        this.setLayout(new BorderLayout());
        JPanel test = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        //Maximize window on creation
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //TEMPORARY CREATION OF LIST OF MOVIE NAMES FOR NOW
        ArrayList<String> tempMovieList = new ArrayList<String>();
        for(int i = 0; i<100; i++)
        {
            tempMovieList.add("movie " + (i+1));
        }


        JScrollPane jp = new JScrollPane(new MovieGrid(tempMovieList), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jp.getVerticalScrollBar().setUnitIncrement(20);
        this.add(jp, BorderLayout.CENTER);


    }
}
