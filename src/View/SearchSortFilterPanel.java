package View;

import Model.Collection;
import Model.FilterMovies;
import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchSortFilterPanel extends JPanel {
    JTextField searchBar;
    JButton sortFilterPopupButton;
    SortFilterPanel sortFilterPanel;
    PopupFactory popupFactory;
    Popup sortFilterPopup;

    /**
     * Constructor to create the SearchSortFilterPanel
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
        sortFilterPopup = popupFactory.getPopup(MainWindow.getInstance(), sortFilterPanel, 180, 100);
        sortFilterPopupButton.addActionListener(e -> {
            sortFilterPopup.show();
        });

        //Add action listner to make the searchbar functional
        searchBar.addActionListener(event ->
        {
            FilterMovies.filterByTitle(movies, searchBar.getText());
        });
        searchBar.addActionListener(actionListener);

        this.add(sortFilterPopupButton, BorderLayout.EAST);
    }

    public ArrayList<Movie> getSortedFilteredMovies() {
        return sortFilterPanel.getSortedFilteredMovies();
    }

}
