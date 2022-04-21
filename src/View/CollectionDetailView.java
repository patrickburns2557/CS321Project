package View;

import Model.Collection;

import javax.swing.*;
import java.awt.*;

public class CollectionDetailView extends JPanel {
    //private Collection collection;
    private JPanel collectionPanel;

    /**
     * The view that displays what's in a collection and gives the user a way to edit it
     * @param collection
     */
    public CollectionDetailView(Collection collection) {
        //collectionPanel = new JPanel();
        //collectionPanel.setLayout()
        MovieGrid grid = new MovieGrid(collection);

        for(int i = 0; i < collection.getMovies().size(); i++)
        {
            final int final_i = i;
            grid.addPosterListener(event ->
            {
                MainWindow view = MainWindow.getInstance();
                view.ShowMovie(collection.getMovies().get(final_i), e -> view.ShowCollection(collection));
            }, i);
        }

        this.add(grid, BorderLayout.CENTER);
    }
}
