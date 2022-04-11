package View;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel
{
    LoginWindow loginWindow;

    public SearchPanel(JFrame parent)
    {
        final int SEARCH_SIZE = 20;
        this.setLayout(new BorderLayout(7, 7));
        loginWindow = new LoginWindow(parent);

        //Setup search bar
        Font searchFont = new Font(Font.SANS_SERIF, Font.BOLD, 35);
        JTextField searchBar = new JTextField(SEARCH_SIZE);
        searchBar.setText("Search...");
        searchBar.setFont(searchFont);
        searchBar.addActionListener(event ->
        {
            System.out.println("Enter Pressed");   //Use this action lister to search when enter button is pressed in search bar
        });

        //setup login/signup button
        JButton loginSignupButton = new JButton("Login/Signup");
        loginSignupButton.addActionListener(loginWindow);

        //setup home button
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(event ->
        {
            System.out.println("Home button pressed"); //action listener for home button
        });


        this.add(searchBar, BorderLayout.CENTER);
        this.add(loginSignupButton, BorderLayout.EAST);
        this.add(homeButton, BorderLayout.WEST);
        //this.add(SortFilterPanel, BorderLayout.SOUTH);  maybe add the sort and filter panel here when that's made
    }
}
