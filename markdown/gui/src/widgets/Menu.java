package widgets;

import java.awt.FlowLayout;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;

public class Menu {
    public static void main(String[] args) {
        final Logger log = Logger.getLogger(Menu.class.getName());

        JFrame frame = new JFrame("Menu Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar); // Die Menüleiste gehört zum Frame, nicht zum Panel!

        JMenu menu1 = new JMenu("(M)ein Menü");
        menuBar.add(menu1);

        JMenuItem m1 = new JMenuItem("Text: A");
        JMenuItem m2 = new JMenuItem("Text: B");
        JMenuItem m3 = new JMenuItem("Text: C");
        m1.addActionListener(e -> log.info(e.getActionCommand()));
        m2.addActionListener(e -> log.info(e.getActionCommand()));
        m3.addActionListener(e -> log.info(e.getActionCommand()));
        menu1.add(m1);
        menu1.add(m2);
        menu1.add(m3);

        JMenu menu2 = new JMenu("Zweites Menü");
        menuBar.add(menu2);

        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem rb1 = new JRadioButtonMenuItem("erster Radio-Button als Menü-Eintrag");
        rb1.addActionListener(e -> log.info(e.getActionCommand()));
        group.add(rb1);
        menu2.add(rb1);

        JRadioButtonMenuItem rb2 =
                new JRadioButtonMenuItem("zweiter Radio-Button als Menü-Eintrag");
        rb2.setSelected(true);
        rb2.addActionListener(e -> log.info(e.getActionCommand()));
        group.add(rb2);
        menu2.add(rb2);

        JTextArea t = new JTextArea(10, 20);
        contentPane.add(t);

        frame.add(contentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
