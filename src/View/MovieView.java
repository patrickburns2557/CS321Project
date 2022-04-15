package View;

import Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MovieView extends JPanel
{
    private JButton homeButton;
    private ImageIcon poster;
    private JPanel posterAndCollectionsLabel = new JPanel();
    private JComboBox collectionList;
    private JLabel movieLabel;
    private JLabel yearLabel;
    private JLabel genreLabel;
    private JLabel runtimeLabel;
    private JLabel userRating;
    private JLabel descriptionLabel;
    private JLabel directorLabel;
    private JLabel actorLabel;
    private ButtonGroup ratingGroup;
    private JButton submitRatingButton;


    public MovieView(Movie inputMovie) //TEMP FOR NOW, WILL BE MOVIE OBJECT LATER
    {
        //For testing word wrap
        String Title = inputMovie.gettitle();
        int Year = inputMovie.getyear();
        String Genre = inputMovie.getgenre();
        String Runtime = inputMovie.getruntime();
        String Plot = inputMovie.getplot();
        String Directors; /////////////////////////////////////////////////
        String Actors; ////////////////////////////////////////////


        this.setLayout(new GridBagLayout());

        //Button to return home
        homeButton = new JButton("<-- Return to home");
        homeButton.setFont(new Font("Georgia", Font.BOLD, 18));
        GridBagConstraints homeButtonC = new GridBagConstraints();
        homeButtonC.gridx = 0;
        homeButtonC.gridy = 0;
        homeButtonC.ipadx = 10;
        homeButtonC.ipady = 10;
        homeButtonC.insets = new Insets(10,10,10,10);
        homeButtonC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(homeButton, homeButtonC);

        homeButton.addActionListener(event ->
        {
            MainWindow view = MainWindow.getInstance();
            view.ShowHome();
        });



        //Poster and add to collection dropdown
        poster = new ImageIcon(CreatePoster.getFromURL(inputMovie.getposter(), Title, Year));
        JLabel picLabel = new JLabel(poster);

        posterAndCollectionsLabel.setLayout(new BorderLayout());
        posterAndCollectionsLabel.add(picLabel, BorderLayout.CENTER);

        String[] TEMPCOLLECTIONLIST = {"Collection1", "Collection2", "Collection3"};                //GET USER'S COLLECTION LIST
        collectionList = new JComboBox(TEMPCOLLECTIONLIST);
        posterAndCollectionsLabel.add(collectionList, BorderLayout.SOUTH);

        picLabel.setBorder(BorderFactory.createEtchedBorder());         //maybe find some border that looks decent for the Movie picture
        GridBagConstraints picLabelC = new GridBagConstraints();
        picLabelC.gridx = 0;
        picLabelC.gridy = 1;
        picLabelC.gridwidth = 1;
        picLabelC.gridheight = 10;
        picLabelC.ipadx = 25;
        picLabelC.ipady = 25;
        picLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        //picLabelC.fill = GridBagConstraints.VERTICAL;
        //this.add(picLabel, picLabelC);
        this.add(posterAndCollectionsLabel, picLabelC);



        //Label for Movie name
        movieLabel = new JLabel(inputMovie.gettitle());                                        //GRAB MOVIE NAME
        //movieLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        movieLabel.setFont(new Font("Arial Black", Font.BOLD, 50));             //FIND A DECENT FONT
        GridBagConstraints movieLabelC = new GridBagConstraints();
        movieLabelC.gridx = 1;
        movieLabelC.gridy = 1;
        movieLabelC.ipadx = 10;
        movieLabelC.ipady = 10;
        movieLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(movieLabel, movieLabelC);



        //Label for Movie year
        yearLabel = new JLabel(Integer.toString(Year));                                             //GRAB MOVIE YEAR
        yearLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        GridBagConstraints yearLabelC = new GridBagConstraints();
        yearLabelC.gridx = 1;
        yearLabelC.gridy = 2;
        yearLabelC.ipadx = 10;
        yearLabelC.ipady = 10;
        yearLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(yearLabel, yearLabelC);



        //Label for Movie genre(s)
        genreLabel = new JLabel(Genre);                     //GRAB MOVIE GENRE(S)
        genreLabel.setFont(new Font("Georgia", Font.BOLD, 15));
        GridBagConstraints genreLabelC = new GridBagConstraints();
        genreLabelC.gridx = 1;
        genreLabelC.gridy = 3;
        genreLabelC.ipadx = 10;
        genreLabelC.ipady = 10;
        genreLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(genreLabel, genreLabelC);



        runtimeLabel = new JLabel(Runtime);
        runtimeLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        GridBagConstraints runtimeLabelC = new GridBagConstraints();
        runtimeLabelC.gridx = 1;
        runtimeLabelC.gridy = 4;
        runtimeLabelC.ipadx = 10;
        runtimeLabelC.ipady = 10;
        runtimeLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(runtimeLabel, runtimeLabelC);



        userRating = new JLabel("User Ratings: " + "3.4/5");                    //CALCULATE USER RATING
        userRating.setFont(new Font("Georgia", Font.BOLD, 17));
        GridBagConstraints userRatingC = new GridBagConstraints();
        userRatingC.gridx = 1;
        userRatingC.gridy = 5;
        userRatingC.ipadx = 10;
        userRatingC.ipady = 10;
        userRatingC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(userRating, userRatingC);





        //Label for Movie description
        //Add a "<html>" to the beginning of the label so that it gets interpreted as html and will word wrap
        //It does not word wrap by default
        descriptionLabel = new JLabel("<html>" + Plot);                   //GRAB MOVIE DESCRIPTIONS
        descriptionLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
        descriptionLabel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Movie Description"));
        GridBagConstraints descriptionLabelC = new GridBagConstraints();
        //descriptionLabelC.weightx = 0.5;
        //descriptionLabelC.weighty = 0.5;
        descriptionLabelC.gridx = 1;
        descriptionLabelC.gridy = 6;
        descriptionLabelC.ipadx = 15;
        descriptionLabelC.ipady = 15;
        descriptionLabelC.insets = new Insets(30, 0, 30, 20);
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
        directorLabelC.gridy = 7;
        directorLabelC.ipadx = 10;
        directorLabelC.ipady = 10;
        directorLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(directorLabel, directorLabelC);



        //Label for movie actor(s)
        String actors = "Actor1, Actor2, Actor3";
        actorLabel = new JLabel("Actors: " + actors);                           //GRAB MOVIE ACTORS
        actorLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        GridBagConstraints actorLabelC = new GridBagConstraints();
        //actorLabelC.weightx = 0.5;
        //actorLabelC.weighty = 0.5;
        actorLabelC.gridx = 1;
        actorLabelC.gridy = 8;
        actorLabelC.ipadx = 10;
        actorLabelC.ipady = 10;
        actorLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(actorLabel, actorLabelC);



        //Panel for letting the user rate the movie
        final JRadioButton star1 = new JRadioButton("1");
        final JRadioButton star2 = new JRadioButton("2");
        final JRadioButton star3 = new JRadioButton("3");
        final JRadioButton star4 = new JRadioButton("4");
        final JRadioButton star5 = new JRadioButton("5");
        submitRatingButton = new JButton("Submit Rating");
        ratingGroup = new ButtonGroup();
        ratingGroup.add(star1);
        ratingGroup.add(star2);
        ratingGroup.add(star3);
        ratingGroup.add(star4);
        ratingGroup.add(star5);
        JPanel ratingPanel = new JPanel();
        ratingPanel.setLayout(new GridLayout(1,6));
        ratingPanel.add(star1);
        ratingPanel.add(star2);
        ratingPanel.add(star3);
        ratingPanel.add(star4);
        ratingPanel.add(star5);
        ratingPanel.add(submitRatingButton);
        ratingPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Rate Movie:"));
        GridBagConstraints ratingC = new GridBagConstraints();
        ratingC.weightx = 0.5;
        ratingC.weighty = 0.5;
        ratingC.gridx = 1;
        ratingC.gridy = 9;
        ratingC.ipadx = 10;
        ratingC.ipady = 10;
        ratingC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(ratingPanel, ratingC);

        //Label for showing current user rating
        userRating = new JLabel();


    }
}