package main.GUIs.Components.TableCComponents.TableSorter;

import main.Cars.Car;
import main.CustomTable.CTableSorter;
import main.CustomTable.CTable;

import java.util.function.Function;

public class TableSorter extends TableSorterComponents {
    private CTable table;
    private CTableSorter sorter;
    public TableSorter(CTable table) {
        super();
        this.table = table;
        this.sorter = new CTableSorter(this.table);
        this.setButtonActions();
    }

    @Override
    protected void setButtonActions() {
        this.orderButton.addActionListener((event) -> this.changeSortingOrder());
        this.brandButton.addActionListener((event) -> this.sortData(Car::getBrand));
        this.nameButton.addActionListener((event) -> this.sortData(Car::getName));
        this.typeButton.addActionListener((event) -> this.sortData(Car::getType));
        this.classButton.addActionListener((event) -> this.sortData(Car::getCarClass));
        this.priceButton.addActionListener((event) -> this.sortData(Car::getPrice));
        this.availabilityButton.addActionListener((event) -> this.sortData(Car::isAvailable));
        this.prodYearButton.addActionListener((event) -> this.sortData(Car::getProductionYear));
        this.useYearsButton.addActionListener((event) -> this.sortData(Car::getYearsInUse));
        this.weightButton.addActionListener((event) -> this.sortData(Car::getWeight));
        this.wheelDiamButton.addActionListener((event) -> this.sortData(Car::getWheelDiameter));
        this.maxSpeedButton.addActionListener((event) -> this.sortData(Car::getMaximumSpeed));
        this.fuelCapacityButton.addActionListener((event) -> this.sortData(Car::getFuelCapacity));
        this.fuelUsePer100kmButton.addActionListener((event) -> this.sortData(Car::getFuelUsePer100km));
    }

    private void changeSortingOrder() {
        if (this.orderButton.getText().equals("ASC"))
            this.orderButton.setText("DESC");
        else
            this.orderButton.setText("ASC");
    }

    private void sortData(Function<? super Car, ? > criteria) {
        boolean ascendingOrder = this.orderButton.getText().equals("ASC");
        this.sorter.sortData(criteria, ascendingOrder);
    }

    public CTableSorter getSorter() {
        return sorter;
    }
}
