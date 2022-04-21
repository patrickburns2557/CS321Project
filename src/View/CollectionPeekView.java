package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Model.Collection;
import Model.Movie;

import static java.lang.Math.min;

/**
 * The view associated with CollectionView that "peeks" at the collection
 */
public class CollectionPeekView extends JPanel implements ComponentListener {
    private Collection collection;
    private int componentCount = 0;
    private JPanel parent;
    private Border border;

    /**
     * No functionality
     * @param e
     */
    public void componentHidden(ComponentEvent e) {};
    /**
     * No functionality
     * @param e
     */
    public void componentShown(ComponentEvent e) {};
    /**
     * No functionality
     * @param e
     */
    public void componentMoved(ComponentEvent e) {};
    /**
     * Readjusts the amount of movies shown when the window is resized
     * @param e
     */
    public void componentResized(ComponentEvent e) {
        refresh();
    }

    public void refresh() {
        // Everytime the panel is resized, the number of movies shown updates to fit the width of the panel
        int panelWidth = parent.getWidth();
        int horizontalPadding = 50;
        int viewableMovies = panelWidth / (MovieGrid.MOVIE_WIDTH + horizontalPadding);

        // Remove the old movie grid
        if (getComponentCount() > componentCount)
            this.remove(getComponentCount() - 1);
        // Correct the size by recreating the movie grid
        MovieGrid grid = new MovieGrid(collection, viewableMovies);
        grid.setLayout(new FlowLayout(FlowLayout.LEFT, horizontalPadding, 0));

        for(int i = 0; i < min(viewableMovies, collection.getMovies().size()); i++)
        {
            final int final_i = i;
            grid.addPosterListener(event ->
            {
                MainWindow view = MainWindow.getInstance();
                view.ShowMovie(collection.getMovies().get(final_i), event1 -> view.ShowCollectionList());
            }, i);
        }

        this.add(grid, BorderLayout.CENTER);
    }

    public void refreshBorder() {
        border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), collection.getName());
        this.setBorder(border);
    }

    /**
     * @param parent required to adjust viewable movies
     * @param collection the collection to show
     */
    public CollectionPeekView(JPanel parent, Collection collection) {
        this.parent = parent;
        this.collection = collection;
        border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), collection.getName());
        this.setBorder(border);
        this.addComponentListener(this);
        this.setLayout(new BorderLayout());

        JButton viewMore = new JButton("View More");
        viewMore.addActionListener(e -> {
            MainWindow mainWindow = MainWindow.getInstance();
            mainWindow.ShowCollection(collection);
        });

        JPanel topBar = new JPanel();
        topBar.setLayout(new BorderLayout());
        topBar.add(viewMore, BorderLayout.EAST);

        this.add(topBar, BorderLayout.NORTH);

        componentCount = getComponentCount();
    }
}
