package widgets;

import java.awt.FlowLayout;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Dialog {
    public static void main(String[] args) {
        final Logger log = Logger.getLogger(Dialog.class.getName());

        JFrame frame = new JFrame("Dialog Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());

        // Dummy-Buttons to show dialogs
        JButton b1 = new JButton("Simple Dialog");
        JButton b2 = new JButton("Default Dialog w/ Warning");
        JButton b3 = new JButton("Dialog w/ Options");
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);

        // Dialoge über die Listeners
        b1.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Default-Dialog"));
        b2.addActionListener(
                e ->
                        JOptionPane.showMessageDialog(
                                frame,
                                "Krasse Warnung!",
                                "Das ist mein Titel",
                                JOptionPane.WARNING_MESSAGE));
        b3.addActionListener(
                e -> {
                    Object[] options = {"JA", "NEIN", "Weiss nicht"};
                    int n =
                            JOptionPane.showOptionDialog(
                                    frame,
                                    "Wuppie? Fluppie?",
                                    "Title goes here",
                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    new ImageIcon(
                                            Dialog.class.getResource("icon.png")), // custom icon :)
                                    options,
                                    options[2]);
                    log.info("Option ausgewählt: " + n);
                });

        frame.add(contentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
