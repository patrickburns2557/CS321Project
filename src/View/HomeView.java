package View;

import Model.*;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.security.cert.CollectionCertStoreParameters;
import java.sql.Array;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Filter;

public class HomeView extends JPanel
{
    private MovieGrid grid;
    private Collection currentList;
    private JScrollPane jp;
    private SearchPanel searchPanel;
    private SortFilterPanel sortFilterPanel;

    public HomeView()
    {
        Model.System sys = Model.System.getInstance();

        this.setLayout(new BorderLayout());
        JPanel temp = new JPanel();
        temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
        JButton b1 = new JButton("tempbutton b1");
        JButton b2 = new JButton("tempbutton collectiongrid");
        JButton b3 = new JButton("tempbutton sort");
        JButton b4 = new JButton("tempbutton");
        temp.add(b1);
        temp.add(b2);
        temp.add(b3);
        temp.add(b4);
        this.add(temp, BorderLayout.WEST);

        b2.addActionListener(event ->
        {
            MainWindow.getInstance().ShowTemp();
        });
        b3.addActionListener(event ->
        {
            ResetMovies();
        });

        //Setup Movie grid
        currentList = new Collection("master", sys.getMasterList());
        Collections.sort(currentList.getMovies(), new MovieComparatorByName());
        grid = new MovieGrid(currentList);
        jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp.getVerticalScrollBar().setUnitIncrement(20);
        this.add(jp,BorderLayout.CENTER);

        //Setup Search panel
        searchPanel = new SearchPanel();
        this.add(searchPanel, BorderLayout.NORTH);

        //Setup Sort/Filter panel
        sortFilterPanel = new SortFilterPanel();
        this.add(sortFilterPanel, BorderLayout.EAST);



        searchPanel.searchBar.addActionListener(event ->
        {
            SearchMovies();
        });
    }

    public void ResetMovies()
    {
        Model.System sys = Model.System.getInstance();
        currentList = new Collection("master", sys.getMasterList());
        SortMoviesTitle();
    }

    public void SearchMovies()
    {
        Model.System sys = Model.System.getInstance();
        currentList = new Collection("master", sys.getMasterList());
        FilterMovies.filterByTitle(currentList.getMovies(), searchPanel.getEntry());
        RefreshGrid();
    }

    public void SortMoviesTitle()
    {
        Collections.sort(currentList.getMovies(), new MovieComparatorByName());
        RefreshGrid();
    }
    public void SortMoviesCritic()
    {
        Collections.sort(currentList.getMovies(), new MovieComparatorByCriticRating());
        RefreshGrid();
    }
    public void SortMoviesDate()
    {
        Collections.sort(currentList.getMovies(), new MovieComparatorByDate());
        RefreshGrid();
    }
    public void SortMoviesRuntime()
    {
        Collections.sort(currentList.getMovies(), new MovieComparatorByName());
        RefreshGrid();
    }

    public void FilterMoviesGenre(String genre)
    {
        if(genre.equals("Genre"))
            return;
        ArrayList<String> genrePass = new ArrayList<String>();
        genrePass.add(genre);
        FilterMovies.filterByGenre(currentList.getMovies(),genrePass);
        RefreshGrid();
    }
    public void FilterMoviesLanguage(String language)
    {
        if(language.equals("Language"))
            return;
        ArrayList<String> languagePass = new ArrayList<String>();
        languagePass.add(language);
        FilterMovies.filterByLanguage(currentList.getMovies(), languagePass);
        RefreshGrid();
    }
    public void FilterMoviesCountry(String country)
    {
        if(country.equals("Country"))
            return;
        ArrayList<String> countryPass = new ArrayList<String>();
        countryPass.add(country);
        FilterMovies.filterByCountry(currentList.getMovies(), countryPass);
        RefreshGrid();
    }
    public void FilterMoviesYear(String year)
    {
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
    public void FilterMoviesAge(String age)
    {
        if(age.equals("Age Rating"))
            return;
        FilterMovies.filterByAgeRating(currentList.getMovies(), age);
        RefreshGrid();
    }

    public void RefreshGrid()
    {
        this.remove(jp);
        grid = new MovieGrid(currentList);
        jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp.getVerticalScrollBar().setUnitIncrement(20);


        this.add(jp,BorderLayout.CENTER);
        this.repaint();
        MainWindow.getInstance().setVisible(true);
    }


}