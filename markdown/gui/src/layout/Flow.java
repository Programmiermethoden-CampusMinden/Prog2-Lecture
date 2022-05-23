package layout;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/** Demo: Umgang mit dem FlowLayout */
public final class Flow {
    /** Erzeuge ein Panel mit dem FlowLayout */
    public static JPanel newFlow() {
        JPanel contentPane = new JPanel();
        FlowLayout fl = new FlowLayout();

        contentPane.setLayout(fl);

        // fl.setHgap(20);
        // fl.setVgap(20);
        // fl.setAlignment(FlowLayout.LEFT);

        contentPane.add(new JButton("Label 1"));
        contentPane.add(new JButton("Label 2"));
        contentPane.add(new JButton("Label 3"));
        contentPane.add(new JButton("Label 4"));
        contentPane.add(new JButton("Label 5"));
        contentPane.add(new JButton("Label 6"));

        return contentPane;
    }
}
