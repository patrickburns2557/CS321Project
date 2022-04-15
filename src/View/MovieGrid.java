package View;

import Model.Collection;
import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Math.min;

public class MovieGrid extends JPanel
{
    public static final int MOVIE_WIDTH = 220;
    public static final int MOVIE_HEIGHT = 330;
    public ArrayList<JPanel> posterPanels;
    ArrayList<JButton> buttonList;
    ArrayList<Movie> movieList;


    public MovieGrid()
    {
        Model.System sys = Model.System.getInstance();
        movieList = sys.getMasterList();
        this.setLayout(new WrapLayout(FlowLayout.LEADING, 15, 15)); // Wrap Layout extends Flowlayout and just
        // properly wraps to the next line when runs out of horizontal space
        // Regular FlowLayout doesn't wrap to the next line when a JScrollPane is added to it


        //Create Buttons for each movie listed in the grid
        posterPanels = new ArrayList<JPanel>();
        buttonList = new ArrayList<JButton>();
        for(Movie movie : movieList)
        {
            CreateButton(movie);
        }
        //add each button to the MovieGrid JPanel
        for(int i = 0; i < movieList.size(); i++)
        {
            SelectMovie(i);
        }
    }

    public MovieGrid(Collection list, int viewableMovies)
    {
        movieList = list.getMovies();
        viewableMovies = min(viewableMovies, movieList.size());
        this.setLayout(new WrapLayout(FlowLayout.LEADING, 15, 15)); // Wrap Layout extends Flowlayout and just
        // properly wraps to the next line when runs out of horizontal space
        // Regular FlowLayout doesn't wrap to the next line when a JScrollPane is added to it


        //Create Buttons for each movie listed in the grid
        posterPanels = new ArrayList<JPanel>();
        buttonList = new ArrayList<JButton>();
        for(int i = 0; i < viewableMovies; i++)
        {
            CreateButton(movieList.get(i));
            System.out.println(movieList.get(i).getcountry());
        }
        //add each button to the MovieGrid JPanel
        for(int i = 0; i < viewableMovies; i++)
        {
            SelectMovie(i);
        }
    }

    public MovieGrid(Collection list) {
        this(list, list.getMovies().size());
    }

    private void SelectMovie(int i)
    {
        final int final_i = i;
        //resize the poster to fit on the button for it
        buttonList.get(i).setPreferredSize(new Dimension(MOVIE_WIDTH,MOVIE_HEIGHT));
        buttonList.get(i).addActionListener(new
                                                    ActionListener()
                                                    {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e)
                                                        {
                                                            MainWindow view = MainWindow.getInstance();
                                                            view.ShowMovie(movieList.get(final_i));
                                                        }
                                                    });
        this.add(buttonList.get(i));
    }


    private void CreateButton(Movie movie)
    {
        Image img = new ImageIcon(CreatePoster.getFromURL(movie.getposter(), movie.gettitle(), movie.getyear())).getImage();//create image from the poster link
        Image resizedImage = img.getScaledInstance(MOVIE_WIDTH, MOVIE_HEIGHT, Image.SCALE_SMOOTH); //resize the image to fit on teh button
        JPanel panel = new JPanel();
        JButton button = new JButton(new ImageIcon(resizedImage));
        panel.add(button);
        buttonList.add(button);
        posterPanels.add(panel);
    }
}

