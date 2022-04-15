package View;

import Model.Collection;
import Model.FilterMovies;
import Model.JsonInterface;
import Model.Movie;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.logging.Filter;

public class HomeView extends JPanel
{
    private MovieGrid grid;
    private Collection currentList;
    private JScrollPane jp;
    private SearchPanel searchPanel;

    public HomeView()
    {
        Model.System sys = Model.System.getInstance();

        this.setLayout(new BorderLayout());
        JPanel temp = new JPanel();
        temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
        JButton b1 = new JButton("tempbutton b1");
        JButton b2 = new JButton("tempbutton");
        JButton b3 = new JButton("tempbutton");
        JButton b4 = new JButton("tempbutton");
        temp.add(b1);
        temp.add(b2);
        temp.add(b3);
        temp.add(b4);
        this.add(temp, BorderLayout.WEST);

        b1.addActionListener(event ->
        {
            SearchMovies("Fast");
        });

        //Setup Movie grid
        currentList = new Collection("Master", sys.getMasterList());
        grid = new MovieGrid(currentList);


        jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp.getVerticalScrollBar().setUnitIncrement(20);

        this.add(jp,BorderLayout.CENTER);
        searchPanel = new SearchPanel();
        this.add(searchPanel, BorderLayout.NORTH);


        searchPanel.searchBar.addActionListener(event ->
        {
            SearchMoviesS();
        });

    }

    public void SearchMovies(String search)
    {
        FilterMovies.filterByTitle(currentList.getMovies(), search);
        this.remove(jp);
        grid = new MovieGrid(currentList);
        jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        this.add(jp,BorderLayout.CENTER);
        this.repaint();
        MainWindow.getInstance().setVisible(true);
    }

    public void SearchMoviesS()
    {
        FilterMovies.filterByTitle(currentList.getMovies(), searchPanel.getEntry());
        this.remove(jp);
        grid = new MovieGrid(currentList);
        jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        this.add(jp,BorderLayout.CENTER);
        this.repaint();
        MainWindow.getInstance().setVisible(true);
    }


}