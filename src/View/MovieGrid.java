package View;

import Model.Collection;
import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Math.min;

/**
 * Class to create a JPanel that shows a grid of movie posters based on the passed in collection
 * Can be used anywhere that a grid of movies needs to be shown
 */
public class MovieGrid extends JPanel
{
    public static final int MOVIE_WIDTH = 220;
    public static final int MOVIE_HEIGHT = 330;
    ArrayList<JButton> buttonList; //ArrayList to hold buttons that display the posters
    ArrayList<Movie> movieList; //ArrayList to hold the list of movies to show

    /**
     * Default constructor for MovieGrid
     * Creates a movie grid using the movie master list
     */
    public MovieGrid()
    {
        Model.System sys = Model.System.getInstance();
        movieList = sys.getMasterList();
        this.setLayout(new WrapLayout(FlowLayout.LEADING, 15, 15)); // Wrap Layout extends Flowlayout and just
        // properly wraps to the next line when runs out of horizontal space
        // Regular FlowLayout doesn't wrap to the next line when a JScrollPane is added to it


        //Create Buttons for each movie listed in the grid
        buttonList = new ArrayList<JButton>();
        for(Movie movie : movieList)
        {
            CreateButton(movie);
        }
        //add each button to the MovieGrid JPanel
        for(int i = 0; i < movieList.size(); i++)
        {
            AddToGrid(i);
        }
    }

    /**
     * Constructor that creates a MovieGrid based on the passed in collection, and restricted to a certain length
     * @param list - Collection passed in for MovieGrid to display
     * @param viewableMovies - number to limit the number of movies to display
     */
    public MovieGrid(Collection list, int viewableMovies)
    {
        movieList = list.getMovies();
        viewableMovies = min(viewableMovies, movieList.size());
        this.setLayout(new WrapLayout(FlowLayout.LEADING, 15, 15)); // Wrap Layout extends Flowlayout and just
        // properly wraps to the next line when runs out of horizontal space
        // Regular FlowLayout doesn't wrap to the next line when a JScrollPane is added to it


        //Create Buttons to display each movie listed in the grid
        buttonList = new ArrayList<JButton>();
        for(int i = 0; i < viewableMovies; i++)
        {
            CreateButton(movieList.get(i));
        }
        //add each button to the MovieGrid JPanel
        for(int i = 0; i < viewableMovies; i++)
        {
            AddToGrid(i);
        }
    }

    /**
     * Constructor used when no limit is needed on how many posters to show
     * Just calls the previous constructor, and passes the size of collection in as the number of posters to display
     * @param list - Collecion passed in for MovieGrid to display
     */
    public MovieGrid(Collection list)
    {
        this(list, list.getMovies().size());
    }

    /**
     * Adds the corresponding movie poster in buttonList to the view
     * @param i - index of movie to add
     */
    private void AddToGrid(int i)
    {
        //resize the poster to fit on the button for it
        buttonList.get(i).setPreferredSize(new Dimension(MOVIE_WIDTH,MOVIE_HEIGHT));
        this.add(buttonList.get(i));
    }

    /**
     * Used to add ActionListeners to the movie posters
     * Calling class will ideally iterate through it's list of movies to do this,
     * passing in the iterator variable to this method while doing so
     * @param listener - ActionListener to be added to the button
     * @param i - variable to indicate which poster in the buttonList to add the listener to
     */
    public void addPosterListener(ActionListener listener, int i)
    {
        buttonList.get(i).addActionListener(listener);
    }

    /**
     * Creates the button with movie poster to be added to the grid
     * and resizes the poster to fit on the indicated button size
     * @param movie - passed in movie to create poster button for
     */
    private void CreateButton(Movie movie)
    {
        Image img = new ImageIcon(CreatePoster.getFromURL(movie.getposter(), movie.gettitle(), movie.getyear())).getImage();//create image from the poster link
        Image resizedImage = img.getScaledInstance(MOVIE_WIDTH, MOVIE_HEIGHT, Image.SCALE_SMOOTH); //resize the image to fit on teh button
        JPanel panel = new JPanel();
        JButton button = new JButton(new ImageIcon(resizedImage));
        panel.add(button);
        buttonList.add(button);
    }
}

