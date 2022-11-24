package MiniProject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import static javax.swing.JOptionPane.*;

//https://www.youtube.com/watch?v=vZfVwMCAN7Y// //Youtube video to help learn formatting of gui//
public class FootballApp extends JFrame implements ActionListener{
    private JPanel Panel1;
    private JComboBox cobManageTicket;
    private JLabel JLTitle;
    private JLabel JLViewSales;
    private JLabel JLManageTicket;
    private JLabel JLICON;
    private JButton BtnViewSales;
    private JButton saveDataButton;


    ArrayList<Ticket> Tickets = new ArrayList<>();
    public Ticket ticket;

    public FootballApp() throws IOException {
        setTitle("Football Bookings System");
        setSize(550, 500);
        setContentPane(Panel1);
        setLocationRelativeTo(null);
        setResizable(false);

        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("football.png"))).getImage());

        SavaData();


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
               double sum =0;
               double highest = 0, lowest = 1000;
                JComboBox<Double>TicketList = new JComboBox<>();
                JTextArea textArea = new JTextArea();
                textArea.setFont(new Font("monospaced", Font.PLAIN,12));


                if(Tickets.size() < 1) {
                    JOptionPane.showMessageDialog(null,"No Tickets are added to the system yet. ","Warning",JOptionPane.WARNING_MESSAGE);
                }
                else {

                    for (Ticket t : Tickets) {
                        TicketList.addItem(t.getPrice());

                        sum += t.getPrice();

                        if(t.getPrice()>highest){
                            highest = t.getPrice();

                            if(t.getPrice()<lowest){
                                lowest = t.getPrice();
                            }
                        }


                    }

                     //Trying to display the most expensive ticket and the cheapest ticket//

                    textArea.append("The highest ticket price is: " + String.format("%.2f",highest) + "\nThe lowest ticket Price is: " + String.format("%.2f",lowest) + "\n\nThe total Price is: " + "EUR" + String.format("%.2f", sum));
                    JOptionPane.showMessageDialog(null,textArea, "Sales Analysis", INFORMATION_MESSAGE);

                }

            }
        });
        saveDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try{
                SavaData();
                JOptionPane.showMessageDialog(saveDataButton,"Users Data have been Saved");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            }
        });
    }

    public void SavaData() throws IOException {
        File f = new File("UserData.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(f));
        Object[] Lines = br.lines().toArray();
        int i =0;
        int id =0;
        for(i=0;i < Lines.length;i++){
            String Line = Lines[i].toString().trim();
            String[] Row = Line.split(",");
            id = Integer.parseInt(Row[0]);




        }
        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        pw.println(Tickets);
    }


    private void createSetTicketMenu() {
        final String[] TicketList = {"A", "B", "C"};
        String Name;
        String Email;
        String Category;
        String Description;
        double Price;
        boolean EmailValid = false;

        Category = (String) showInputDialog(null, "Ticket Category", "Category", QUESTION_MESSAGE, null, TicketList, TicketList[0]);


        Name = showInputDialog("Enter your name: ");
        if (Name.equals("")) {
            showMessageDialog(null, "Invalid! ,Please Re-enter");
            showInputDialog("Enter your name: ");
        }
        Email = showInputDialog("Enter you Email Address");
        while(!EmailValid) {
            if ((Email.startsWith("@") || (!Email.contains("@"))) && ((!Email.endsWith(".com")) || (!Email.endsWith(".ie")))) {
                showMessageDialog(null, "Invalid Email Address! , Please Re-enter");
                Email = showInputDialog("Enter you Email Address");
            } else {
                EmailValid = true;

            }
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
            showMessageDialog(null, "Ticket with the name " + Name.toUpperCase() + " is added to the system");
        }

        ticket = new Ticket(Name, Email, Category, Description, Price);
        Tickets.add(ticket);


    }
    private void createRemoveTicketMenu() {
        JComboBox<String>TicketList = new JComboBox<>();

        for(Ticket t: Tickets){
            TicketList.addItem(t.getEmail());

        }
        JOptionPane.showMessageDialog(null,"Select Ticket to be removed","Remove Ticket",JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,TicketList,"Remove Cuisine",JOptionPane.INFORMATION_MESSAGE);

        int SelectedTicket= TicketList.getSelectedIndex();

        Tickets.remove(SelectedTicket);

        JOptionPane.showMessageDialog(null,"Ticket Removed","Removed",JOptionPane.INFORMATION_MESSAGE);

    }
    private void createViewTicket() {
        JComboBox<String> TicketDetails= new JComboBox<>();
        JTextArea Displaybox = new JTextArea();

        Displaybox.setText("Ticket Details:\n\n");


        if(Tickets.size() < 1) {
            JOptionPane.showMessageDialog(null,"No Tickets are added to the system yet. ","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else {

            for (Ticket Details: Tickets) {
                TicketDetails.addItem(Details.getEmail() + "\n");
            }

            JOptionPane.showMessageDialog(null,TicketDetails,"Select Ticket to view details",JOptionPane.PLAIN_MESSAGE);

            int SelectedTicket = TicketDetails.getSelectedIndex();
            Displaybox.append(Tickets.get(SelectedTicket).toString());
            JOptionPane.showMessageDialog(null,Displaybox,"Ticket Details",JOptionPane.PLAIN_MESSAGE);
        }
    }


    public static void main(String[]args) throws IOException {
        FootballApp Gui = new FootballApp();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}




