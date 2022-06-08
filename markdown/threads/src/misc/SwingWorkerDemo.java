package misc;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/** Kleine Demo zum Einsatz von SwingWorker */
public class SwingWorkerDemo extends JFrame {
    JTextField in1;
    JTextField in2;
    JLabel erg1;
    JLabel erg2;

    /** Baue die Demo zusammen */
    public SwingWorkerDemo() {
        super("SwingWorker Demo");
        JTabbedPane t = new JTabbedPane();
        createBlockingPanel(t);
        createSwingWorkerPanel(t);
        add(t);
    }

    /** Starte die Demo */
    public static void main(String... args) {
        SwingWorkerDemo f = new SwingWorkerDemo();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 120);
        f.setVisible(true);
    }

    private void createBlockingPanel(JTabbedPane t) {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2, 5, 5));
        p1.add(new JLabel("Fibonacci for: "));
        in1 = new JTextField("0", 5);
        in1.setToolTipText("try 42 :-)");
        p1.add(in1);
        JButton b1 = new JButton("GO");
        b1.addActionListener(
                e -> erg1.setText("Ergebnis: " + fibonacci(Integer.parseInt(in1.getText()))));
        p1.add(b1);
        erg1 = new JLabel("");
        p1.add(erg1);
        t.addTab("Fibonacci", null, p1, "Fiboccizahlen ohne Thread");
    }

    private void createSwingWorkerPanel(JTabbedPane t) {
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 2, 5, 5));
        p2.add(new JLabel("Fibonacci for: "));
        in2 = new JTextField("0", 5);
        in2.setToolTipText("try 42 :-)");
        p2.add(in2);
        JButton b2 = new JButton("GO");
        b2.addActionListener(
                e -> {
                    SwingWorker<String, Object> task =
                            new SwingWorker<>() {
                                @Override
                                // Methode für langwierige Berechnung
                                protected String doInBackground() {
                                    erg2.setText("calculating ...");
                                    return "Ergebnis: "
                                            + fibonacci(Integer.parseInt(in2.getText()));
                                }

                                @Override
                                // Wird vom EDT nach Ende von doInBackground() aufgerufen
                                protected void done() {
                                    try {
                                        // get() holt Rückgabewert von doInBackground()
                                        erg2.setText(get());
                                    } catch (Exception e) {
                                        erg2.setText("Exception - Berechnung unterbrochen");
                                    }
                                }
                            };
                    // Starte neuen Thread und führe doInBackground() aus
                    task.execute();
                });
        p2.add(b2);
        erg2 = new JLabel("");
        p2.add(erg2);
        t.addTab("Tread-Fibonacci", null, p2, "Fiboccizahlen mit SwingWorker");
    }

    protected long fibonacci(long number) {
        return (number <= 1) ? number : fibonacci(number - 1) + fibonacci(number - 2);
    }
}
