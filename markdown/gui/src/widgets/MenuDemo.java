package widgets;

import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/** Demo: Umgang mit JMenuBar (und JMenuItem) */
public final class MenuDemo {
    private static final Logger LOG = Logger.getLogger(MenuDemo.class.getName());

    /** Getter für den Frame: Der muss die MenuBar kennen und setzen */
    public static JMenuBar newMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setupMenu1(menuBar);
        setupMenu2(menuBar);

        return menuBar;
    }

    private static void setupMenu1(JMenuBar menuBar) {
        // Menü-Einträge
        JMenuItem m1 = new JMenuItem("Text: A");
        JMenuItem m2 = new JMenuItem("Text: B");
        JMenuItem m3 = new JMenuItem("Text: C");

        // Callbacks für Menü-Einträge
        m1.addActionListener(e -> LOG.info(e.getActionCommand()));
        m2.addActionListener(e -> LOG.info(e.getActionCommand()));
        m3.addActionListener(e -> LOG.info(e.getActionCommand()));

        // Menü 1
        JMenu menu1 = new JMenu("(M)ein Menü");
        menu1.add(m1);
        menu1.add(m2);
        menu1.add(m3);
        menuBar.add(menu1);
    }

    private static void setupMenu2(JMenuBar menuBar) {
        // Menü 2
        JMenu menu2 = new JMenu("Zweites Menü");
        menuBar.add(menu2);

        // Radio-Button 1 (Menü-Eintrag)
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem rb1 = new JRadioButtonMenuItem("erster Radio-Button");
        rb1.addActionListener(e -> LOG.info(e.getActionCommand()));
        group.add(rb1);
        menu2.add(rb1);

        // Radio-Button 1 (Menü-Eintrag)
        JRadioButtonMenuItem rb2 = new JRadioButtonMenuItem("zweiter Radio-Button");
        rb2.setSelected(true);
        rb2.addActionListener(e -> LOG.info(e.getActionCommand()));
        group.add(rb2);
        menu2.add(rb2);
    }
}
