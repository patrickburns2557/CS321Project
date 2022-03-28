package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieGrid extends JPanel
{
    public MovieGrid(ArrayList<String> tempList) //REPLACE WITH MOVIELIST LATER
    {
        this.setLayout(new WrapLayout(FlowLayout.CENTER, 15, 15)); // Wrap Layout extends Flowlayout and just wraps
        // to the next line when runs out of horizontal space
        ArrayList<JButton> buttonList = new ArrayList<JButton>();

        //TEMPORARY CREATION OF BUTTONS FOR MOVIES FOR NOW
        for(String line : tempList)
        {
            buttonList.add(new JButton(line));
        }
        for(JButton button : buttonList)
        {
            button.setPreferredSize(new Dimension(220,330));
            this.add(button);
        }
    }
}
