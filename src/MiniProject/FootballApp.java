package MiniProject;

import javax.swing.*;
import java.util.Objects;

//https://www.youtube.com/watch?v=vZfVwMCAN7Y// //Youtube video to help learn formatting of gui//
public class FootballApp extends JFrame {
    private JPanel Panel1;
    private JComboBox cobManageTicket;
    private JLabel JLTitle;
    private JLabel JLViewAvailability;
    private JLabel JLManageTicket;
    private JLabel JLICON;
    private JButton BtnViewAvailabitlity;

    public FootballApp() {
        setTitle("Football Bookings System");
        setSize(500, 350);
        setContentPane(Panel1);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("football.png"))).getImage());


    }
    public static void main(String[]args){
        FootballApp Gui = new FootballApp();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


