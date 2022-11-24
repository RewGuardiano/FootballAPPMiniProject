package MiniProject;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import static javax.swing.JOptionPane.*;

//https://www.youtube.com/watch?v=vZfVwMCAN7Y// //Youtube video to help learn formatting of gui//
public class FootballApp extends JFrame {
    private JPanel Panel1;
    private JComboBox cobManageTicket;
    private JLabel JLTitle;
    private JLabel JLViewSales;
    private JLabel JLManageTicket;
    private JLabel JLICON;
    private JButton BtnViewSales;
    private JButton saveDataButton;
    private JButton btnX;

    ArrayList<Ticket> Tickets = new ArrayList<>();
    public Ticket ticket;

    public FootballApp() {
        setTitle("Football Bookings System");
        setSize(500, 350);
        setContentPane(Panel1);
        setLocationRelativeTo(null);
        setResizable(false);

        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("football.png"))).getImage());



        cobManageTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Objects.equals(cobManageTicket.getSelectedItem(), "Set Ticket")) {
                    createSetTicketMenu();
                }
                if (Objects.equals(cobManageTicket.getSelectedItem(), "Remove Ticket")) {
                    createRemoveTicketMenu();
                }
                if (Objects.equals(cobManageTicket.getSelectedItem(), "View Ticket")) {
                   createViewTicket();
                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        BtnViewSales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int sum =0;
               double tax = 0.0725;

                JComboBox<String> TicketDetails= new JComboBox<>();
                JTextArea output = new JTextArea();

                output.setText("Total Sales:\n\n");

                if(Tickets.size() < 1) {
                    JOptionPane.showMessageDialog(null,"No Tickets are added to the system yet. ","Warning",JOptionPane.WARNING_MESSAGE);
                }
                else{

                }


            }
        });
    }


    private void createSetTicketMenu() {
        final String[] TicketList = {"A", "B", "C"};
        String Name;
        String Email;
        String Category;
        String Description;
        double Price;

        Category = (String) showInputDialog(null, "Ticket Category", "Category", QUESTION_MESSAGE, null, TicketList, TicketList[0]);


        Name = showInputDialog("Enter your name: ");
        if (Name.equals("")) {
            showMessageDialog(null, "Invalid! ,Please Re-enter");
            showInputDialog("Enter your name: ");
        }
        Email = showInputDialog("Enter you Email Address");
        if (Email.startsWith("@") || !Email.contains("@") && !Email.endsWith(".com") || !Email.endsWith(".ie")) {
            showMessageDialog(null, "Invalid Email Address! , Please Re-enter");
              showInputDialog("Enter you Email Address");
        }
        Description = showInputDialog("Enter the ticket Seat Description: ");

        if (Description.equals("")) {
            showMessageDialog(null, "Invalid Ticket Description! ,Please Re-enter");
            showInputDialog("Enter the ticket Seat Description: ");
        }

        Price = Double.parseDouble(showInputDialog("Enter the Ticket's Price"));
        if (Price==0) {
            showMessageDialog(null, "Invalid Ticket Rate! ,Please Re-enter");
            showInputDialog("Enter the Ticket's Price");
        }
        else {
            showMessageDialog(null, "Ticket with the name  " + Name + "  is added to the system");
        }

        ticket = new Ticket(Name, Email, Category, Description, Price);
        Tickets.add(ticket);


    }
    private void createRemoveTicketMenu() {
        JComboBox<String>TicketList = new JComboBox<String>();

        for(Ticket t: Tickets){
            TicketList.addItem(t.getName());

        }
        JOptionPane.showMessageDialog(null,"Select Ticket to be removed","Remove Ticket",JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,TicketList,"Remove Cuisine",JOptionPane.INFORMATION_MESSAGE);

        int SelectedTicket= TicketList.getSelectedIndex();

        TicketList.remove(SelectedTicket);

        JOptionPane.showMessageDialog(null,"Ticket Removed","Removed",JOptionPane.INFORMATION_MESSAGE);

    }
    private void createViewTicket() {
        JComboBox<String> TicketDetails= new JComboBox<>();
        JTextArea output = new JTextArea();

        output.setText("Ticket Details:\n\n");


        if(Tickets.size() < 1) {
            JOptionPane.showMessageDialog(null,"No Tickets are added to the system yet. ","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else {

            for (Ticket Details: Tickets) {
                TicketDetails.addItem(Details.getName() + "\n");
            }

            JOptionPane.showMessageDialog(null,TicketDetails,"Select Ticket to view details",JOptionPane.PLAIN_MESSAGE);

            int SelectedTicket = TicketDetails.getSelectedIndex();
            output.append(Tickets.get(SelectedTicket).toString());
            JOptionPane.showMessageDialog(null,output,"Ticket Details",JOptionPane.PLAIN_MESSAGE);
        }
    }


    public static void main(String[]args){
        FootballApp Gui = new FootballApp();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}




