package main.CustomTable;

import main.Cars.Car;
import main.GUIs.Components.Cell.Cell;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return new Cell((Car) value, (CTable) table, row).getMainPanel();
    }
}
