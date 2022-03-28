package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JFrame
{


    public MainView()
    {
        JPanel test = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        //Maximize window on creation
        //this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        ArrayList<String> tempMovieList = new ArrayList<String>();
        tempMovieList.add("movie 1");
        tempMovieList.add("movie 2");
        tempMovieList.add("movie 3");
        tempMovieList.add("movie 4");
        tempMovieList.add("movie 5");
        tempMovieList.add("movie 6");
        tempMovieList.add("movie 7");
        tempMovieList.add("movie 8");
        tempMovieList.add("movie 9");
        tempMovieList.add("movie 10");
        tempMovieList.add("movie 11");
        tempMovieList.add("movie 12");

        this.setLayout(new BorderLayout());
        this.add(new MovieGrid(tempMovieList), BorderLayout.CENTER);



    }
}
