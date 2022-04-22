package View;

import Model.Collection;
import Model.FilterMovies;
import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Search, sort, filter panel combo
 */
public class SearchSortFilterPanel extends JPanel {
    private JTextField searchBar;
    private JButton sortFilterPopupButton;
    private SortFilterPanel sortFilterPanel;
    private PopupFactory popupFactory;
    private Popup sortFilterPopup;
    private boolean showingPopup = false;

    /**
     * Constructor to create the SearchSortFilterPanel
     * @param movies list of movies to be sorted
     * @param actionListener used to refresh the grid
     */
    public SearchSortFilterPanel(ArrayList<Movie> movies, ActionListener actionListener)
    {
        this.setLayout(new BorderLayout(7, 7));

        //Setup search bar
        Font searchFont = new Font(Font.SANS_SERIF, Font.BOLD, 35);
        searchBar = new JTextField();
        searchBar.setText("Search...");
        searchBar.setFont(searchFont);

        this.add(searchBar, BorderLayout.CENTER);

        sortFilterPopupButton = new JButton("Sort/Filter");
        popupFactory = new PopupFactory();
        sortFilterPanel = new SortFilterPanel(movies, actionListener);
        sortFilterPopupButton.addActionListener(e -> {
            if (showingPopup) {
                sortFilterPopup.hide();
                showingPopup = false;
            }
            else {
                sortFilterPopup = popupFactory.getPopup(
                        MainWindow.getInstance(),
                        sortFilterPanel,
                        sortFilterPopupButton.getLocationOnScreen().x - 170,
                        sortFilterPopupButton.getLocationOnScreen().y + 64);
                sortFilterPopup.show();
                showingPopup = true;
            }
        });

        //Add action listener to make the searchbar functional
        searchBar.addActionListener(actionListener);
        searchBar.addActionListener(event ->
        {
            if (searchBar.getText().isEmpty())
                sortFilterPanel.ResetMovies();
            else
                FilterMovies.filterByTitle(sortFilterPanel.getSortedFilteredMovies(), searchBar.getText());
        });

        this.add(sortFilterPopupButton, BorderLayout.EAST);
    }

    /**
     * Retrieves sorted movies as a list
     * @return
     */
    public ArrayList<Movie> getSortedFilteredMovies() {
        return sortFilterPanel.getSortedFilteredMovies();
    }
}
