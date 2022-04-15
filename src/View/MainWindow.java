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




        //Just change between the two things below for homeview and movieview by commenting out for now until transitioning between them is setup
        //HomeView home = new HomeView();
        //this.add(home);


        MovieView Movie = new MovieView("Toy Story 4");
        this.add(Movie);

        this.add(test);
    }
}
