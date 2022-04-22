package View;

import Model.Collection;
import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The collection view associated with editing the collection
 * Pairs with CollectionDetailView
 */
public class CollectionTraverser extends MovieTraverser {
    private boolean deleteMode;

    /**
     * Constructor for CollectionTraverser
     * @param collection
     */
    public CollectionTraverser(Collection collection, boolean deleteMode)
    {
        super(collection, false);
        this.deleteMode = deleteMode;
        RefreshGrid();
    }

    /**
     * Will either refresh grid with delete buttons or view buttons depending on deleteMode
     */
    public void RefreshGrid() {
        if (initialized)
            this.remove(jp);
        ArrayList<Movie> currentList = searchSortFilterPanel.getSortedFilteredMovies();
        grid = new MovieGrid(new Collection("List", currentList));

        //Create action listeners for the movie buttons that bring you to the corresponding MovieView
        if (deleteMode) {
            for (int i = 0; i < currentList.size(); i++) {
                final int final_i = i;
                grid.addPosterListener(event ->
                {
                    collection.removeMovie(currentList.get(final_i));
                    searchSortFilterPanel.getSortedFilteredMovies().remove(currentList.get(final_i));
                    RefreshGrid();
                }, i);
            }
            System.out.println("delete mode");
        }
        else {
            for(int i = 0; i < currentList.size(); i++)
            {
                final int final_i = i;
                grid.addPosterListener(event ->
                {
                    MainWindow view = MainWindow.getInstance();
                    view.ShowMovie(currentList.get(final_i), e -> view.ShowCollection(collection, false));
                }, i);
            }
            System.out.println("view mode");
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

    /**
     * Sets whether the buttons will be used to delete or view the movie
     * @param deleteMode
     */
    public void setDeleteMode(boolean deleteMode) {
        this.deleteMode = deleteMode;
    }
}
