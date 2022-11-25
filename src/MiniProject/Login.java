package MiniProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
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
              try {
                  if(OpenData()==true) {
                      OpenData();
                      JOptionPane.showMessageDialog(null, "User login is Successfully ");
                        TxtFieldUsername.setText(null);
                        passwordFieldLogin.setText(null);
                      new FootballApp();
                      dispose();
                  }
                  else{
                        JOptionPane.showMessageDialog(null ,"Incorrect Credentials. Please Try Again!");

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
    * Site: YouTube *
    Date: 2020 * Code version: Nov 24 2020
    Availability: <a href="https://www.youtube.com/watch?v=typQHNak0Tk&t=1380s">...</a> (Accessed 24 Nov 2022) *
    *****************************************************/
    public void SaveData() throws IOException {

        //I tried my best with the
        ObjectOutputStream os2 =new ObjectOutputStream(new FileOutputStream("BookingTickets.data"));
        os2.writeObject(TxtFieldUsername.getText());
        os2.writeObject(passwordFieldLogin.getText());
        os2.close();

    }
    public boolean OpenData() throws IOException {
        try {


            File file = new File("BookingTicket.data");
            System.out.println("opening file");
            if (!file.exists()) {
                file.createNewFile();


                BufferedReader br = new BufferedReader(new FileReader(file));
                Object[] Lines = br.lines().toArray();
                int i = 0;
                int id = 0;
                for (i = 0; i < Lines.length; i++) {
                    String Line = Lines[i].toString().trim();
                    String[] Row = Line.split(",");
                    System.out.println(Arrays.toString(Row));
                    if(TxtFieldUsername.getText().equals(Row[1]) && passwordFieldLogin.getText().equals(Row[4])){
                        return true;
                    }
                    else{
                        return false;
                    }

                }

            }

        } //these individual catch clauses added by JB, replacing a single "Exception" catch clause
        catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null,"File not found","Error",JOptionPane.ERROR_MESSAGE);
            fnfe.printStackTrace();
        }
        catch (IOException ioe) {
            JOptionPane.showMessageDialog(null,"Problem reading from the file","Error",JOptionPane.ERROR_MESSAGE);
            ioe.printStackTrace();
        }

        return false;
    }

    public static void main(String[]args){
        Login Gui = new Login();

    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
 }
