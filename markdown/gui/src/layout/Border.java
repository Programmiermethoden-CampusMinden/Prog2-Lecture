package layout;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/** Demo: Umgang mit dem BorderLayout */
public final class Border {
    /** Erzeuge ein Panel mit dem BorderLayout */
    public static JPanel newBorder() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        contentPane.add(new JButton("North"), BorderLayout.NORTH);
        contentPane.add(new JButton("West"), BorderLayout.WEST);
        contentPane.add(new JButton("Center"), BorderLayout.CENTER);
        contentPane.add(new JButton("East"), BorderLayout.EAST);
        contentPane.add(new JButton("South"), BorderLayout.SOUTH);

        return contentPane;
    }
}
