package main.CustomTable;

import main.Cars.Car;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

import java.util.Vector;

import static main.Tools.nonNullString;

public class CTableFilter {
    private CTable table;
    public CTableFilter(CTable table) {
        this.table = table;
    }

    public void filterData(String brandCriteria, String nameCriteria,
                                  String typeCriteria, String carClassCriteria,
                                  Integer[] priceRangeCriteria, String isAvailableCriteria,
                                  Integer[] prodYearCriteria, Integer[] yearsInUseRangeCriteria,
                                  Integer[] weightRangeCriteria, Integer[] wheelDiameterRangeCriteria,
                                  Integer[] maxSpeedRangeCriteria, Integer[] fuelCapacityRangeCriteria,
                                  Integer[] fuelOn100kmRangeCriteria) {

        RowFilter<CTableModel, Integer> rowFilter = this.getRowFilter(
                brandCriteria, nameCriteria, typeCriteria, carClassCriteria, priceRangeCriteria, isAvailableCriteria,
                prodYearCriteria, yearsInUseRangeCriteria, weightRangeCriteria, wheelDiameterRangeCriteria,
                maxSpeedRangeCriteria, fuelCapacityRangeCriteria, fuelOn100kmRangeCriteria);

        CTableModel model = this.table.getModel();
        TableRowSorter<CTableModel> rowSorter = new TableRowSorter<>(model);
        this.table.setRowSorter(rowSorter);
        rowSorter.setRowFilter(rowFilter);
        this.table.getModel().fireTableStructureChanged();
    }

    public Vector<Car> getFilteredData() {
        Vector<Car> filteredData = new Vector<>();
        for(int row = 0;row < this.table.getRowCount();row++) {
            filteredData.add((Car)this.table.getModel().getValueAt(this.table.convertRowIndexToModel(row), 0));
        }
        return filteredData;
    }

    public void reset() {
        this.table.setRowSorter(null);
        this.table.getModel().fireTableStructureChanged();
    }

    private RowFilter<CTableModel, Integer> getRowFilter(String brandCriteria, String nameCriteria,
                                                         String typeCriteria, String carClassCriteria,
                                                         Integer[] priceRangeCriteria, String isAvailableCriteria,
                                                         Integer[] prodYearCriteria, Integer[] yearsInUseRangeCriteria,
                                                         Integer[] weightRangeCriteria, Integer[] wheelDiameterRangeCriteria,
                                                         Integer[] maxSpeedRangeCriteria, Integer[] fuelCapacityRangeCriteria,
                                                         Integer[] fuelOn100kmRangeCriteria) {
        return new RowFilter<>() {
            @Override
            public boolean include(Entry<? extends CTableModel, ? extends Integer> entry) {
                Car car = entry.getModel().getValueAt(entry.getIdentifier());
                boolean isAvailability = isAvailableCriteria.isEmpty() || car.isAvailable() == isAvailableCriteria.equals("Available");
                return car.getBrand().contains(brandCriteria) &&
                        car.getName().contains(nameCriteria) &&
                        car.getType().contains(nonNullString(typeCriteria)) &&
                        car.getCarClass().contains(nonNullString(carClassCriteria)) &&
                        isInRange(car.getPrice(), priceRangeCriteria) &&
                        isAvailability &&
                        isInRange(car.getProductionYear(), prodYearCriteria) &&
                        isInRange(car.getYearsInUse(), yearsInUseRangeCriteria) &&
                        isInRange(car.getWeight(), weightRangeCriteria) &&
                        isInRange(car.getWheelDiameter(), wheelDiameterRangeCriteria) &&
                        isInRange(car.getMaximumSpeed(), maxSpeedRangeCriteria) &&
                        isInRange(car.getFuelCapacity(), fuelCapacityRangeCriteria) &&
                        isInRange(car.getFuelUsePer100km(), fuelOn100kmRangeCriteria);
            }
        };
    }

    private boolean isInRange(Integer value, Integer[] range) {
        if (range[0] == 0 && range[1] == 0)
            return true;

        return value != null && value >= range[0] && value <= range[1];
    }
}
