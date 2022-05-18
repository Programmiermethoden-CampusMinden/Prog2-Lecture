package widgets;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/** Demo: Umgang mit JRadioButton (und JCheckBox) */
public class RadioButtonDemo extends JPanel {
    private final JRadioButton b1;
    private final JRadioButton b2;
    private final JRadioButton b3;
    private final JCheckBox b4;
    private final JCheckBox b5;
    private final ButtonGroup radioGroup;
    private static final Logger LOG = Logger.getLogger(RadioButtonDemo.class.getName());

    /** Erzeuge ein Demo-Panel */
    public RadioButtonDemo() {
        super();

        setLayout(new FlowLayout());

        b1 = new JRadioButton("Button 1", true);
        b2 = new JRadioButton("Button 2", false);
        b3 = new JRadioButton("Button 3", false);
        b4 = new JCheckBox("Button 4", false);
        b5 = new JCheckBox("Button 5", false);
        radioGroup = new ButtonGroup();

        setupRadioButtons();
        setupCheckBoxes();
        setupRadioGroup();
    }

    private void setupRadioButtons() {
        add(b1);
        add(b2);
        add(b3);
        b1.addItemListener(new Handler("Button 1"));
        b2.addItemListener(new Handler("Button 2"));
        b3.addItemListener(new Handler("Button 3"));
    }

    private void setupCheckBoxes() {
        add(b4);
        add(b5);
        b4.addItemListener(new Handler("Button 4"));
        b5.addItemListener(new Handler("Button 5"));
    }

    private void setupRadioGroup() {
        // mache Radio-Buttons voneinander abhängig
        // ButtonGroup: es kann immer nur einer aktiviert werden

        radioGroup.add(b1);
        radioGroup.add(b2);
        radioGroup.add(b3);
        // radioGroup.add(b4);
        // radioGroup.add(b5);
    }

    /** @param s Referenz auf Text-Widget, welches in actionPerformed() verändert wird */
    private record Handler(String s) implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            LOG.info("Button: '" + s + "', Item: " + e.getItem());
        }
    }
}
