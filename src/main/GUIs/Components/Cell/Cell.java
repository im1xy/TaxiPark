package main.GUIs.Components.Cell;

import main.Cars.Car;
import main.CustomTable.CTable;
import main.GUIs.Windows.CarDialog.CarDialog;
import main.GUIs.Windows.CarInformationDialog.CarInformationDialog;

public class Cell extends CellComponents {
    private Car carInformation;
    private CTable table;
    private int rowN;

    public Cell(Car car, CTable table, int row) {
        super();
        this.carInformation = car;
        this.rowN = row;
        this.table = table;

        this.setPanelInformation();
        this.setButtonActions();
    }

    private void setPanelInformation() {
        // Main Info
        this.brandN.setText(this.carInformation.getBrand());
        this.nameN.setText(this.carInformation.getName());
        this.typeN.setText(this.carInformation.getType());
        this.classN.setText(this.carInformation.getCarClass());
        this.priceN.setText(String.valueOf(this.carInformation.getPrice()));
        this.availableRadioButton.setSelected(this.carInformation.isAvailable());

        // Additional Info
        this.prodYearN.setText(String.valueOf(this.carInformation.getProductionYear()));
        this.yearsInUseN.setText(String.valueOf(this.carInformation.getYearsInUse()));
        this.weightN.setText(String.valueOf(this.carInformation.getWeight()));
        this.wheelDiameterN.setText(String.valueOf(this.carInformation.getWheelDiameter()));
        this.maximumSpeedN.setText(String.valueOf(this.carInformation.getMaximumSpeed()));
        this.fuelCapacityN.setText(String.valueOf(this.carInformation.getFuelCapacity()));
        this.fuelUseN.setText(String.valueOf(this.carInformation.getFuelUsePer100km()));
    }

    @Override
    protected void setButtonActions() {
        this.moreButton.addActionListener((event) -> openMoreDialog());
        this.editButton.addActionListener((event) -> openEditCarDialog());
        this.deleteButton.addActionListener((event) -> deletePanel());
        this.availableRadioButton.addPropertyChangeListener((event) -> this.changeAvailableRadioButtonText());
    }

    private void openMoreDialog() {
        CarInformationDialog dialog = new CarInformationDialog(this.carInformation);
        dialog.setVisible(true);
    }
    private void openEditCarDialog() {
        int modelRow = this.table.convertRowIndexToModel(this.rowN);
        CarDialog dialog = new CarDialog(this.table, modelRow, CarDialog.EDIT_MODE);
        dialog.setVisible(true);
    }
    private void deletePanel() {
        int modelRow = this.table.convertRowIndexToModel(this.rowN);
        this.table.getModel().removeRow(modelRow);
    }

    private void changeAvailableRadioButtonText() {
        if (this.availableRadioButton.isSelected())
            this.availableRadioButton.setText("Available");
        else
            this.availableRadioButton.setText("Not Available");
    }
}
