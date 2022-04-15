package View;

import javax.swing.*;
import java.awt.*;

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
        String[] years = {};
        String[] ageRatings = {};


        filterGenreCombo = new JComboBox(genres);
        filterLanguageCombo = new JComboBox(languages);
        filterCountryCombo = new JComboBox(countries);
        filterYearCombo = new JComboBox();
        filterAgeCombo = new JComboBox();
        filterButton = new JButton("Use Filters");
        clearFiltersButton = new JButton("Clear Filters");


        filterPanel.add(filterGenreCombo);
        filterPanel.add(filterLanguageCombo);
        filterPanel.add(filterCountryCombo);
        filterPanel.add(filterYearCombo);
        filterPanel.add(filterAgeCombo);
        filterPanel.add(filterButton);
        filterPanel.add(clearFiltersButton);

        filterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Filters:"));
        this.add(filterPanel);


        this.add(Box.createRigidArea(new Dimension(1,10000)));//fill up bottom of panel
        CreateSortListeners();
    }

    private void CreateSortListeners()
    {
        sortNameButton.addActionListener(event ->
        {
            MainWindow.getInstance().getHomeView().SortMoviesTitle();
            System.out.println("SORT");
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
}
