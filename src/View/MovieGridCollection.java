package View;

import Model.Collection;
import Model.Movie;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;

public class MovieGridCollection extends MovieGrid
{
    boolean isMaster;
    ArrayList<JButton> addButtonList;

    public MovieGridCollection(Collection list)
    {
        super(list);
        addButtonList = new ArrayList<JButton>();
        if(list.getName().equals("master"))
            isMaster = true;
        else
            isMaster = false;
        for(JPanel panel : posterPanels)
        {
            CreateCollectionButton(panel);
        }
        this.repaint();
        MainWindow.getInstance().repaint();
        MainWindow.getInstance().setVisible(true);
    }

    public void SelectMovie(int i)
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
                                                            MainWindow view = MainWindow.getInstance();
                                                            view.ShowMovie(movieList.get(final_i));
                                                        }
                                                    });
        this.add(buttonList.get(i));
    }

    private void CreateCollectionButton(JPanel inputPanel)
    {
        /*Image img = new ImageIcon(CreatePoster.getFromURL(movie.getposter(), movie.gettitle(), movie.getyear())).getImage();//create image from the poster link
        Image resizedImage = img.getScaledInstance(MOVIE_WIDTH, MOVIE_HEIGHT, Image.SCALE_SMOOTH); //resize the image to fit on teh button*/

        inputPanel.setLayout(new GridLayout(2,1));


        JButton addButton;
        if(isMaster)
             addButton= new JButton("Add to collection");
        else
            addButton = new JButton("Remove from collection");
        inputPanel.add(addButton);
        addButtonList.add(addButton);
        inputPanel.repaint();

    }
}
