package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Class to create an Icon based on the passed in text
 */
public class PosterText implements Icon
{
    private int width = 300;
    private int height = 444;
    String movieName;

    /**
     * Constructor to set the text to be shown on the poster
     * @param movieName
     */
    public PosterText(String movieName)
    {
        this.movieName = movieName;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D.Double background = new Rectangle2D.Double(x, y, width, height);

        g2.setColor(Color.BLACK);
        g2.fill(background);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Georgia", Font.BOLD, 22));
        g2.drawString(movieName, x+15, y+100);
    }

    @Override
    public int getIconWidth()
    {
        return width;
    }

    @Override
    public int getIconHeight()
    {
        return height;
    }
}
