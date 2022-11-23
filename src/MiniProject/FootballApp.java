package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

//https://www.youtube.com/watch?v=vZfVwMCAN7Y// //Youtube video to help learn formatting of gui//
public class FootballApp extends JFrame {
    private JPanel Panel1;
    private JComboBox cobManageTicket;
    private JLabel JLTitle;
    private JLabel JLViewSales;
    private JLabel JLManageTicket;
    private JLabel JLICON;
    private JButton BtnViewAvailabitlity;
    ArrayList<Ticket> Tickets = new ArrayList<>();
    public Ticket ticket;

    public FootballApp() {
        setTitle("Football Bookings System");
        setSize(500, 350);
        setContentPane(Panel1);
        setResizable(false);
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

                if (Objects.equals(cobManageTicket.getSelectedItem(), "Set Ticket")) {
                    createSetTicketMenu();
                }
                if (Objects.equals(cobManageTicket.getSelectedItem(), "Remove Ticket")){
                    new RemoveTicket();
                dispose();
            }
                if(Objects.equals(cobManageTicket.getSelectedItem(), "View Ticket")) {
                    new ViewTicket();
                    dispose();
                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createSetTicketMenu() {
     final String [] TicketList = {"A","B","C"};
     String Name;
     String Category;
     String Description;
     Double Price;

     Category = (String) JOptionPane.showInputDialog(null,"Ticket Category","Category",JOptionPane.QUESTION_MESSAGE,null,TicketList,TicketList[0]);

     Name = JOptionPane.showInputDialog("Enter your name: ");
     Description = JOptionPane.showInputDialog("Enter the ticket Seat Description: ");

     Price = Double.parseDouble(JOptionPane.showInputDialog("Enter the Ticket's Price"));

        ticket = new Ticket(Name,Category,Description,Price);
        Tickets.add(ticket);



    }

    public static void main(String[]args){
        FootballApp Gui = new FootballApp();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


}


