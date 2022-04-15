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
    private static CollectionView collectionView;
    private static CollectionDetailView collectionDetailView;

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




        ArrayList<Movie> newList = sys.getMasterList();
        //MovieView movieView = new MovieView(newList.get(78));
        //this.add(movieView);

        //homeView = new HomeView();
        //this.add(homeView);
        ArrayList<Collection> tempCollections = new ArrayList<>();
        Collection collectionA = new Collection("Collection A", new ArrayList<>(newList.subList(0, 3)));
        Collection collectionB = new Collection("Collection B", new ArrayList<>(newList.subList(9, 20)));
        Collection collectionC = new Collection("Collection B", new ArrayList<>(newList.subList(21, 26)));
        tempCollections.add(collectionA);
        tempCollections.add(collectionB);
        tempCollections.add(collectionC);
        collectionView = new CollectionView(tempCollections);
        this.add(collectionView);
        collectionView.refresh();
    }

    public static MainWindow getInstance()
    {
        return mainWindow;
    }

    public static HomeView getHomeView()
    {
        return homeView;
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
        this.add(movieView);
        this.repaint();
        this.setVisible(true);
    }

    public void ShowTemp()
    {
        this.getContentPane().removeAll();
        Collection temp = new Collection("master", Model.System.getInstance().getMasterList());
        this.add(new MovieGridCollection(temp));
    }

    public void ShowCollection(Collection collection)
    {
        this.getContentPane().removeAll();
        collectionDetailView = new CollectionDetailView(collection);
        this.add(collectionDetailView);
        this.repaint();
        this.setVisible(true);
    }
}

