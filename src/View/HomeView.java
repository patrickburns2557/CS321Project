package View;

import Model.*;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.security.cert.CollectionCertStoreParameters;
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
            SortMoviesTitle();
        });

        //Setup Movie grid
        currentList = new Collection("master", sys.getMasterList());
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

    public void SearchMovies()
    {
        Model.System sys = Model.System.getInstance();
        currentList = new Collection("master", sys.getMasterList());
        FilterMovies.filterByTitle(currentList.getMovies(), searchPanel.getEntry());
        RefreshGrid();
    }

    public void SortMoviesTitle()
    {
        java.lang.System.out.println("SORT2");
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