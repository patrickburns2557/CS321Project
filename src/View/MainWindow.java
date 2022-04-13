package View;

import javax.swing.*;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

import Model.Collection;
import Model.JsonInterface;
import Model.Movie;

public class MainWindow extends JFrame
{
    public MainWindow()
    {
        JsonInterface jsonInterface = new JsonInterface();
        Movie[] masterList = new Movie[0];
        try {
            masterList = jsonInterface.buildmasterlist("SampleMovieFile.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        //Maximize window on creation
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //Just change between the two things below for homeview and movieview by commenting out for now until transitioning between them is setup
        //HomeView home = new HomeView(this);
        //this.add(home);

        //MovieView Movie = new MovieView("Toy Story 4");
        //this.add(Movie);

        ArrayList<Collection> userCollections = new ArrayList<>();
        Collection c1 = new Collection("My Collection");
        c1.addMovie(masterList[0]);
        userCollections.add(c1);
        CollectionView collectionView = new CollectionView(userCollections);
        this.add(collectionView);
        collectionView.refresh();
    }
}
