package main.CustomTable;

import main.Cars.Car;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class CTableModel extends DefaultTableModel {
    private final Logger logger = Logger.getLogger(CTableModel.class.getName());
    private Vector<Car> data;
    public CTableModel(String columnName, Vector<Car> newData) {
        logger.setUseParentHandlers(false);
        this.setData(newData);
        this.setColumnIdentifier(columnName);
    }

    public void setDefaultDataLogger() {
        Handler fileHandler;
        String logFile = "./dataLogs.log";
        try {
            fileHandler = new FileHandler(logFile);
            logger.addHandler(fileHandler);
        }
        catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public void addRow(Car newCar) {
        this.data.add(newCar);

        logger.info("ADDED NEW VALUE\n" + newCar);
        this.fireTableStructureChanged();
    }

    @Override
    public void removeRow(int row) {
        Car oldCar = this.data.get(row);
        this.data.remove(row);

        logger.info("REMOVED VALUE\n" + oldCar);
        this.fireTableStructureChanged();
    }

    public Car getValueAt(int rowIndex) {
        return data.get(rowIndex);
    }

    public void setValueAt(Car newCar, int row) {
        Car oldCar = this.data.get(row);
        this.data.setElementAt(newCar, row);

        logger.info("UPDATED VALUE\nOLD VALUE:\n" + oldCar + "\nNEW VALUE:\n" + newCar);
        this.fireTableStructureChanged();
    }

    public void setData(Vector<Car> newData) {
        Vector<Car> oldData = this.data;
        this.data = Objects.requireNonNullElseGet(newData, Vector::new);

        logger.info("THE DATA WAS CHANGED\nOLD DATA:\n" + oldData + "\nNEW DATA:\n" + this.data);
        this.fireTableStructureChanged();
    }

    public Vector<Car> getData() {
        return this.data;
    }
    public void setColumnIdentifier(String newIdentifier) {
        super.setColumnIdentifiers(new String[] {newIdentifier});
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Car.class;
    }
    @Override
    public Object getValueAt(int row, int column) {
        return this.data.get(row);
    }
    @Override
    public int getRowCount() {
        return (data == null) ? 0 : data.size();
    }
    @Override
    public void setValueAt(Object aValue, int row, int column) {}
}
