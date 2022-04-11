package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.SwingConstants.RIGHT;

public class LoginWindow extends JPanel implements ActionListener {
    JFrame parent;
    JTextField username;
    JPasswordField password;

    public LoginWindow(JFrame parent) {
        this.parent = parent;
        this.setLayout(new GridLayout(2, 2, 3, 5));
        username = new JTextField();
        password = new JPasswordField();
        this.add(new JLabel("Username", RIGHT));
        this.add(username);
        this.add(new JLabel("Password", RIGHT));
        this.add(password);
    }

    public void actionPerformed(ActionEvent e) {
        int result = JOptionPane.showOptionDialog(
                parent,
                this,
                "Login",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[] {"Ok", "Sign-Up", "Cancel"},
                "Ok");
        switch (result) {
            case 0:
                // Yes
                // Log in with username and password
                break;
            case 1:
                // Sign-Up
                this.setLayout(new GridLayout(3, 2, 3, 5));
                this.add(new JLabel("Confirm Password", RIGHT));
                this.add(new JPasswordField());
                int signUpResult = JOptionPane.showConfirmDialog(
                        parent,
                        this,
                        "Sign-Up",
                        JOptionPane.OK_CANCEL_OPTION);
                if (signUpResult == JOptionPane.OK_OPTION) {

                }
                break;
            case 2:
                // Cancel
                break;
        }
    }

}
