package widgets;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/** Demo: Umgang mit JTabbedPane (und JScrollPane) */
public class TabbedPaneDemo extends JPanel {
    private final JTabbedPane t;

    /** Erzeuge ein Demo-Panel */
    public TabbedPaneDemo() {
        super();

        setLayout(new FlowLayout());

        t = new JTabbedPane();
        add(t);

        setupTab1();
        setupTab2();
        setupTab3();
    }

    private void setupTab3() {
        JPanel scrollPanel = new JPanel();
        JTextArea text = new JTextArea(8, 26);
        JScrollPane scrollText = new JScrollPane(text);
        scrollPanel.add(scrollText);
        t.addTab("Tab 3", null, scrollPanel, "Scrollpanel");
    }

    private void setupTab2() {
        JPanel p = new JPanel();
        p.add(new JLabel("Eingabe: "));
        p.add(new JTextArea(1, 10));
        t.addTab("Tab 2", null, p, "Tooltip Tab 2");
    }

    private void setupTab1() {
        t.addTab("Tab 1", null, new JLabel("Label auf Tab1"), "Tooltip Tab 1");
    }
}
