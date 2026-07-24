package src.login;
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

public class LoginView extends JFrame
{
    private JPanel mainPanel;
    private JPanel leftPanel, rightPanel;
    private JLabel logo, restaurantName, description, usernameLabel, passwordLabel, loginTitle;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView()
    {
        mainPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel = new JPanel();
        logo = new JLabel();
        restaurantName = new JLabel();
        description = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        loginTitle = new JLabel();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton();
 
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 500));

        mainPanel.setBackground(new Color(255,255,255));
        mainPanel.setPreferredSize(new Dimension(800,500));
        mainPanel.setLayout(null);

        leftPanel.setBackground(new Color(0,102,102));
        leftPanel.setPreferredSize(new Dimension(400,500));

        ImageIcon imageIcon = new ImageIcon("./logo/logo.jpg");
        Image image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(newImg));

        restaurantName.setFont(new Font("Garamond", 1, 30));
        restaurantName.setForeground(new Color(255,255,255));
        restaurantName.setText("Sapori d'Italia");

        description.setFont(new Font("Segoe UI Light", 0, 14));
        description.setForeground(new Color(204,204,204));
        description.setText("Ordering Management System");

        GroupLayout leftLayout = new GroupLayout(leftPanel);
        leftPanel.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.CENTER, leftLayout.createSequentialGroup()
                .addGap(0, 90, Short.MAX_VALUE)
                .addComponent(description)
                .addGap(0, 81, Short.MAX_VALUE))
            .addGroup(leftLayout.createSequentialGroup()
                .addGroup(leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(restaurantName))
                    .addGroup(leftLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(logo)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(logo)
                .addGap(26, 26, 26)
                .addComponent(restaurantName)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(description)
                .addGap(78, 78, 78))
        );

        mainPanel.add(leftPanel);
        leftPanel.setBounds(0,0,400,500);

        rightPanel.setBackground(new Color(255,255,255));
        rightPanel.setMinimumSize(new Dimension(400,500));

        loginTitle.setFont(new Font("Segoe UI", 1, 36));
        loginTitle.setForeground(new Color(0,102,102));
        loginTitle.setText("LOGIN");
        
        usernameLabel.setFont(new Font("Segoe UI", 0, 14));
        usernameLabel.setBackground(new Color(102,102,102));
        usernameLabel.setText("Username");

        usernameField.setFont(new Font("Segoe UI", 0, 14));
        usernameField.setForeground(new Color(102,102,102));

        passwordLabel.setFont(new Font("Segoe UI", 0, 14));
        passwordLabel.setBackground(new Color(102,102,102));
        passwordLabel.setText("Password");

        loginButton.setFont(new Font("Segoe UI", 0, 14));
        loginButton.setForeground(new Color(255,255,255));
        loginButton.setBackground(new Color(0,102,102));
        loginButton.setText("Login");
        
        GroupLayout rightLayout = new GroupLayout(rightPanel);
        rightPanel.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addGroup(rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(rightLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(loginTitle))
                    .addGroup(rightLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(usernameLabel)
                                .addComponent(usernameField)
                                .addComponent(passwordLabel)
                                .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))))))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(loginTitle)
                .addGap(40, 40, 40)
                .addComponent(usernameLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        mainPanel.add(rightPanel);
        rightPanel.setBounds(400,0,400,500);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 149, Short.MAX_VALUE))
        );

        setResizable(false);
        pack();
        setVisible(true);
    }

    public String getUsername()
    {
        return usernameField.getText();
    }

    public String getPassword()
    {
        return new String(passwordField.getPassword());
    }

    public void addLoginButtonListener(ActionListener listener)
    {
        loginButton.addActionListener(listener);
    }

    public void displayErrorMessage(String errorMessage)
    {
        JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
