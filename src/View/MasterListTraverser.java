package View;

import Model.Collection;
import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MasterListTraverser extends MovieTraverser{
    private CollectionTraverser collectionTraverser;

    public MasterListTraverser(CollectionTraverser collectionTraverser)
    {
        super(new Collection ("ml", Model.System.getInstance().getMasterList()), false);
        this.collectionTraverser = collectionTraverser;
        RefreshGrid();
        initialized = true;
    }

    public void RefreshGrid() {
        if (initialized)
            this.remove(jp);
        ArrayList<Movie> currentList = searchSortFilterPanel.getSortedFilteredMovies();
        grid = new MovieGrid(new Collection("List", currentList));

        //Create action listeners for the movie buttons that bring you to the corresponding MovieView
        for(int i = 0; i < currentList.size(); i++)
        {
            final int final_i = i;
            grid.addPosterListener(event ->
            {
                boolean addMovie = true;
                for (Movie movie : collectionTraverser.collection.getMovies()) {
                    if (movie == currentList.get(final_i)) {
                        addMovie = false;
                        System.out.println("already in collection");
                    }
                }
                if (addMovie) {
                    collectionTraverser.collection.addMovie(currentList.get(final_i));
                    collectionTraverser.searchSortFilterPanel.getSortedFilteredMovies().add(currentList.get(final_i));
                    collectionTraverser.RefreshGrid();
                }
            }, i);
        }

        jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp.getVerticalScrollBar().setUnitIncrement(20);

        this.add(jp, BorderLayout.CENTER);
        this.repaint();
        if (initialized)
            MainWindow.getInstance().setVisible(true);
        else
            initialized = true;
    }
}
