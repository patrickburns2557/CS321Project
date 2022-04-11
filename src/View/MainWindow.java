package View;

import javax.swing.*;
import java.util.Collection;


public class MainWindow extends JFrame
{
    private CollectionView test = new CollectionView();

    public MainWindow()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        //Maximize window on creation
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);




        //Just change between the two things below for homeview and movieview by commenting out for now until transitioning between them is setup
        //HomeView home = new HomeView();
        //this.add(home);


        MovieView Movie = new MovieView("Toy Story 4");
        this.add(Movie);

        this.add(test);
    }
}
