package tables;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/** Demo: Umgang mit einer einfachen Tabelle: Reagieren auf Events */
public final class SelectTable {
    /** Erzeuge ein Panel mit einer einfachen Tabelle mit Listenern für Mouse-Events */
    public static JPanel newSelectTable() {
        final Logger log = Logger.getLogger(SelectTable.class.getName());

        JPanel contentPane = new JPanel();

        String[] columns = {"Vorname", "Name", "ECTS", "Semester", "PM bestanden"};
        Object[][] data = {
            {"Hein", "Bloed", 5, 2, Boolean.FALSE},
            {"Holger", "Hinz", 15, 4, Boolean.TRUE},
            {"Susi", "Studi", 2, 2, Boolean.FALSE}
        };

        JTable table = new JTable(data, columns);

        contentPane.setLayout(new BorderLayout());
        contentPane.add(table.getTableHeader(), BorderLayout.NORTH);
        contentPane.add(table, BorderLayout.CENTER);

        table.setAutoCreateRowSorter(true);

        table.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TableModel model = table.getModel();
                        int c = table.getSelectedColumn();
                        int r = table.getSelectedRow();
                        log.info(
                                "MouseListener: (" + r + ", " + c + "): " + model.getValueAt(r, c));
                    }
                });

        return contentPane;
    }
}
