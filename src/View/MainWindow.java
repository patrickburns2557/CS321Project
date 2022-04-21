package View;

import Model.Collection;
import Model.JsonInterface;
import Model.Movie;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Class to generate a JFrame that will contain all views in the program
 * and will allow switching between said views
 * IS A STATIC SINGLETON CLASS
 */
public class MainWindow extends JFrame
{
    private static MainWindow mainWindow;
    private static HomeView homeView;
    private static MovieView movieView;
    private static CollectionView collectionView;
    private static CollectionDetailView collectionDetailView;

    //Create the singleton class's one instance
    static
    {
        mainWindow = new MainWindow();
    }

    /**
     * Private constructor to create the singleton class's one instance
     */
    private MainWindow()
    {
        Model.System sys = Model.System.getInstance();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Used because the program has custom behavior when closing

        //Add a window listener to detect when the user attempts to close the window
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent event)
            {
                closingProcedure();
            }
        });
        this.setSize(1500,900);
        //Maximize window on creation
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //Show homeView as the first view
        homeView = new HomeView();
        this.add(homeView);
    }

    /**
     * Get the singleton instance of MainWindow
     * @return - MainWindow's singleton instance
     */
    public static MainWindow getInstance()
    {
        return mainWindow;
    }

    /**
     * Returns the currently loaded homeView
     * @return - The currently loaded homeView
     */
    public HomeView getHomeView()
    {
        return homeView;
    }

    /**
     * Set the current view to be homeView
     */
    public void ShowHome()
    {
        this.getContentPane().removeAll();
        this.add(homeView);
        this.repaint();
        this.setVisible(true);
    }

    /**
     * Refresh the homeView to reflect a user logging in or logging out
     * and then show that view
     */
    public void ShowHomeOnLogin()
    {
        this.getContentPane().removeAll();
        homeView = new HomeView();
        this.add(homeView);
        this.repaint();
        this.setVisible(true);
    }

    /**
     * Show the movieView for the indicated movie
     * @param movie - Movie for which to create the movieView for
     */
    public void ShowMovie(Movie movie)
    {
        this.getContentPane().removeAll();
        movieView = new MovieView(movie);
        this.add(movieView);
        this.repaint();
        this.setVisible(true);
    }

    /**
     * Show the collectionView of the passed in collection list
     * @param collections - list of collections to display
     */
    public void ShowCollectionList(ArrayList<Model.Collection> collections)
    {
        this.getContentPane().removeAll();
        collectionView = new CollectionView(collections);
        this.add(collectionView);
        collectionView.refresh();
        this.repaint();
        this.setVisible(true);
    }

    /**
     * Show the detailed view of the indicated collection
     * @param collection - collection to show
     */
    public void ShowCollection(Collection collection)
    {
        this.getContentPane().removeAll();
        collectionDetailView = new CollectionDetailView(collection);
        this.add(collectionDetailView);
        this.repaint();
        this.setVisible(true);
    }

    /**
     * Function that is called when the program is closed
     * Will write any changes to the user files out to file
     * This includes any changes to user's collections, any ratings for the movies
     * or any new users created
     */
    public void closingProcedure()
    {
        JsonInterface.writeUser(Model.System.getInstance().getUserList());
        this.dispose();
        java.lang.System.exit(0);
    }
}

