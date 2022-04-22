package View;

import Model.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to create a JPanel for the HomeView that the user is able to search and sort/filter through all the movies in the database
 */
public class HomeView extends JPanel implements ActionListener
{
    private MovieGrid grid;
    private JScrollPane jp;
    private SearchSortFilterPanel searchSortFilterPanel;
    private JButton loginSignupButton;
    private JButton collectionButton;
    private JPanel topBar;
    private boolean initialized = false;

    /**
     * Default constructor for HomeView
     * Creates grid of movies based on full database
     */
    public HomeView()
    {
        this.setLayout(new BorderLayout());

        topBar = new JPanel();
        topBar.setLayout(new BorderLayout());

        //setup login/signup/signout button
        //If user is not logged in, will allow the user to create and account or login
        if(Model.System.getInstance().getCurrentUser() == null)
        {
            loginSignupButton = new JButton("Login/Signup");
            loginSignupButton.addActionListener(new LoginWindow());
        }
        else//if user is logged in, will allow user to logout
        {
            loginSignupButton = new JButton("Logout of " + Model.System.getInstance().getCurrentUser().getUsername());
            loginSignupButton.addActionListener(event ->
            {
                Model.System.getInstance().logoutUser();
            });
        }

        topBar.add(loginSignupButton, BorderLayout.EAST);

        //setup Collection button to bring user to their collection list
        //Will only show up if the user is logged in
        if(Model.System.getInstance().getCurrentUser() != null)
        {
            collectionButton = new JButton("Collections");
            collectionButton.addActionListener(event ->
            {
                MainWindow.getInstance().ShowCollectionList();
            });
            topBar.add(collectionButton, BorderLayout.WEST);
        }

        //Setup Search panel
        searchSortFilterPanel = new SearchSortFilterPanel(Model.System.getInstance().getMasterList(), this);
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
        grid = new MovieGrid(new Collection ("List", currentList));

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

        jp = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp.getVerticalScrollBar().setUnitIncrement(20);

        this.add(jp,BorderLayout.CENTER);
        this.repaint();
        if (initialized)
            MainWindow.getInstance().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RefreshGrid();
    }
}