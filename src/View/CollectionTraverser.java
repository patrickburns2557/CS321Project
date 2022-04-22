package View;

import Model.Collection;
import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CollectionTraverser extends MovieTraverser {
    private boolean deleteMode = false;

    public CollectionTraverser(Collection collection)
    {
        super(collection, true);
    }

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
        }
        else {
            for(int i = 0; i < currentList.size(); i++)
            {
                final int final_i = i;
                grid.addPosterListener(event ->
                {
                    MainWindow view = MainWindow.getInstance();
                    view.ShowMovie(currentList.get(final_i), e -> view.ShowCollection(collection));
                }, i);
            }
        }

        System.out.println("Refreshed");
        jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp.getVerticalScrollBar().setUnitIncrement(20);

        this.add(jp, BorderLayout.CENTER);
        this.repaint();
        if (initialized)
            MainWindow.getInstance().setVisible(true);
        else
            initialized = true;
    }

    public void setDeleteMode(boolean deleteMode) {
        this.deleteMode = deleteMode;
    }
}
