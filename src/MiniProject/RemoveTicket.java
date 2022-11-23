package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class RemoveTicket extends JFrame {
    private JPanel Panel3;
    private JComboBox CobRemove;
    private JButton btnBack3;


    public RemoveTicket(){
        setTitle("Remove Ticket");
        setSize(400, 350);
        setContentPane(Panel3);
        setVisible(true);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("football.png"))).getImage());

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        CobRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        btnBack3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FootballApp();
                setVisible(false);
            }
        });
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
