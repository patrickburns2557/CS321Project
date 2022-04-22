import View.MainWindow;

import javax.swing.*;

public class RunProgram
{
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception ex)
        {
            //Do nothing because if it fails, will just fallback to default look
        }


        MainWindow view = MainWindow.getInstance();
        view.setVisible(true);
    }
}
