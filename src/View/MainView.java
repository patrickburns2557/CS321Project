package View;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame
{


    public MainView()
    {
        JPanel test = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        //Maximize window on creation
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);


    }
}
