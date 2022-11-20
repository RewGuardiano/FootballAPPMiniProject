package MiniProject;

import javax.swing.*;
import java.util.Objects;

public class SetCategory extends JFrame {


    private JPanel Panel2;
    private JTextField TextFieldCatCode;
    private JLabel JLTicketCode;
    private JTextField textField1;
    private JTextField textField2;
    private JButton btnSumbit;

    public SetCategory(){

        setTitle("Set Ticket");
        setSize(500, 450);
        setContentPane(Panel2);
        setVisible(true);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("football.png"))).getImage());

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
