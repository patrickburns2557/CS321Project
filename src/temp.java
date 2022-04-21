import Model.Movie;
import View.MainWindow;

import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class temp
{
    public static void main(String[] args)
    {
        MainWindow view = MainWindow.getInstance();
        view.setVisible(true);

        Model.System.getInstance().loginUser("admin", "password");

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();

        //for(String f : fonts)
        //    System.out.println(f);
    }
}
