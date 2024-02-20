package widgets;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

/** Demo: Umgang mit JTabbedPane (und JScrollPane) */
public final class PopupDemo extends JPanel {
    private final JRadioButtonMenuItem blue;
    private final JRadioButtonMenuItem red;
    private final JRadioButtonMenuItem green;
    private final ButtonGroup radioGroup;
    private final JPopupMenu contextMenu;

    /**
     * Erzeuge ein Demo-Panel
     *
     * <p>Fenster ist zunächst grau, mit rechter Maus bekommt man Auswahlmenü ...
     */
    public PopupDemo() {
        super();

        setLayout(new FlowLayout());
        setBackground(Color.WHITE);

        blue = new JRadioButtonMenuItem("Blau");
        red = new JRadioButtonMenuItem("Rot");
        green = new JRadioButtonMenuItem("Gruen");

        radioGroup = new ButtonGroup();

        contextMenu = new JPopupMenu();

        setupKontextMenu();

        addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.isPopupTrigger()) {
                            contextMenu.show(e.getComponent(), e.getX(), e.getY());
                        }
                    }
                });
    }

    private void setupKontextMenu() {
        // Buttons schalten Hintergrundfarbe um
        blue.addActionListener(e -> setBackground(Color.BLUE));
        red.addActionListener(e -> setBackground(Color.RED));
        green.addActionListener(e -> setBackground(Color.GREEN));

        // Es kann immer nur ein (Radio-) Button ausgewählt werden
        radioGroup.add(blue);
        radioGroup.add(red);
        radioGroup.add(green);

        // Zeige alle (Radio-) Buttons im Kontextmenü
        contextMenu.add(blue);
        contextMenu.add(red);
        contextMenu.add(green);
    }
}
