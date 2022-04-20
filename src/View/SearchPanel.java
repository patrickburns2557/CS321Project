package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel
{
    JTextField searchBar;
    JButton loginSignupButton;
    JButton homeButton;

    public SearchPanel()
    {
        final int SEARCH_SIZE = 20;
        this.setLayout(new BorderLayout(7, 7));

        //Setup search bar
        Font searchFont = new Font(Font.SANS_SERIF, Font.BOLD, 35);
        searchBar = new JTextField(SEARCH_SIZE);
        searchBar.setText("Search...");
        searchBar.setFont(searchFont);
        searchBar.addActionListener(event ->
        {
            System.out.println("Enter Pressed");   //Use this action lister to search when enter button is pressed in search bar

        });

        //setup login/signup button
        if(Model.System.getInstance().getCurrentUser() == null)
        {
            loginSignupButton = new JButton("Login/Signup");
            loginSignupButton.addActionListener(new LoginWindow());
        }
        else
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

    public void addSearchListener(ActionListener listenForSearch)
    {
        searchBar.addActionListener(listenForSearch);
    }

    public String getEntry()
    {
        return searchBar.getText();
    }
}