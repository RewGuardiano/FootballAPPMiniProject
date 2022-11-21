package MiniProject;

import javax.swing.*;
import java.util.Objects;

public class ViewSales extends JFrame {
    private JPanel Panel4;

    public ViewSales(){
        setTitle("View Sales");
        setSize(500, 450);
        setContentPane(Panel4);
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
