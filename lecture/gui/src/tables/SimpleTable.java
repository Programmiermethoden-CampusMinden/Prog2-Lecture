package tables;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;

/** Demo: Umgang mit einer einfachen Tabelle */
public final class SimpleTable {
    /** Erzeuge ein Panel mit einer einfachen Tabelle */
    public static JPanel newSimpleTable() {
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

        return contentPane;
    }
}
