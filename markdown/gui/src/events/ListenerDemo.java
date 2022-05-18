package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/** Demo: Umgang mit mehreren Listenern/Observables */
public class ListenerDemo extends JPanel {
    private final JButton singleButton;
    private final JButton multiButton;
    private static final Logger LOG = Logger.getLogger(ListenerDemo.class.getName());

    /** Erzeuge ein Listener-Panel */
    public ListenerDemo() {
        super();

        singleButton = new JButton("single listener");
        add(singleButton);
        multiButton = new JButton("multi listener");
        add(multiButton);

        registerSameListenerWithMultipleObservables();
        registerMultipleListenersWithSameObservable();
    }

    private void registerSameListenerWithMultipleObservables() {
        // ein Listener kann bei mehreren Observables registriert werden
        Handler single = new Handler("Wuppie");
        singleButton.addActionListener(single);
        multiButton.addActionListener(single);
    }

    private void registerMultipleListenersWithSameObservable() {
        // ein Observable kann mehrere Listener bedienen
        multiButton.addActionListener(new Handler("Foo"));
        multiButton.addActionListener(new Handler("Bar"));
    }

    /** @param s Referenz auf Text-Widget, welches in actionPerformed() verändert wird */
    private record Handler(String s) implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LOG.info("Button: '" + e.getActionCommand() + "', Handler: '" + s + "'");
        }
    }
}
