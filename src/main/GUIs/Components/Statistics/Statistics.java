package main.GUIs.Components.Statistics;

import main.Cars.Car;
import main.CustomTable.CTable;
import main.GUIs.Components.CComponent;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.util.Vector;

import static main.Tools.nonNullString;

public class Statistics extends CComponent {
    private JPanel mainPanel;
    private JLabel totalPriceN;
    private JLabel totalCarsN;
    private JLabel totalAvailableN;

    public Statistics(CTable table) {
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                Vector<Car> data = table.getModel().getData();
                int totalPrice = 0;
                int availableCars = 0;
                for (Car car : data) {
                    totalPrice += car.getPrice();
                    availableCars += car.isAvailable() ? 1 : 0;
                }

                setTotalCarsN(data.size());
                setTotalPriceN(totalPrice);
                setTotalAvailableN(availableCars);
            }
        });
    }

    @Override
    public JPanel getMainPanel() {
        return this.mainPanel;
    }
    public void setTotalPriceN(int totalPriceN) {
        this.totalPriceN.setText(nonNullString(totalPriceN));
    }
    public void setTotalCarsN(int totalCarsN) {
        this.totalCarsN.setText(nonNullString(totalCarsN));
    }
    public void setTotalAvailableN(int availableCarsN) {
        this.totalAvailableN.setText(nonNullString(availableCarsN));
    }
}
