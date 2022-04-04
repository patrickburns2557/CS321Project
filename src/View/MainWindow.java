package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame
{


    public MainWindow()
    {
        JPanel test = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        //Maximize window on creation
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);


        //JScrollPane jp = new JScrollPane(new MovieGrid(tempMovieList), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //jp.getVerticalScrollBar().setUnitIncrement(20);

        //HomeView home = new HomeView();
        MovieView movie = new MovieView("Movie1");
        this.add(movie);

    }
}
