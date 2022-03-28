package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieGrid extends JPanel
{
    public MovieGrid(ArrayList<String> tempList) //REPLACE WITH MOVIELIST LATER
    {
        this.setLayout(new GridLayout(5,5));
        ArrayList<JButton> buttonList = new ArrayList<JButton>();

        for(String line : tempList)
        {
            buttonList.add(new JButton(line));
            System.out.println("Added " + line);
        }
        this.setVisible(true);

    }
}
