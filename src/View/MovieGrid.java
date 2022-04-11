package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieGrid extends JPanel
{
    public static final int MOVIE_WIDTH = 220;
    public static final int MOVIE_HEIGHT = 330;

    public MovieGrid(ArrayList<String> tempList) //REPLACE WITH MOVIELIST LATER
    {
        this.setLayout(new WrapLayout(FlowLayout.CENTER, 15, 15)); // Wrap Layout extends Flowlayout and just
        // properly wraps to the next line when runs out of horizontal space
        // Regular FlowLayout doesn't wrap to the next line when a JScrollPane is added to it


        //TEMPORARY CREATION OF BUTTONS FOR MOVIES FOR NOW
        ArrayList<JButton> buttonList = new ArrayList<JButton>();
        for(String line : tempList)
        {
            buttonList.add(new JButton(line));
        }
        for(JButton button : buttonList)
        {
            button.setPreferredSize(new Dimension(MOVIE_WIDTH,MOVIE_HEIGHT));
            this.add(button);
        }
    }
}
