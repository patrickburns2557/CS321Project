package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Model.Collection;
import Model.Movie;

public class CollectionPeekView extends JPanel implements ComponentListener {
    private Collection collection;
    private int componentCount = 0;
    private JPanel parent;
    private Border border;

    public void componentHidden(ComponentEvent e) {};
    public void componentShown(ComponentEvent e) {};
    public void componentMoved(ComponentEvent e) {};
    public void componentResized(ComponentEvent e) {
        // Everytime the panel is resized, the number of movies shown updates to fit the width of the panel
        int panelWidth = parent.getWidth();
        int horizontalPadding = 50;
        int viewableMovies = panelWidth / (MovieGrid.MOVIE_WIDTH + horizontalPadding);

        // Remove the old movie grid
        if (getComponentCount() > componentCount)
            this.remove(getComponentCount() - 1);
        // Correct the size by recreating the movie grid
        MovieGrid grid = new MovieGrid(collection, viewableMovies);
        Insets insets = border.getBorderInsets(this);
        grid.setLayout(new FlowLayout(FlowLayout.CENTER, horizontalPadding, 0));
        this.add(grid, BorderLayout.CENTER);
    }

    public CollectionPeekView(JPanel parent, Collection collection) {
        this.parent = parent;
        this.collection = collection;
        border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), collection.getName());
        this.setBorder(border);
        this.addComponentListener(this);
        this.setLayout(new BorderLayout());

        JButton viewMore = new JButton("View More");

        JPanel topBar = new JPanel();
        topBar.setLayout(new BorderLayout());
        topBar.add(viewMore, BorderLayout.EAST);

        this.add(topBar, BorderLayout.NORTH);

        componentCount = getComponentCount();
    }
}
