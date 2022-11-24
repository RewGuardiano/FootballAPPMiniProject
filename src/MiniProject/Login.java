package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Login extends JFrame {
    private JPanel JPHeader;
    private JLabel JLLoginTitle;
    private JPanel Panel2;
    private JTextField TxtFieldTnumber;
    private JLabel JLTnumber;
    private JLabel JLPassword;
    private JButton loginButton;
    private JPasswordField passwordFieldLogin;

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
                String TNumber=TxtFieldTnumber.getText().toString();
                String password= String.valueOf(passwordFieldLogin.getPassword());

                    if((TNumber.length() != 9) || (TNumber.charAt(0) != 'T') || (TNumber.charAt(0) != 't')){
                        JOptionPane.showMessageDialog(null,"Invalid Login Details");
                        return;
                    }
                    if(password.equals("")) {
                        JOptionPane.showMessageDialog(null,"Invalid Login Details");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Welcome to the System","Welcome",JOptionPane.INFORMATION_MESSAGE);
                            new FootballApp();
                            dispose();
                    }
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
