package layout;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/** Demo: Umgang mit dem BorderLayout */
public final class Border {
    /** Erzeuge ein Panel mit dem BorderLayout */
    public static JPanel newBorder() {
        JPanel contentPane = new JPanel();
        BorderLayout bl = new BorderLayout();

        contentPane.setLayout(bl);

        contentPane.add(new JButton("North"), BorderLayout.NORTH); // also: PAGE_START
        contentPane.add(new JButton("West"), BorderLayout.WEST); // also: LINE_START
        contentPane.add(new JButton("Center"), BorderLayout.CENTER);
        contentPane.add(new JButton("East"), BorderLayout.EAST); // also: LINE_END
        contentPane.add(new JButton("South"), BorderLayout.SOUTH); // also: PAGE_END

        // bl.setHgap(20); // setze horizontalen Abstand zw. Komponenten
        // bl.setVgap(20); // setze vertikalen Abstand zw. Komponenten

        return contentPane;
    }
}
