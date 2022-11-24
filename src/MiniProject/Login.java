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
                boolean valid = false;

                    for(int i=1;i<TNumber.length();i++)
                        if ((TNumber.length() == 9) || (TNumber.charAt(0) == 'T') || (TNumber.charAt(0) == 't') || (TNumber.charAt(i) >= '0') || (TNumber.charAt(i) >= '9') && !password.equals("")) {
                            valid = true;
                            break;
                        }
                    if(valid){
                        JOptionPane.showMessageDialog(null,"Welcome to the System","Welcome",JOptionPane.INFORMATION_MESSAGE);
                        new FootballApp();
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Invalid login details","Error",JOptionPane.ERROR_MESSAGE);
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
