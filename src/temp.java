import View.MainWindow;

import java.awt.*;

public class temp
{
    public static void main(String[] args)
    {
        System.out.println("temp");
        System.out.println("temp2");
        MainWindow view = new MainWindow();
        view.setVisible(true);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();

        for(String f : fonts)
            System.out.println(f);
    }
}
