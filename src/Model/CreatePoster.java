package Model;

import View.PosterText;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.Buffer;

public class CreatePoster
{
    public static Image getFromURL(String inputURL, String MovieName)
    {
        ImageIcon icon;
        //will want to test if the poster link isn't there
        try
        {
            URL url = new URL(inputURL);
            icon = new ImageIcon(url);
            return icon.getImage();
        }
        catch(Exception ex)
        {
            //If no poster image was found, create a blank poster with just the movie title
            PosterText posterIcon = new PosterText(MovieName);
            int w = posterIcon.getIconWidth();
            int h = posterIcon.getIconHeight();
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
}
