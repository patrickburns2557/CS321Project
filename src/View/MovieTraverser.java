package View;

import Model.Collection;
import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieTraverser extends JPanel implements ActionListener {
    private MovieGrid grid;
    private JScrollPane jp;
    private SearchSortFilterPanel searchSortFilterPanel;
    private JPanel topBar;
    private boolean initialized = false;

    /**
     * Default constructor for HomeView
     * Creates grid of movies based on full database
     */
    public MovieTraverser(ArrayList<Movie> movies)
    {
        this.setLayout(new BorderLayout());

        topBar = new JPanel();
        topBar.setLayout(new BorderLayout());

        //Setup Search panel
        searchSortFilterPanel = new SearchSortFilterPanel(movies, this);
        topBar.add(searchSortFilterPanel, BorderLayout.CENTER);

        RefreshGrid();
        initialized = true;

        this.add(topBar, BorderLayout.NORTH);
    }

    /**
     * Refreshes the currently shown movie grid to reflect any changes made to it
     */
    public void RefreshGrid()
    {
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
                MainWindow view = MainWindow.getInstance();
                view.ShowMovie(currentList.get(final_i), e -> view.ShowHome());
            }, i);
        }

        jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp.getVerticalScrollBar().setUnitIncrement(20);

        this.add(jp, BorderLayout.CENTER);
        this.repaint();
        if (initialized)
            MainWindow.getInstance().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RefreshGrid();
    }
}
