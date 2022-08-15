package widgets;

import java.awt.FlowLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/** Demo: Umgang mit JOptionPane */
public final class DialogDemo extends JPanel {
    private static final Logger LOG = Logger.getLogger(DialogDemo.class.getName());
    private final JButton b1;
    private final JButton b2;
    private final JButton b3;
    private final String path =
            "https://raw.githubusercontent.com/Programmiermethoden/PM-Lecture/master/static/images/logo.png";

    /** Erzeuge ein Demo-Panel */
    public DialogDemo() {
        super();

        setLayout(new FlowLayout());

        // Dummy-Buttons to show dialogs
        b1 = new JButton("Simple Dialog");
        b2 = new JButton("Default Dialog w/ Warning");
        b3 = new JButton("Dialog w/ Options");
        add(b1);
        add(b2);
        add(b3);
        setupListener();
    }

    private void setupListener() {
        b1.addActionListener(e -> JOptionPane.showMessageDialog(this, "Default-Dialog"));
        b2.addActionListener(
                e ->
                        JOptionPane.showMessageDialog(
                                this,
                                "Krasse Warnung!",
                                "Das ist mein Titel",
                                JOptionPane.WARNING_MESSAGE));
        b3.addActionListener(
                e -> {
                    Object[] options = {"JA", "NEIN", "Weiss nicht"};
                    URL url = null;
                    try {
                        url = new URL(path);
                    } catch (MalformedURLException ex) {
                        throw new RuntimeException(ex);
                    }
                    int n =
                            JOptionPane.showOptionDialog(
                                    this,
                                    "Wuppie? Fluppie?",
                                    "Title goes here",
                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    new ImageIcon(url), // custom icon :)
                                    options,
                                    options[2]);
                    LOG.info("Option ausgewählt: " + n);
                });
    }
}
