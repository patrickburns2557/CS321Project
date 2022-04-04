package View;

import javax.swing.*;
import java.awt.*;

public class MovieView extends JPanel
{
    public MovieView(String movieName) //TEMP FOR NOW, WILL BE MOVIE OBJECT LATER
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        this.add(new JButton("test"));
        this.add(new JButton("test2"));
        this.add(new JButton("very long button name test"));
    }
}
