package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
                String Password = passwordFieldLogin.getText();
              try {
                  if(!Username.equals("") && !Password.equals("")) {
                      SaveData();
                      TxtFieldUsername.setText(null);
                      passwordFieldLogin.setText(null);
                      new FootballApp();
                      dispose();
                      JOptionPane.showMessageDialog(null, "Welcome to the System", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(null, "Please fill all Fields ", "Error",JOptionPane.ERROR_MESSAGE);
                  }
              } catch (IOException ex) {
                  throw new RuntimeException(ex);
              }
            }
        });
    }
   /***************************************************** *
   Title: Attempts in text file input * 
   Author: Code with AADI
   * Site: Youtube * 
   Date: 2020 * Code version: Nov 24 2020 
   Availability: https://www.youtube.com/watch?v=typQHNak0Tk&t=1380s (Accessed 24 Nov 2022) * 
   *****************************************************/ 
    public void SaveData() throws IOException {
        File f = new File("UsersLoginData.txt");
        if (!f.exists()) {
            f.createNewFile();

            BufferedReader br = new BufferedReader(new FileReader(f));
            Object[] Lines = br.lines().toArray();
            int i = 0;
            int id = 0;
            for (i = 0; i < Lines.length; i++) {
                String Line = Lines[i].toString().trim();
                String[] Row = Line.split(",");
                id = Integer.parseInt(Row[0]) + 1;


            }
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(TxtFieldUsername.getText() + "," + passwordFieldLogin.getText());
            pw.flush();
            pw.close();
        }
    }

    public static void main(String[]args){
        Login Gui = new Login();

    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
 }
