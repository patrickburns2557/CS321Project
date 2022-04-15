package View;

import Model.Movie;
import View.PosterText;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;

public class CreatePoster
{
    public static Image getFromURL(String inputURL, String MovieName, int MovieYear)
    {
        ImageIcon icon;
        try
        {
            MovieName = MovieName.replace(":", "_");
            File tempFile = new File("src\\Posters\\" + MovieName + MovieYear + ".png");
            //Check to see if a poster file already exists for the movie, and load that if so
            if(tempFile.exists())
            {
                BufferedImage img = null;
                img = ImageIO.read(new File("src\\Posters\\" + MovieName + MovieYear + ".png"));
                return img;
            }
            else//image doesn't exist yet
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
                    //If no poster image was found, create a blank poster with just the movie title
                    return defaultPoster(MovieName, MovieYear);
                }

            }
        }catch(IOException ex)
        {

        }
        return defaultPoster(MovieName, MovieYear);
    }

    //creates default poster image from the movie name
    public static BufferedImage defaultPoster(String MovieName, int MovieYear)
    {
        PosterText posterIcon = new PosterText(MovieName + " " + MovieYear);
        int w = posterIcon.getIconWidth();
        int h = posterIcon.getIconHeight();
        //Converts from an Icon to an image to return
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