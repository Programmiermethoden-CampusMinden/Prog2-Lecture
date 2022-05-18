package events;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/** Demo: Umgang mit mehreren Listenern/Observables */
public class ListenerPanel extends JPanel {
    private JTextArea singleText;
    private JTextArea multiText;
    private JButton singleButton;
    private JButton multiButton;

    /** Erzeuge ein Listener-Panel */
    public ListenerPanel() {
        super(new GridLayout(0, 2));

        setupTextFields();
        setupButtons();
        setupListeners();
    }

    private void setupTextFields() {
        // Ausgabefeld für den Single-Listener
        singleText = new JTextArea(5, 10);
        singleText.setBorder(BorderFactory.createLineBorder(Color.black));
        add(singleText);

        // Ausgabefeld für den Multi-Listener
        multiText = new JTextArea(5, 10);
        multiText.setBorder(BorderFactory.createLineBorder(Color.black));
        add(multiText);
    }

    private void setupButtons() {
        singleButton = new JButton("single listener");
        add(singleButton);

        multiButton = new JButton("multi listener");
        add(multiButton);
    }

    private void setupListeners() {
        // ein Listener kann bei mehreren Observables registriert werden
        Handler single = new Handler(singleText);
        singleButton.addActionListener(single);
        multiButton.addActionListener(single);

        // ein Observable kann mehrere Listener bedienen
        Handler m1 = new Handler(multiText);
        Handler m2 = new Handler(multiText);
        multiButton.addActionListener(m1);
        multiButton.addActionListener(m2);
    }

    private void createTextArea(JTextArea area) {
        area = new JTextArea(5, 10);
        area.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private static class Handler implements ActionListener {
        private final JTextArea
                t; // Referenz auf Text-Widget, welches in actionPerformed() verändert wird

        public Handler(JTextArea t) {
            this.t = t;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            t.append(e.getActionCommand() + "\n");
        }
    }
}
