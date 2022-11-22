package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class SetTicket extends JFrame implements Ticket {


    private JPanel Panel2;
    private JTextField TextFieldCatCode;
    private JLabel JLTicketCode;
    private JTextField TxtFieldDescription;
    private JTextField TxtFieldPrice;
    private JButton btnSumbit;
    private JLabel JLPrice;
    private JLabel JLDescription;
    private JTextField TxtFieldTicketCode;
    private JTextField TxtFieldEmail;
    private JLabel JLEmail;
    private JLabel JLName;
    private JTextField TxtFieldName;
    private JButton btnClear;
    private JButton btnBack;

    ArrayList<Ticket> Tickets = new ArrayList<Ticket>();
    private Ticket ticket;

    public SetTicket() {

        setTitle("Set Ticket");
        setSize(500, 450);
        setContentPane(Panel2);
        setVisible(true);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("football.png"))).getImage());

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        btnSumbit.addActionListener(new ActionListener() {//try to figure out how to save contents in set category in an arrayList once the submit button has been pressed//

            @Override
            public void actionPerformed(ActionEvent e) {
                String Tname = TxtFieldName.getText().toString();
                String Email = TxtFieldEmail.getText().toString();
                String TCode = TxtFieldTicketCode.getText().toString();
                String Descript = TxtFieldDescription.getText().toString();
                String Price = TxtFieldPrice.getText().toString();


                if (Tname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Invalid! ,Please Re-enter");
                    return;
                }
                if (Email.startsWith("@") || !Email.contains("@") && (!Email.endsWith(".com") || !Email.endsWith(".ie"))) {
                    JOptionPane.showMessageDialog(null, "Invalid Email Address! , Please Re-enter");
                    return;
                }
                if (TCode.length() != 1 || TCode.charAt(0) >= 'D' && TCode.charAt(0) <= 'Z' || TCode.charAt(0) >= 'd' && TCode.charAt(0) <= 'z') {
                    JOptionPane.showMessageDialog(null, "Invalid Category Code! , Must be Category A, B or C");
                    return;
                }
                if (Descript.equals("")) {
                    JOptionPane.showMessageDialog(null, "Invalid Ticket Description! ,Please Re-enter");
                    return;
                }
                if (!Character.isDigit(Price.length()) && (!Price.contains("."))){
                    JOptionPane.showMessageDialog(null, "Invalid Ticket Rate! ,Please Re-enter");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Registration Complete");

                }
                ticket = new Ticket(Tname, TCode, Descript,Price);
                Tickets.add(ticket);

                JOptionPane.showMessageDialog(null, "Username's " + Tname + " Ticket is added to the system");

            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TxtFieldName.setText(null);
                TxtFieldEmail.setText(null);
                TxtFieldTicketCode.setText(null);
                TxtFieldDescription.setText(null);
                TxtFieldPrice.setText(null);
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FootballApp();
                setVisible(false);
            }
        });
    }
}