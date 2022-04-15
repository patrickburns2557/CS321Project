package View;

import Model.Collection;
import Model.JsonInterface;
import Model.Movie;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;


public class MainWindow extends JFrame
{
    //private CollectionView test = new CollectionView();
    private static MainWindow mainWindow;
    private static HomeView homeView;
    private static MovieView movieView;

    static
    {
        mainWindow = new MainWindow();
    }
    private MainWindow()
    {
        Model.System sys = Model.System.getInstance();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        //Maximize window on creation
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);




        /*ArrayList<Movie> newList = sys.getMasterList();
        MovieView movieView = new MovieView(newList.get(78));
        this.add(movieView);*/

        homeView = new HomeView();
        this.add(homeView);

    }

    public static MainWindow getInstance()
    {
        return mainWindow;
    }

    public void ShowHome()
    {
        this.getContentPane().removeAll();
        //homeView = new HomeView();
        this.add(homeView);
        this.repaint();
        this.setVisible(true);
    }

    public void ShowMovie(Movie movie)
    {
        this.getContentPane().removeAll();
        movieView = new MovieView(movie);
        System.out.println(movie.gettitle() + " ENTERED");
        this.add(movieView);
        this.repaint();
        this.setVisible(true);
    }
}
