package View;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MovieView extends JPanel
{
    private ImageIcon poster;
    private JPanel posterAndCollectionsLabel = new JPanel();
    private JComboBox collectionList;
    private JLabel movieLabel;
    private JLabel yearLabel;
    private JLabel genreLabel;
    private JLabel runtimeLabel;
    private JLabel descriptionLabel;
    private JLabel directorLabel;
    private JLabel actorLabel;

    public MovieView(String movieName) //TEMP FOR NOW, WILL BE MOVIE OBJECT LATER
    {
        //For testing word wrap
        String tempLongWords = "Lorem ipsum dolor sit amet, dui faucibus in ornare quam viverra orci sagittis " +
                "eu volutpat odio facilisis mauris sit amet massa vitae tortor condimentum lacinia quis vel " +
                "eros donec ac odio tempor orci dapibus ultrices in iaculis nunc sed augue lacus viverra vitae " +
                "congue eu consequat ac felis donec et odio pellentesque diam volutpat commodo sed egestas egestas" +
                " fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis" +
                " aliquam malesuada bibendum arcu vitae elementum curabitur vitae nunc sed velit dignissim " +
                "sodales ut eu sem integer vitae justo eget magna fermentum iaculis eu non diam phasellus vestibulum" +
                " lorem sed risus ultricies tristique nulla aliquet enim tortor at auctor urna nunc id cursus " +
                "metus aliquam eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci a " +
                "scelerisque purus semper eget duis at tellus at urna condimentum mattis pellentesque id nibh tortor" +
                " id aliquet lectus proin nibh nisl condimentum id venenatis a condimentum vitae sapien pellentesque" +
                " habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas sed tempus urna et" +
                " pharetra pharetra massa massa ultricies mi quis hendrerit dolor magna eget est lorem ipsum dolor " +
                "sit amet consectetur adipiscing elit pellentesque habitant morbi tristique senectus et netus et" +
                " malesuada fames ac turpis egestas integer eget";

        this.setLayout(new GridBagLayout());



        //Poster and add to collection dropdown
        poster = new ImageIcon("src\\View\\testPoster.jpg");                      //will eventually get the image from the Movie object passed in
        JLabel picLabel = new JLabel(poster);

        posterAndCollectionsLabel.setLayout(new BorderLayout());
        posterAndCollectionsLabel.add(picLabel, BorderLayout.CENTER);

        String[] TEMPCOLLECTIONLIST = {"Collection1", "Collection2", "Collection3"};                //GET USER'S COLLECTION LIST
        collectionList = new JComboBox(TEMPCOLLECTIONLIST);
        posterAndCollectionsLabel.add(collectionList, BorderLayout.SOUTH);

        picLabel.setBorder(BorderFactory.createEtchedBorder());         //maybe find some border that looks decent for the Movie picture
        GridBagConstraints picLabelC = new GridBagConstraints();
        picLabelC.gridx = 0;
        picLabelC.gridy = 0;
        picLabelC.gridwidth = 1;
        picLabelC.gridheight = 10;
        picLabelC.ipadx = 25;
        picLabelC.ipady = 25;
        picLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        //picLabelC.fill = GridBagConstraints.VERTICAL;
        //this.add(picLabel, picLabelC);
        this.add(posterAndCollectionsLabel, picLabelC);



        //Label for Movie name
        movieLabel = new JLabel(movieName);                                        //GRAB MOVIE NAME
        //movieLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        movieLabel.setFont(new Font("Wide Latin", Font.BOLD, 50));             //FIND A DECENT FONT
        GridBagConstraints movieLabelC = new GridBagConstraints();
        movieLabelC.gridx = 1;
        movieLabelC.gridy = 0;
        movieLabelC.ipadx = 10;
        movieLabelC.ipady = 10;
        movieLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(movieLabel, movieLabelC);



        //Label for Movie year
        yearLabel = new JLabel("1843");  //GRAB MOVIE YEAR
        yearLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        GridBagConstraints yearLabelC = new GridBagConstraints();
        yearLabelC.gridx = 1;
        yearLabelC.gridy = 1;
        yearLabelC.ipadx = 10;
        yearLabelC.ipady = 10;
        yearLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(yearLabel, yearLabelC);



        //Label for Movie genre(s)
        genreLabel = new JLabel("Genre: Horror, Action, Genre3");                     //GRAB MOVIE GENRE(S)
        genreLabel.setFont(new Font("Georgia", Font.BOLD, 15));
        GridBagConstraints genreLabelC = new GridBagConstraints();
        genreLabelC.gridx = 1;
        genreLabelC.gridy = 2;
        genreLabelC.ipadx = 10;
        genreLabelC.ipady = 10;
        genreLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(genreLabel, genreLabelC);


        int minutes = 112;                                                          //GRAB MOVIE RUNTIME
        runtimeLabel = new JLabel("Runtime: " + minutes + " minutes");
        runtimeLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        GridBagConstraints runtimeLabelC = new GridBagConstraints();
        runtimeLabelC.gridx = 1;
        runtimeLabelC.gridy = 3;
        runtimeLabelC.ipadx = 10;
        runtimeLabelC.ipady = 10;
        runtimeLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(runtimeLabel, runtimeLabelC);



        //Label for Movie description
        //Add a "<html>" to the beginning of the label so that it gets interpreted as html and will word wrap
        //It does not word wrap by default
        descriptionLabel = new JLabel("<html>" + tempLongWords);                   //GRAB MOVIE DESCRIPTIONS
        descriptionLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
        descriptionLabel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Movie Description"));
        GridBagConstraints descriptionLabelC = new GridBagConstraints();
        //descriptionLabelC.weightx = 0.5;
        //descriptionLabelC.weighty = 0.5;
        descriptionLabelC.gridx = 1;
        descriptionLabelC.gridy = 4;
        descriptionLabelC.ipadx = 15;
        descriptionLabelC.ipady = 15;
        descriptionLabelC.insets = new Insets(50, 0, 0, 20);
        descriptionLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        descriptionLabelC.fill = GridBagConstraints.HORIZONTAL;
        this.add(descriptionLabel, descriptionLabelC);



        //Label for movie director(s)
        String directors = "Person1, Person2, Person3";
        directorLabel = new JLabel("Directors: " + directors);                  //GRAB MOVIE DIRECTORS
        directorLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        GridBagConstraints directorLabelC = new GridBagConstraints();
        //directorLabelC.weightx = 0.5;
        //directorLabelC.weighty = 0.5;
        directorLabelC.gridx = 1;
        directorLabelC.gridy = 5;
        directorLabelC.ipadx = 10;
        directorLabelC.ipady = 10;
        directorLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(directorLabel, directorLabelC);



        //Label for movie actor(s)
        String actors = "Actor1, Actor2, Actor3";
        actorLabel = new JLabel("Actors: " + actors);                           //GRAB MOVIE ACTORS
        actorLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        GridBagConstraints actorLabelC = new GridBagConstraints();
        actorLabelC.weightx = 0.5;
        actorLabelC.weighty = 0.5;
        actorLabelC.gridx = 1;
        actorLabelC.gridy = 6;
        actorLabelC.ipadx = 10;
        actorLabelC.ipady = 10;
        actorLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(actorLabel, actorLabelC);

    }
}
