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

        filterGenreCombo = new JComboBox();
        filterLanguageCombo = new JComboBox();
        filterCountryCombo = new JComboBox();
        filterYearCombo = new JComboBox();
        filterAgeCombo = new JComboBox();





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
