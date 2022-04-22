package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.SwingConstants.RIGHT;

import Model.System;
import Model.User;

/**
 * Login popup that prompts the user to either login or signup
 */
public class LoginWindow extends JPanel implements ActionListener {
    JTextField username;
    JPasswordField password;
    Character[] specialCharacters = {'_', '?', '!', '@', '-', '&', '*', '+'};
    Character[] digitCharacters = {'0','1','2','3','4','5','6','7','8','9'};

    /**
     * Initializes the window
     */
    private void initialize() {
        this.removeAll();
        this.setLayout(new GridLayout(2, 2, 3, 5));
        username = new JTextField();
        password = new JPasswordField();
        this.add(new JLabel("Username", RIGHT));
        this.add(username);
        this.add(new JLabel("Password", RIGHT));
        this.add(password);
    }

    /**
     * Constructor for LoginWindow
     */
    public LoginWindow() {
        initialize();
    }

    /**
     * To be used in conjuction with a button that will pull up the window
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        initialize();

        MainWindow parent = MainWindow.getInstance();
        System system = System.getInstance();

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
                boolean loggedIn = system.loginUser(username.getText(), new String(password.getPassword()));
                if (!loggedIn)
                    JOptionPane.showMessageDialog(parent, "Invalid Username or Password");
                break;
            case 1:
                // Sign-Up
                this.setLayout(new GridLayout(4, 2, 3, 5));
                this.add(new JLabel("Confirm Password", RIGHT));
                JPasswordField confirmPassword = new JPasswordField();
                this.add(confirmPassword);
                JButton help = new JButton("Help");
                JPanel helpPanel = new JPanel();
                helpPanel.setLayout(new GridLayout(5, 1));
                helpPanel.add(new JLabel("Username length must be at least 3 characters", RIGHT));
                helpPanel.add(new JLabel("Password length must be at least 6 characters", RIGHT));
                helpPanel.add(new JLabel("Password must contain at least 1 number", RIGHT));
                helpPanel.add(new JLabel("Password must contain at least 1 special character", RIGHT));
                helpPanel.add(new JLabel("Special characters: ('_', '?', '!', '@', '-', '&', '*', '+')", RIGHT));
                help.addActionListener(event -> {
                    JOptionPane.showMessageDialog(parent, helpPanel);
                });
                this.add(help);

                int signUpResult = JOptionPane.showConfirmDialog(
                        parent,
                        this,
                        "Sign-Up",
                        JOptionPane.OK_CANCEL_OPTION);
                if (signUpResult == JOptionPane.OK_OPTION) {
                    String newUsername = username.getText();
                    String newPassword = new String(password.getPassword());
                    String newConfirmPassword = new String(confirmPassword.getPassword());

                    if (!newPassword.equals(newConfirmPassword)) {
                        JOptionPane.showMessageDialog(parent, "Passwords Don't Match");
                        break;
                    }

                    if (newUsername.length() < 3) {
                        JOptionPane.showMessageDialog(parent, "Username length must be at least 3 character");
                        break;
                    }

                    if (newPassword.length() < 6) {
                        JOptionPane.showMessageDialog(parent, "Password length must be at least 6 characters");
                        break;
                    }

                    boolean hasSpecialChar = false;
                    for (Character specialChar : specialCharacters) {
                        if (newPassword.contains(String.valueOf(specialChar))) {
                            hasSpecialChar = true;
                            break;
                        }
                    }
                    if (!hasSpecialChar) {
                        JOptionPane.showMessageDialog(parent, "Password doesn't have a special character ('_', '?', '!', '@', '-', '&', '*', '+')");
                        break;
                    }
                    boolean hasDigit = false;
                    for (Character digitChar : digitCharacters) {
                        if (newPassword.contains(String.valueOf(digitChar))) {
                            hasDigit = true;
                            break;
                        }
                    }
                    if (!hasDigit) {
                        JOptionPane.showMessageDialog(parent, "Password doesn't have at least one number");
                        break;
                    }

                    system.addUser(new User(newUsername, newPassword));
                    system.loginUser(newUsername, newPassword);
                }
                break;
            case 2:
                // Cancel
                break;
        }
    }

}
