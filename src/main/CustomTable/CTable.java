package main.CustomTable;

import main.Cars.Car;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableRowSorter;
import java.util.Vector;

public class CTable extends JTable {
    private CTableModel tableModel;
    public CTable(String columnName, Vector<Car> data) {
        this.setModel(new CTableModel(columnName, data));
        this.setDefaultRenderer(Car.class, new CellRenderer());
        this.setDefaultEditor(Car.class, new CellEditor());
        this.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public CTableModel getModel() {
        return this.tableModel;
    }

    public void setModel(CTableModel dataModel) {
        if (dataModel == null) {
            throw new IllegalArgumentException("Cannot set a null TableModel");
        }
        if (this.tableModel != dataModel) {
            CTableModel old = this.tableModel;
            if (old != null) {
                old.removeTableModelListener(this);
            }
            this.tableModel = dataModel;
            dataModel.addTableModelListener(this);

            tableChanged(new TableModelEvent(dataModel, TableModelEvent.HEADER_ROW));

            firePropertyChange("model", old, dataModel);

            if (getAutoCreateRowSorter()) {
                setRowSorter(new TableRowSorter<>(dataModel));
            }
        }
    }
}
