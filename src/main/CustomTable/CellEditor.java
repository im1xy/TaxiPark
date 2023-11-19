package main.CustomTable;

import main.Cars.Car;
import main.GUIs.Components.Cell.Cell;

import javax.swing.*;
import java.awt.*;

public class CellEditor extends DefaultCellEditor{
    public CellEditor() { super(new JCheckBox()); }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return new Cell((Car) value, (CTable) table, row).getMainPanel();
    }
}
