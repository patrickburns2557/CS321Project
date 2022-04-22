package View;

import javax.swing.*;
import java.awt.*;

/**
 * Class to create a panel to sort and filter the movies currently shown on the screen
 * Allows the user to use both sorting and filtering simultaneously for the current movies.
 */
public class SortFilterPanel extends JPanel
{
    private JPanel sortPanel;
    private JButton sortNameButton;
    private JButton sortDateButton;
    private JButton sortIMDBButton;
    private JButton sortRuntimeButton;

    private JPanel filterPanel;
    private JComboBox filterGenreCombo;
    private JComboBox filterLanguageCombo;
    private JComboBox filterCountryCombo;
    private JComboBox filterYearCombo;
    private JComboBox filterAgeCombo;
    private JButton filterButton;
    private JButton clearFiltersButton;
    private JButton fillerButton;

    /**
     * Constructor to create the SortFilterPanel
     */
    public SortFilterPanel()
    {

        //this.setLayout(new GridLayout(2,1));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        sortPanel = new JPanel();
        sortPanel.setLayout(new GridLayout(4, 1));

        sortNameButton = new JButton("Alphabetical");
        sortDateButton = new JButton("Release Date");
        sortIMDBButton = new JButton("IMDb Score");
        sortRuntimeButton = new JButton("Runtime");

        sortPanel.add(sortNameButton);
        sortPanel.add(sortDateButton);
        sortPanel.add(sortIMDBButton);
        sortPanel.add(sortRuntimeButton);

        sortPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sort by:"));
        this.add(sortPanel);


        filterPanel = new JPanel();
        filterPanel.setLayout(new GridLayout(5, 1));

        String[] genres = {"Genre", "Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary", "Drama", "Family", "Fantasy", "History", " Horror", "Musical", "Mystery", "Romance", "Sci-Fi", "Short", "Sport", "Thriller"};
        String[] languages = {"Language", "Arabic", "Cantonese", "Czech", "Dutch", "English", "Finnish", "French", "German", "Hindi", "Hungarian", "Italian", "Japanese", "Korean", "Macedonian", "Mandarin", "Norwegian", "Persian", "Portuguese", "Romanian", "Russian", "Sanskrit", "Serbian", "Somali", "Spanish", "Vietnamese", "Yiddish"};
        String[] countries = {"Country", "Argentina", "Australia", "Belgium", "Canada", "China", "Czech Republic", "Czechoslovakia", "France", "Germany", "Hong Kong", "Ireland", "Italy", "Japan", "Malta", "Mexico", "Spain", "Taiwan", "South Korea", "Switzerland", "United Kingdom", "United States"};
        String[] years = {"Years", "1920s", "1950s", "1960s", "1970s", "1980s", "1990s", "2000s", "2010s", "2020s"};
        String[] ageRatings = {"Age Rating", "G", "TV-G", "PG", "PG-13", "R", "TV-MA", "X", "Not Rated"};


        filterGenreCombo = new JComboBox(genres);
        filterLanguageCombo = new JComboBox(languages);
        filterCountryCombo = new JComboBox(countries);
        filterYearCombo = new JComboBox(years);
        filterAgeCombo = new JComboBox(ageRatings);
        fillerButton = new JButton();
        fillerButton.setVisible(false);
        filterButton = new JButton("Apply Filters");
        clearFiltersButton = new JButton("Clear Filters");

        filterPanel.add(filterGenreCombo);
        filterPanel.add(filterLanguageCombo);
        filterPanel.add(filterCountryCombo);
        filterPanel.add(filterYearCombo);
        filterPanel.add(filterAgeCombo);
        filterPanel.add(fillerButton);
        filterPanel.add(filterButton);
        filterPanel.add(clearFiltersButton);

        filterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Filter by:"));
        this.add(filterPanel);


        this.add(Box.createRigidArea(new Dimension(1,10000)));//fill up bottom of panel
        CreateSortListeners();
        CreateFilterListeners();
    }

    /**
     * Method for creating the ActionListeners for the sorting buttons
     */
    private void CreateSortListeners()
    {
        sortNameButton.addActionListener(event ->
        {
            MainWindow.getInstance().getHomeView().SortMoviesTitle();
        });

        sortDateButton.addActionListener(event ->
        {
            MainWindow.getInstance().getHomeView().SortMoviesDate();
        });

        sortIMDBButton.addActionListener(event ->
        {
            MainWindow.getInstance().getHomeView().SortMoviesCritic();
        });

        sortRuntimeButton.addActionListener(event ->
        {
            MainWindow.getInstance().getHomeView().SortMoviesRuntime();
        });
    }

    /**
     * Method for creating the ActionListeners for the filtering dropdown menus and buttons
     */
    private void CreateFilterListeners()
    {
        filterButton.addActionListener(event ->
        {
            MainWindow.getInstance().getHomeView().ResetMovies();
            MainWindow.getInstance().getHomeView().FilterMoviesGenre((String) filterGenreCombo.getSelectedItem());
            MainWindow.getInstance().getHomeView().FilterMoviesLanguage((String) filterLanguageCombo.getSelectedItem());
            MainWindow.getInstance().getHomeView().FilterMoviesCountry((String) filterCountryCombo.getSelectedItem());
            MainWindow.getInstance().getHomeView().FilterMoviesYear((String) filterYearCombo.getSelectedItem());
            MainWindow.getInstance().getHomeView().FilterMoviesAge((String) filterAgeCombo.getSelectedItem());
        });

        clearFiltersButton.addActionListener(event ->
        {
            filterGenreCombo.setSelectedIndex(0);
            filterLanguageCombo.setSelectedIndex(0);
            filterCountryCombo.setSelectedIndex(0);
            filterYearCombo.setSelectedIndex(0);
            filterAgeCombo.setSelectedIndex(0);
            MainWindow.getInstance().getHomeView().ResetMovies();
        });
    }
}
