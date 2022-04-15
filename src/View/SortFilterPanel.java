package View;

import javax.swing.*;
import java.awt.*;

public class SortFilterPanel extends JPanel
{
    private JPanel sortPanel;
    private JButton sortCriticButton;
    private JButton sortDateButton;
    private JButton sortIMDBButton;
    private JButton sortNameButton;
    private JButton sortRuntimeButton;

    private JPanel filterPanel;
    private JComboBox filterGenreCombo;
    private JComboBox filterLanguageCombo;
    private JComboBox filterCountryCombo;
    private JComboBox filterYearCombo;
    private JComboBox filterAgeCombo;


    public SortFilterPanel()
    {
        this.setLayout(new GridLayout(2,1));


        sortPanel = new JPanel();
        sortPanel.setLayout(new GridLayout(5, 1));

        sortCriticButton = new JButton("Critic Rating");
        sortDateButton = new JButton("Release Date");
        //sortIMDBButton = new




    }
}
