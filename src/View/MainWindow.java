package View;

import Model.JsonInterface;
import Model.Movie;

import javax.swing.*;
import java.io.IOException;
import java.util.Collection;


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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        //Maximize window on creation
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);




        //Just change between the two things below for homeview and movieview by commenting out for now until transitioning between them is setup
        //HomeView home = new HomeView();
        //this.add(home);
        Movie[] list;
        try
        {
            list = JsonInterface.buildmasterlist("src\\Model\\Movies.json");
            /*MovieView movieView = new MovieView(list[78]);
            this.add(movieView);*/


            homeView = new HomeView();
            this.add(homeView);

            //this.add(test);
        } catch(IOException ex)
        {

        }
    }

    public static MainWindow getInstance()
    {
        return mainWindow;
    }

    public void ShowHome()
    {
        this.getContentPane().removeAll();
        homeView = new HomeView();
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
