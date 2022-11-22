package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SetTicket extends JFrame {


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
    private JButton btnClear;

    public SetTicket(){

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
                String Rate = TxtFieldPrice.getText().toString();




                if(Tname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Invalid! ,Please Re-enter");
                    return;
                }
                if(!Email.contains("@")||!Email.endsWith(".com")&&!Email.endsWith(".ie")){
                    JOptionPane.showMessageDialog(null, "Invalid Email Address! , Please Re-enter");
                    return;
                }
                if(TCode.length()!=1 || TCode.charAt(0)>='D' && TCode.charAt(0)<='Z' || TCode.charAt(0)>='d' && TCode.charAt(0)<='z' ){
                    JOptionPane.showMessageDialog(null,"Invalid Category Code! , Must be Category A, B or C");
                        return;
                }
                if(Descript.equals("")){
                    JOptionPane.showMessageDialog(null,"Invalid Ticket Description! ,Please Re-enter");
                    return;
                }
                if(Rate.equals("")){
                    JOptionPane.showMessageDialog(null,"Invalid! ,Please re-enter the rate of the ticket");
                    return;
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
    }





    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
