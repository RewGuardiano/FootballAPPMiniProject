package MiniProject;

import javax.swing.*;
import java.util.Objects;

public class RemoveTicket extends JFrame {
    private JPanel Panel3;


    public RemoveTicket(){
        setTitle("Remove Ticket");
        setSize(500, 450);
        setContentPane(Panel3);
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
