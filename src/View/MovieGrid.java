package View;

import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieGrid extends JPanel
{
    public static final int MOVIE_WIDTH = 220;
    public static final int MOVIE_HEIGHT = 330;

    public MovieGrid(Movie[] movieList) //REPLACE WITH MOVIELIST LATER
    {
        this.setLayout(new WrapLayout(FlowLayout.LEADING, 15, 15)); // Wrap Layout extends Flowlayout and just
        // properly wraps to the next line when runs out of horizontal space
        // Regular FlowLayout doesn't wrap to the next line when a JScrollPane is added to it


        //Create Buttons for each movie listed in the grid
        ArrayList<JButton> buttonList = new ArrayList<JButton>();
        for(Movie movie : movieList)
        {
            Image img = new ImageIcon(CreatePoster.getFromURL(movie.getposter(), movie.gettitle())).getImage(); //create image from the poster link
            Image resizedImage = img.getScaledInstance(MOVIE_WIDTH, MOVIE_HEIGHT, Image.SCALE_SMOOTH); //resize the image to fit on teh button
            buttonList.add(new JButton(new ImageIcon(resizedImage))); //add the button to the buttonList
        }
        //add each button to the MovieGrid JPanel
        for(int i = 0; i < movieList.length; i++)
        {
            final int final_i = i;
            //resize the poster to fit on the button for it
            buttonList.get(i).setPreferredSize(new Dimension(MOVIE_WIDTH,MOVIE_HEIGHT));
            buttonList.get(i).addActionListener(new
                                                        ActionListener()
                                                        {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                System.out.println(movieList[final_i].gettitle() + " button pressed");
                                                                MainWindow view = MainWindow.getInstance();
                                                                view.ShowMovie(movieList[final_i]);
                                                            }
                                                        });
            this.add(buttonList.get(i));
        }
    }
}
