package View;

import Model.Movie;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieView extends JPanel
{
    private JButton homeButton;
    private ImageIcon poster;
    private JPanel posterAndCollectionsLabel = new JPanel();
    private JComboBox<String> collectionList;
    private JButton addToCollectionButton;
    private JLabel movieLabel;
    private JLabel yearLabel;
    private JLabel ageLabel;
    private JLabel genreLabel;
    private JLabel runtimeLabel;
    private JLabel imdbLabel;
    private JLabel userRating;
    private JLabel descriptionLabel;
    private JLabel directorLabel;
    private JLabel actorLabel;
    private ButtonGroup ratingGroup;
    private JButton submitRatingButton;


    public MovieView(Movie inputMovie) //TEMP FOR NOW, WILL BE MOVIE OBJECT LATER
    {
        String Title = inputMovie.gettitle();
        int Year = inputMovie.getyear();
        float imdbRating = inputMovie.getCriticRating();
        String Genre = inputMovie.getgenre();
        String AgeRating = inputMovie.getagerating();
        String Runtime = inputMovie.getruntime();
        String Plot = inputMovie.getplot();
        String Directors = inputMovie.getdirector();
        String Actors = inputMovie.getActors();
        String[] CollectionNames;




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
        posterAndCollectionsLabel.add(picLabel, BorderLayout.NORTH);

        //Only show collection dropdown if a user is logged in
        if(Model.System.getInstance().getCurrentUser() != null)
        {
            ArrayList<Model.Collection> CollectionList = Model.System.getInstance().getCurrentUser().getCollections();
            CollectionNames = new String[CollectionList.size()];
            for(int i = 0; i < CollectionList.size();i++)
            {
                CollectionNames[i] = CollectionList.get(i).getName();
            }
            collectionList = new JComboBox(CollectionNames);
            posterAndCollectionsLabel.add(collectionList, BorderLayout.CENTER);

            addToCollectionButton = new JButton("Add to collection");
            posterAndCollectionsLabel.add(addToCollectionButton, BorderLayout.SOUTH);

            addToCollectionButton.addActionListener(event ->
            {
                Model.Collection current;
                for(Model.Collection i : CollectionList)
                {
                    if(i.getName().equals(collectionList.getSelectedItem()))
                        i.addMovie(inputMovie);
                }
            });
        }

        picLabel.setBorder(BorderFactory.createEtchedBorder());
        GridBagConstraints picLabelC = new GridBagConstraints();
        picLabelC.gridx = 0;
        picLabelC.gridy = 1;
        picLabelC.gridwidth = 1;
        picLabelC.gridheight = 15;
        picLabelC.ipadx = 25;
        picLabelC.ipady = 25;
        picLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(posterAndCollectionsLabel, picLabelC);



        //Label for Movie name
        movieLabel = new JLabel(inputMovie.gettitle());
        movieLabel.setFont(new Font("Arial Black", Font.BOLD, 50));
        GridBagConstraints movieLabelC = new GridBagConstraints();
        movieLabelC.gridx = 1;
        movieLabelC.gridy = 1;
        movieLabelC.ipadx = 10;
        movieLabelC.ipady = 10;
        movieLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(movieLabel, movieLabelC);



        //Label for Movie year
        yearLabel = new JLabel(Integer.toString(Year));
        yearLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        GridBagConstraints yearLabelC = new GridBagConstraints();
        yearLabelC.gridx = 1;
        yearLabelC.gridy = 2;
        yearLabelC.ipadx = 10;
        yearLabelC.ipady = 10;
        yearLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(yearLabel, yearLabelC);



        //Label for Movie age rating
        ageLabel = new JLabel(AgeRating);
        ageLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        GridBagConstraints ageLabelC = new GridBagConstraints();
        ageLabelC.gridx = 1;
        ageLabelC.gridy = 3;
        ageLabelC.ipadx = 10;
        ageLabelC.ipady = 10;
        ageLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(ageLabel, ageLabelC);



        //Label for Movie genre(s)
        genreLabel = new JLabel(Genre);
        genreLabel.setFont(new Font("Georgia", Font.BOLD, 15));
        GridBagConstraints genreLabelC = new GridBagConstraints();
        genreLabelC.gridx = 1;
        genreLabelC.gridy = 4;
        genreLabelC.ipadx = 10;
        genreLabelC.ipady = 10;
        genreLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(genreLabel, genreLabelC);



        //Label for Movie runtime
        runtimeLabel = new JLabel(Runtime);
        runtimeLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        GridBagConstraints runtimeLabelC = new GridBagConstraints();
        runtimeLabelC.gridx = 1;
        runtimeLabelC.gridy = 5;
        runtimeLabelC.ipadx = 10;
        runtimeLabelC.ipady = 10;
        runtimeLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(runtimeLabel, runtimeLabelC);



        //Label for imdb ratings
        imdbLabel = new JLabel("IMDb Rating: " + imdbRating);
        imdbLabel.setFont(new Font("Georgia", Font.BOLD, 17));
        GridBagConstraints imdbLabelC = new GridBagConstraints();
        imdbLabelC.gridx = 1;
        imdbLabelC.gridy = 6;
        imdbLabelC.ipadx = 10;
        imdbLabelC.ipady = 10;
        imdbLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(imdbLabel, imdbLabelC);



        //Label for user ratings
        userRating = new JLabel("User Ratings: " + Model.System.getInstance().calculateUserRatingForMovie(inputMovie) + "/5 from " + Model.System.getInstance().calculateNumberUserRatingsForMovie(inputMovie) + " ratings");
        userRating.setFont(new Font("Georgia", Font.BOLD, 17));
        GridBagConstraints userRatingC = new GridBagConstraints();
        userRatingC.gridx = 1;
        userRatingC.gridy = 7;
        userRatingC.ipadx = 10;
        userRatingC.ipady = 10;
        userRatingC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(userRating, userRatingC);



        //Label for Movie description
        //Add a "<html>" to the beginning of the label so that it gets interpreted as html and will word wrap
        //It does not word wrap by default
        descriptionLabel = new JLabel("<html>" + Plot);
        descriptionLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
        descriptionLabel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Movie Description"));
        GridBagConstraints descriptionLabelC = new GridBagConstraints();
        //descriptionLabelC.weightx = 0.5;
        //descriptionLabelC.weighty = 0.5;
        descriptionLabelC.gridx = 1;
        descriptionLabelC.gridy = 8;
        descriptionLabelC.ipadx = 15;
        descriptionLabelC.ipady = 15;
        descriptionLabelC.insets = new Insets(30, 0, 30, 20);
        descriptionLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        descriptionLabelC.fill = GridBagConstraints.HORIZONTAL;
        this.add(descriptionLabel, descriptionLabelC);



        //Label for movie director(s)
        directorLabel = new JLabel("Directors: " + Directors);
        directorLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        GridBagConstraints directorLabelC = new GridBagConstraints();
        //directorLabelC.weightx = 0.5;
        //directorLabelC.weighty = 0.5;
        directorLabelC.gridx = 1;
        directorLabelC.gridy = 9;
        directorLabelC.ipadx = 10;
        directorLabelC.ipady = 10;
        directorLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(directorLabel, directorLabelC);



        //Label for movie actor(s)
        actorLabel = new JLabel("Actors: " + Actors);
        actorLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        GridBagConstraints actorLabelC = new GridBagConstraints();
        //actorLabelC.weightx = 0.5;
        //actorLabelC.weighty = 0.5;
        actorLabelC.gridx = 1;
        actorLabelC.gridy = 10;
        actorLabelC.ipadx = 10;
        actorLabelC.ipady = 10;
        actorLabelC.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(actorLabel, actorLabelC);



        //Panel for letting the user rate the movie
        if(Model.System.getInstance().getCurrentUser() != null)
        {
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
            ratingC.gridy = 11;
            ratingC.ipadx = 10;
            ratingC.ipady = 10;
            ratingC.anchor = GridBagConstraints.FIRST_LINE_START;
            this.add(ratingPanel, ratingC);
            submitRatingButton.addActionListener(event ->
            {
                if(star1.isSelected())
                    Model.System.getInstance().getCurrentUser().addUserRating(inputMovie, 1);
                else if(star2.isSelected())
                    Model.System.getInstance().getCurrentUser().addUserRating(inputMovie, 2);
                else if(star3.isSelected())
                    Model.System.getInstance().getCurrentUser().addUserRating(inputMovie, 3);
                else if(star4.isSelected())
                    Model.System.getInstance().getCurrentUser().addUserRating(inputMovie, 4);
                else if(star5.isSelected())
                    Model.System.getInstance().getCurrentUser().addUserRating(inputMovie, 5);
                else
                {

                }
                MainWindow parent = MainWindow.getInstance();
                JOptionPane.showMessageDialog(parent, "Rating submitted!");
                MainWindow.getInstance().ShowMovie(inputMovie);
            });
        }
        else
        {
            JPanel fillerPanel = new JPanel();
            GridBagConstraints fillerPanelC = new GridBagConstraints();
            fillerPanelC.weightx = 0.5;
            fillerPanelC.weighty = 0.5;
            fillerPanelC.gridx = 1;
            fillerPanelC.gridy = 11;
            fillerPanelC.ipadx = 10;
            fillerPanelC.ipady = 10;
            this.add(fillerPanel, fillerPanelC);
        }
    }
}