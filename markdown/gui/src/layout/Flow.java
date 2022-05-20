package layout;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/** Demo: Umgang mit dem FlowLayout */
public final class Flow {
    /** Erzeuge ein Panel mit dem FlowLayout */
    public static JPanel newFlow() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JButton("Label 1"));
        contentPane.add(new JButton("Label 2"));
        contentPane.add(new JButton("Label 3"));
        contentPane.add(new JButton("Label 4"));
        contentPane.add(new JButton("Label 5"));
        contentPane.add(new JButton("Label 6"));

        return contentPane;
    }
}
