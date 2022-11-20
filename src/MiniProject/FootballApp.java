package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


        BtnViewAvailabitlity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BtnViewAvailabitlity.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                    }
                });
            }
        });


        cobManageTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Objects.equals(cobManageTicket.getSelectedItem(), "Set Ticket"))

                    new SetCategory();    //learned from yt video, https://www.youtube.com/watch?v=sEWcNtbqC0Y//
                dispose();
                if(Objects.equals(cobManageTicket.getSelectedItem(), "Remove Ticket"))
                    new RemoveTicket();
                dispose();
                if(Objects.equals(cobManageTicket.getSelectedItem(), "View Ticket"))
                    new ViewTicket();
                dispose();
            }
        });
    }
    public static void main(String[]args){
        FootballApp Gui = new FootballApp();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


