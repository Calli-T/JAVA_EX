import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class SW_EX extends JFrame {
    public SW_EX() {
        setTitle("300*300 JFrame");
        setSize(300,200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new Button("ADD"));
        contentPane.add(new Button("SUB"));
        contentPane.add(new Button("DIV"));

        setVisible(true);
    }

    public static void main(String[] args) {
        new SW_EX();
    }
}
