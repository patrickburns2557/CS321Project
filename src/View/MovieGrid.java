package View;

import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieGrid extends JPanel
{
    public static final int MOVIE_WIDTH = 220;
    public static final int MOVIE_HEIGHT = 330;

    public MovieGrid(ArrayList<Movie> movieList) //REPLACE WITH MOVIELIST LATER
    {
        this.setLayout(new WrapLayout(FlowLayout.CENTER, 15, 15)); // Wrap Layout extends Flowlayout and just
        // properly wraps to the next line when runs out of horizontal space
        // Regular FlowLayout doesn't wrap to the next line when a JScrollPane is added to it

        ArrayList<JButton> buttonList = new ArrayList<JButton>();
        for(Movie movie : movieList)
        {
            buttonList.add(new JButton(movie.gettitle()));
        }
        for(JButton button : buttonList)
        {
            button.setPreferredSize(new Dimension(MOVIE_WIDTH,MOVIE_HEIGHT));
            this.add(button);
        }
    }

    public MovieGrid(ArrayList<Movie> movieList, int moviesToShow) {
        this.setLayout(new WrapLayout(FlowLayout.CENTER, 15, 15));

        ArrayList<JButton> buttonList = new ArrayList<JButton>();
        if (moviesToShow > movieList.size())
            moviesToShow = movieList.size();
        for(int i = 0; i < moviesToShow; i++)
        {
            buttonList.add(new JButton(movieList.get(i).gettitle()));
        }
        for(JButton button : buttonList)
        {
            button.setPreferredSize(new Dimension(MOVIE_WIDTH,MOVIE_HEIGHT));
            this.add(button);
        }
    }
}
