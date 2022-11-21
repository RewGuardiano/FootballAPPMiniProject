package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SetCategory extends JFrame {


    private JPanel Panel2;
    private JTextField TextFieldCatCode;
    private JLabel JLTicketCode;
    private JTextField TxtFieldDescription;
    private JTextField TxtFieldPrice;
    private JButton btnSumbit;
    private JComboBox CobTicketCode;
    private JLabel JLPrice;
    private JLabel JLDescription;
    private JTextField TxtFieldTicketCode;
    private JTextField TxtFieldEmail;
    private JLabel JLEmail;
    private JLabel JLName;
    private JTextField TxtFieldName;

    public SetCategory(){

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
                String Tname = TxtFieldEmail.getText().toString();
                String Email = TxtFieldEmail.getText().toString();
                String TCode = TxtFieldTicketCode.getText().toString();
                String Descript = TxtFieldDescription.getText().toString();
                String Rate = TxtFieldPrice.getText().toString();




                if(Tname.equals("")){
                    JOptionPane.showMessageDialog(null,"Invalid,Re-enter your name");
                }
                if(Email.equals("")){
                    JOptionPane.showMessageDialog(null,"Invalid,Re-enter Email Address");
                }
                if(TCode.equals("")){
                    JOptionPane.showMessageDialog(null,"Invalid,Please re-enter a Category");
                }
                if(Descript.equals("")){
                    JOptionPane.showMessageDialog(null,"Invalid,Please re-enter the description of Ticket type");
                }
                if(Rate.equals("")){
                    JOptionPane.showMessageDialog(null,"Invalid,Please re-enter the rate of the ticket");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Registration Complete");
                }

            }
        });
        TxtFieldDescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }





    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
