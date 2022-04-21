package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class to create a search panel used to search through the movie
 * database and display the login button
 */
public class SearchPanel extends JPanel
{
    JTextField searchBar;
    JButton loginSignupButton;
    JButton homeButton;

    /**
     * Constructor to create the SearchPanel
     */
    public SearchPanel()
    {
        this.setLayout(new BorderLayout(7, 7));

        //Setup search bar
        Font searchFont = new Font(Font.SANS_SERIF, Font.BOLD, 35);
        searchBar = new JTextField();
        searchBar.setText("Search...");
        searchBar.setFont(searchFont);

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


        //setup home button
        homeButton = new JButton("Home");
        homeButton.addActionListener(event ->
        {
            MainWindow.getInstance().ShowHome();
        });


        this.add(searchBar, BorderLayout.CENTER);
        this.add(loginSignupButton, BorderLayout.EAST);
        this.add(homeButton, BorderLayout.WEST);
    }

    /**
     * Method for the calling class to define what the searchbar does
     * @param listenForSearch - Passed in ActionListener to attach to the searchbar
     */
    public void addSearchListener(ActionListener listenForSearch)
    {
        searchBar.addActionListener(listenForSearch);
    }

    /**
     * Allows the calling class to find out what is currently typed in the searchbar
     * @return - text currently typed in searchbar
     */
    public String getEntry()
    {
        return searchBar.getText();
    }
}