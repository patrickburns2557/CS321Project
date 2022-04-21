package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to create a JPanel for the HomeView that the user is able to search and sort/filter through all the movies in the database
 */
public class HomeView extends JPanel
{
    private MovieGrid grid;
    private Collection currentList;
    private JScrollPane jp;
    private SearchPanel searchPanel;
    private SortFilterPanel sortFilterPanel;

    /**
     * Default constructor for HomeView
     * Creates grid of movies based on full database
     */
    public HomeView()
    {
        Model.System sys = Model.System.getInstance();
        this.setLayout(new BorderLayout());

        //If user logged in, show button to get to collection view
        if(sys.getCurrentUser() != null)
        {
            JPanel collectionButtonPanel = new JPanel();
            collectionButtonPanel.setLayout(new BoxLayout(collectionButtonPanel, BoxLayout.Y_AXIS));
            JButton colButton = new JButton("View Collections");
            collectionButtonPanel.add(colButton);
            this.add(collectionButtonPanel, BorderLayout.WEST);
            colButton.addActionListener(event ->
            {
                MainWindow.getInstance().ShowCollectionList();
            });
        }

        //Setup Movie grid
        currentList = new Collection("master", sys.getMasterList());
        Collections.sort(currentList.getMovies(), new MovieComparatorByName());
        grid = new MovieGrid(currentList);

        //Create action listeners for the movie buttons that bring you to the corresponding MovieView
        for(int i = 0; i < currentList.getMovies().size(); i++)
        {
            final int final_i = i;
            grid.addPosterListener(event ->
            {
                MainWindow view = MainWindow.getInstance();
                view.ShowMovie(currentList.getMovies().get(final_i), e -> view.ShowHome());
            }, i);
        }

        jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp.getVerticalScrollBar().setUnitIncrement(20);
        this.add(jp,BorderLayout.CENTER);

        //Setup Search panel
        searchPanel = new SearchPanel();
        this.add(searchPanel, BorderLayout.NORTH);

        //Setup Sort/Filter panel
        sortFilterPanel = new SortFilterPanel();
        this.add(sortFilterPanel, BorderLayout.EAST);


        //Add action listner to make the searchbar functional
        searchPanel.searchBar.addActionListener(event ->
        {
            SearchMovies();
        });
    }

    /**
     * Resets the view to show all movies in the database again
     */
    public void ResetMovies()
    {
        Model.System sys = Model.System.getInstance();
        currentList = new Collection("master", sys.getMasterList());
        SortMoviesTitle();
    }

    /**
     * Searches the database for movies based on what's typed into the searchbar
     */
    public void SearchMovies()
    {
        Model.System sys = Model.System.getInstance();
        currentList = new Collection("master", sys.getMasterList());
        FilterMovies.filterByTitle(currentList.getMovies(), searchPanel.getEntry());
        RefreshGrid();
    }

    /**
     * Sorts movies by title using MovieComparatorByName()
     */
    public void SortMoviesTitle()
    {
        Collections.sort(currentList.getMovies(), new MovieComparatorByName());
        RefreshGrid();
    }

    /**
     * Sorts movies by critic rating using MovieComparatorByCriticRating()
     */
    public void SortMoviesCritic()
    {
        Collections.sort(currentList.getMovies(), new MovieComparatorByCriticRating());
        RefreshGrid();
    }

    /**
     * Sorts movies by release year by using MovieComparatorByDate()
     */
    public void SortMoviesDate()
    {
        Collections.sort(currentList.getMovies(), new MovieComparatorByDate());
        RefreshGrid();
    }

    /**
     * Sorts movies by runtime by using MovieComparatorByRuntime()
     */
    public void SortMoviesRuntime()
    {
        Collections.sort(currentList.getMovies(), new MovieComparatorByRuntime());
        RefreshGrid();
    }

    /**
     * Filters movies by genre
     * @param genre - passed in genre to filter by
     */
    public void FilterMoviesGenre(String genre)
    {
        //Indicates no genre was selected in the filter panel
        if(genre.equals("Genre"))
            return;

        ArrayList<String> genrePass = new ArrayList<String>();
        genrePass.add(genre);
        FilterMovies.filterByGenre(currentList.getMovies(),genrePass);
        RefreshGrid();
    }

    /**
     * Filters movies by language
     * @param language - passed in language to filter by
     */
    public void FilterMoviesLanguage(String language)
    {
        //Indicates no language was selected in the filter panel
        if(language.equals("Language"))
            return;

        ArrayList<String> languagePass = new ArrayList<String>();
        languagePass.add(language);
        FilterMovies.filterByLanguage(currentList.getMovies(), languagePass);
        RefreshGrid();
    }

    /**
     * Filters movies by country
     * @param country - passed in country to filter by
     */
    public void FilterMoviesCountry(String country)
    {
        //Indicates no country was selected in the filter panel
        if(country.equals("Country"))
            return;

        ArrayList<String> countryPass = new ArrayList<String>();
        countryPass.add(country);
        FilterMovies.filterByCountry(currentList.getMovies(), countryPass);
        RefreshGrid();
    }

    /**
     * Filter movies by release year (will be grouped into decades)
     * @param year - passed in decade to filter by
     */
    public void FilterMoviesYear(String year)
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

        FilterMovies.filterByYear(currentList.getMovies(), years);
        RefreshGrid();
    }

    /**
     * Filter movies by age rating
     * @param age - passed in age rating to filter by
     */
    public void FilterMoviesAge(String age)
    {
        //Indicates no age rating was selected in the filter panel
        if(age.equals("Age Rating"))
            return;

        FilterMovies.filterByAgeRating(currentList.getMovies(), age);
        RefreshGrid();
    }

    /**
     * Refreshes the currently shown movie grid to reflect any changes made to it
     */
    public void RefreshGrid()
    {
        this.remove(jp);
        grid = new MovieGrid(currentList);

        //Create action listeners for the movie buttons that bring you to the corresponding MovieView
        for(int i = 0; i < currentList.getMovies().size(); i++)
        {
            final int final_i = i;
            grid.addPosterListener(event ->
            {
                MainWindow view = MainWindow.getInstance();
                view.ShowMovie(currentList.getMovies().get(final_i), e -> view.ShowHome());
            }, i);
        }

        jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp.getVerticalScrollBar().setUnitIncrement(20);


        this.add(jp,BorderLayout.CENTER);
        this.repaint();
        MainWindow.getInstance().setVisible(true);
    }


}