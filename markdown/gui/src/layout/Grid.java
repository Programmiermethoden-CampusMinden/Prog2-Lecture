package layout;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/** Demo: Umgang mit dem GridLayout */
public final class Grid {
    /** Erzeuge ein Panel mit dem GridLayout */
    public static JPanel newGrid() {
        JPanel contentPane = new JPanel();
        GridLayout gl = new GridLayout(2, 3); // 0: any number of rows or columns

        contentPane.setLayout(gl);

        // gl.setHgap(20);
        // gl.setVgap(20);

        contentPane.add(new JButton("Label 1"));
        contentPane.add(new JButton("Label 2"));
        contentPane.add(new JButton("Label 3"));
        contentPane.add(new JButton("Label 4"));
        contentPane.add(new JButton("Label 5"));
        contentPane.add(new JButton("Label 6"));
        contentPane.add(new JButton("Label 7"));

        return contentPane;
    }
}
