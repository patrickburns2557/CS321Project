package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Class to create and return a poster image for the passed in movie.
 */
public class CreatePoster
{
    /**
     * Method to create and return an image based on the passed in movie
     * @param inputURL - Web URL to pull the image from, if one exists
     * @param MovieName - Name of the movie, used if URL image fails, or doesn't exist
     * @param MovieYear - Year of the movie release, used if URL image fails, or doesn't exist
     * @return - Image based on the input movie details
     */
    public static Image getFromURL(String inputURL, String MovieName, int MovieYear)
    {
        ImageIcon icon;
        try
        {
            //replaces all ":" with "_" since colons are not a valid character for file names.
            MovieName = MovieName.replace(":", "_");

            //old way of loading
            //File posterFile = new File(  "src\\Posters\\" + MovieName + MovieYear + ".png");
            /*//Check to see if a poster file already exists for the movie, and load that if so
            if(posterFile.exists())
            {
                BufferedImage img = null;
                //img = ImageIO.read(new File("src\\Posters\\" + MovieName + MovieYear + ".png"));
                img = ImageIO.read(posterFile);
                return img;
            }*/

            BufferedImage buff = null;
            if(CreatePoster.class.getResource("/main/resources/Posters/" + MovieName + MovieYear + ".png") != null)
            {
                buff = ImageIO.read(CreatePoster.class.getResource("/main/resources/Posters/" + MovieName + MovieYear + ".png"));
            }

            if(buff != null)
            {
                return buff;
            }
            else//image file doesn't exist yet
            {
                //create a new poster file for the movie
                try
                {
                    URL url = new URL(inputURL);
                    icon = new ImageIcon(url);
                    BufferedImage outputImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics g = outputImage.createGraphics();
                    icon.paintIcon(null, g, 0, 0);
                    g.dispose();

                    ImageIO.write(outputImage, "png", new File("src\\Posters\\" + MovieName + MovieYear + ".png"));
                    return outputImage;
                }catch(Exception ex)
                {
                    //If no poster image was found, create a blank poster with just the movie title and year of release
                    return defaultPoster(MovieName, MovieYear);
                }

            }
        }catch(IOException ex)
        {
            //if this happens, the return defaultPoster call below will be called and a poster will still be returned
            System.out.println("Error creating poster image");
        }
        return defaultPoster(MovieName, MovieYear);
    }

    /**
     * Creates blank poster image with just the movie name and year
     * @param MovieName - variable supplied for the movie name
     * @param MovieYear - variable supplied for the movie year
     * @return - blank poster with the movie title and year of release
     */
    public static BufferedImage defaultPoster(String MovieName, int MovieYear)
    {
        PosterText posterIcon = new PosterText(MovieName + " " + MovieYear);
        int w = posterIcon.getIconWidth();
        int h = posterIcon.getIconHeight();
        //Converts from an Icon to a valid image to return
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        BufferedImage image = gc.createCompatibleImage(w, h);
        Graphics2D g = image.createGraphics();
        posterIcon.paintIcon(null, g, 0, 0);
        g.dispose();
        return image;
    }
}