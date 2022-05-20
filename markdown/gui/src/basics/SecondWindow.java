package basics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Erzeuge ein Fenster mit einem Button, einem Label und einem festen Textfeld */
public final class SecondWindow {
    /** Erzeuge die Komponenten in neuem EDT-Job statt im main()-Tread */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {

                        JFrame frame = new JFrame("SecondWindow");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        JButton button = new JButton("Button");
                        button.setToolTipText("ich bin ein tool-tipp-text");

                        JLabel label = new JLabel("Label");

                        JTextField textField = new JTextField();
                        textField.setColumns(20);
                        textField.setEditable(false);

                        JPanel contentPane = new JPanel();
                        contentPane.add(button);
                        contentPane.add(label);
                        contentPane.add(textField);

                        frame.add(contentPane);

                        frame.pack();
                        frame.setVisible(true);
                    }
                });
    }
}
