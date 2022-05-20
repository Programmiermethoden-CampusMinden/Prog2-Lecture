package tables;

import java.awt.FlowLayout;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/** Demo: Umgang mit einer Modell-basierten Tabelle */
public final class ModelTable extends AbstractTableModel {
    private static Logger LOG = Logger.getLogger("MyTableModel");

    // Daten sind hier zufällig als Array strukturiert, hier können aber beliebige
    // Strukturen genutzt werden (die Methoden müssen nur passend implementiert
    // werden) ...
    private final String[] columns = {"Vorname", "Name", "ect", "Semester", "PGM bestanden"};
    private final Class<?>[] clazzes = {
        String.class, String.class, Integer.class, Integer.class, Boolean.class
    };
    private final Object[][] data = {
        {"Hein", "Bloed", 5, 2, Boolean.FALSE},
        {"Holger", "Hinz", 15, 4, Boolean.TRUE},
        {"Susi", "Studi", 2, 2, Boolean.FALSE}
    };

    private ModelTable() {}

    /** Erzeuge ein Panel mit einer Modell-basierten Tabelle */
    public static JPanel newModelTable() {

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());

        TableModel model = new ModelTable();

        contentPane.add(new JTable(model));

        return contentPane;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public Class<?> getColumnClass(int c) {
        return clazzes[c];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col >= 2; // Spalten 0 und 1 sind damit read-only
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        LOG.info(
                "Setting value at ("
                        + row
                        + ","
                        + col
                        + ") from "
                        + data[row][col]
                        + " to "
                        + value
                        + " (an instance of "
                        + value.getClass()
                        + ")");

        data[row][col] = value; // update model
        fireTableCellUpdated(row, col); // signal to update view
    }
}
