package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Login extends JFrame {
    private JPanel JPHeader;
    private JLabel JLLoginTitle;
    private JPanel Panel2;
    private JTextField TxtFieldUsername;
    private JLabel JLUsername;
    private JLabel JLPassword;
    private JButton loginButton;
    private JPasswordField passwordFieldLogin;

    ArrayList<Login> LoginInfo = new ArrayList<>();
    public Login Logins;

    public Login() {
        setTitle("Login Form");
        setSize(600, 550);
        setContentPane(Panel2);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("user.png"))).getImage());


        setVisible(true);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = TxtFieldUsername.getText();
                String password= String.valueOf(passwordFieldLogin.getPassword());
            }
        });
    }

    public static void main(String[]args){
        Login Gui = new Login();
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
 }
