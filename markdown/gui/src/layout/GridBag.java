package layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/** Demo: Umgang mit dem GridBagLayout */
public final class GridBag {
    /** Erzeuge ein Panel mit dem GridBagLayout */
    public static JPanel newGridBag() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.weightx = 0.0;
        c1.weighty = 0.0;
        contentPane.add(new JButton("Label 1"), c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 1;
        c2.gridy = 0;
        c2.fill = GridBagConstraints.VERTICAL;
        c2.weightx = 0.5;
        c2.weighty = 0.5;
        contentPane.add(new JButton("Label 2"), c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 1;
        c3.gridheight = 2;
        c3.fill = GridBagConstraints.BOTH;
        c3.weightx = 0.0;
        c3.weighty = 0.0;
        contentPane.add(new JButton("Label 3"), c3);

        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 1;
        c4.gridy = 1;
        c4.fill = GridBagConstraints.HORIZONTAL;
        c4.weightx = 1.0;
        c4.weighty = 0.5;
        contentPane.add(new JButton("Label 4"), c4);

        return contentPane;
    }
}
