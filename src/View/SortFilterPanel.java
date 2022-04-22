package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.System;
import java.util.ArrayList;
import java.util.Collections;

public class SortFilterPanel extends JPanel
{
    protected ArrayList<Movie> originalCollection;
    protected ArrayList<Movie> cloneCollection;

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

    public SortFilterPanel(ArrayList<Movie> movies, ActionListener actionListener) {
        originalCollection = movies;
        ResetMovies();

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


        sortNameButton.addActionListener(actionListener);
        sortDateButton.addActionListener(actionListener);
        sortIMDBButton.addActionListener(actionListener);
        sortRuntimeButton.addActionListener(actionListener);
        filterButton.addActionListener(actionListener);
        clearFiltersButton.addActionListener(actionListener);
        CreateSortListeners();
        CreateFilterListeners();


    }

    public ArrayList<Movie> getSortedFilteredMovies() {
        return cloneCollection;
    }

    /**
     * Resets the view to show all movies in the database again
     */
    public void ResetMovies()
    {
        cloneCollection = (ArrayList)originalCollection.clone();
        SortMoviesTitle();
    }

    /**
     * Sorts movies by title using MovieComparatorByName()
     */
    protected void SortMoviesTitle()
    {
        Collections.sort(cloneCollection, new MovieComparatorByName());
    }

    /**
     * Sorts movies by critic rating using MovieComparatorByCriticRating()
     */
    private void SortMoviesCritic()
    {
        Collections.sort(cloneCollection, new MovieComparatorByCriticRating());
    }

    /**
     * Sorts movies by release year by using MovieComparatorByDate()
     */
    private void SortMoviesDate()
    {
        Collections.sort(cloneCollection, new MovieComparatorByDate());
    }

    /**
     * Sorts movies by runtime by using MovieComparatorByRuntime()
     */
    private void SortMoviesRuntime()
    {
        Collections.sort(cloneCollection, new MovieComparatorByRuntime());
    }

    private void CreateSortListeners()
    {
        sortNameButton.addActionListener(event ->
        {
            SortMoviesTitle();
        });

        sortDateButton.addActionListener(event ->
        {
            SortMoviesDate();
        });

        sortIMDBButton.addActionListener(event ->
        {
            SortMoviesCritic();
        });

        sortRuntimeButton.addActionListener(event ->
        {
            SortMoviesRuntime();
        });
    }

    /**
     * Filters movies by genre
     * @param genre - passed in genre to filter by
     */
    private void FilterMoviesGenre(String genre)
    {
        //Indicates no genre was selected in the filter panel
        if(genre.equals("Genre"))
            return;

        ArrayList<String> genrePass = new ArrayList<String>();
        genrePass.add(genre);
        FilterMovies.filterByGenre(cloneCollection,genrePass);
    }

    /**
     * Filters movies by language
     * @param language - passed in language to filter by
     */
    private void FilterMoviesLanguage(String language)
    {
        //Indicates no language was selected in the filter panel
        if(language.equals("Language"))
            return;

        ArrayList<String> languagePass = new ArrayList<String>();
        languagePass.add(language);
        FilterMovies.filterByLanguage(cloneCollection, languagePass);
    }

    /**
     * Filters movies by country
     * @param country - passed in country to filter by
     */
    private void FilterMoviesCountry(String country)
    {
        //Indicates no country was selected in the filter panel
        if(country.equals("Country"))
            return;

        ArrayList<String> countryPass = new ArrayList<String>();
        countryPass.add(country);
        FilterMovies.filterByCountry(cloneCollection, countryPass);
    }

    /**
     * Filter movies by release year (will be grouped into decades)
     * @param year - passed in decade to filter by
     */
    private void FilterMoviesYear(String year)
    {
        //Indicates no year was selected in the filter panel
        if(year.equals("Years"))
            return;

        ArrayList<Integer> years = new ArrayList<Integer>();
        int begin = 0, end = 9;
        //Generate a range of years to pass into the filter method based on the selected decade
        switch(year)
        {
            case "1920s": begin = 1920; end = 1929; break;
            case "1950s": begin = 1950; end = 1959; break;
            case "1960s": begin = 1960; end = 1969; break;
            case "1970s": begin = 1970; end = 1979; break;
            case "1980s": begin = 1980; end = 1989; break;
            case "1990s": begin = 1990; end = 1999; break;
            case "2000s": begin = 2000; end = 2009; break;
            case "2010s": begin = 2010; end = 2019; break;
            case "2020s": begin = 2020; end = 2029; break;
        }
        /*for(int i = begin;i<=end;i++)
            years.add(i);*/

        years.add(begin);
        years.add(end);

        FilterMovies.filterByYear(cloneCollection, years);
    }

    /**
     * Filter movies by age rating
     * @param age - passed in age rating to filter by
     */
    private void FilterMoviesAge(String age)
    {
        //Indicates no age rating was selected in the filter panel
        if(age.equals("Age Rating"))
            return;

        FilterMovies.filterByAgeRating(cloneCollection, age);
    }

    private void CreateFilterListeners()
    {
        filterButton.addActionListener(event ->
        {
            ResetMovies();
            FilterMoviesGenre((String) filterGenreCombo.getSelectedItem());
            FilterMoviesLanguage((String) filterLanguageCombo.getSelectedItem());
            FilterMoviesCountry((String) filterCountryCombo.getSelectedItem());
            FilterMoviesYear((String) filterYearCombo.getSelectedItem());
            FilterMoviesAge((String) filterAgeCombo.getSelectedItem());
        });

        clearFiltersButton.addActionListener(event ->
        {
            filterGenreCombo.setSelectedIndex(0);
            filterLanguageCombo.setSelectedIndex(0);
            filterCountryCombo.setSelectedIndex(0);
            filterYearCombo.setSelectedIndex(0);
            filterAgeCombo.setSelectedIndex(0);
            ResetMovies();
        });
    }
}
