package widgets;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

/** Demo: Umgang mit JFileChooser (und FileFilter) */
public final class FileChooserDemo extends JPanel {
    private final JButton button;
    private static final Logger LOG = Logger.getLogger(FileChooserDemo.class.getName());

    /** Erzeuge ein Demo-Panel */
    public FileChooserDemo() {
        super();

        setLayout(new FlowLayout());

        // Dummy-Button to show FileChooser
        button = new JButton("Show FileChooser Dialog");
        add(button);

        // FileChooser-Dialog über den Listener
        button.addActionListener(new MyActionListener(this));
    }

    private static class MyActionListener implements ActionListener {
        private final FileChooserDemo parent;

        /** Erzeuge einen neuen FileChooser mit Referenz auf eine Eltern-Komponente */
        public MyActionListener(FileChooserDemo parent) {
            this.parent = parent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser(); // Startverzeichnis als Parameter möglich
            // fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            // fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            // fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            // Filter, der PDF-Dateien auswählen lässt
            fc.setFileFilter(new PdfFileFilter());

            // Öffne FileChooser-Dialog
            int returnVal = fc.showOpenDialog(parent); // modaler Dialog

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                LOG.info("Datei ausgewählt: " + fc.getSelectedFile().toString());
            } else {
                LOG.info("Keine Datei ausgewählt");
            }
        }
    }

    private static class PdfFileFilter extends FileFilter {
        @Override
        public boolean accept(File f) {
            return f.getName().endsWith(".pdf");
        }

        @Override
        public String getDescription() {
            return ".pdf";
        }
    }
}
