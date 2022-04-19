package View;

import Model.Collection;
import Model.JsonInterface;
import Model.Movie;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.lang.reflect.Array;
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
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent event)
            {
                MainWindow.getInstance().closingProcedure();
            }
        });
        this.setSize(1500,900);
        //Maximize window on creation
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);




        ArrayList<Movie> newList = sys.getMasterList();
        //MovieView movieView = new MovieView(newList.get(78));
        //this.add(movieView);

        homeView = new HomeView();
        this.add(homeView);

        /*ArrayList<Collection> tempCollections = new ArrayList<>();
        Collection collectionA = new Collection("Collection A", new ArrayList<>(newList.subList(0, 3)));
        Collection collectionB = new Collection("Collection B", new ArrayList<>(newList.subList(9, 20)));
        Collection collectionC = new Collection("Collection C", new ArrayList<>(newList.subList(21, 26)));
        tempCollections.add(collectionA);
        tempCollections.add(collectionB);
        tempCollections.add(collectionC);
        collectionView = new CollectionView(tempCollections);
        //this.add(collectionView);
        collectionView.refresh();
        this.add(collectionView);
        collectionView.refresh();*/
    }

    public static MainWindow getInstance()
    {
        return mainWindow;
    }

    public HomeView getHomeView()
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

    public void ShowHomeOnLogin()
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
        this.add(movieView);
        this.repaint();
        this.setVisible(true);
    }

    public void ShowCollectionList(ArrayList<Model.Collection> collections)
    {
        this.getContentPane().removeAll();
        collectionView = new CollectionView(collections);
        this.add(collectionView);
        collectionView.refresh();
        this.repaint();
        this.setVisible(true);
    }

    public void ShowCollection(Collection collection)
    {
        this.getContentPane().removeAll();
        collectionDetailView = new CollectionDetailView(collection);
        this.add(collectionDetailView);
        this.repaint();
        this.setVisible(true);
    }

    public void closingProcedure()
    {
        JsonInterface.writeUser(Model.System.getInstance().getUserList());
        this.dispose();
        java.lang.System.exit(0);
    }
}

