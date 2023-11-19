package main.GUIs.Windows.CarDialog;

import main.Cars.Car;
import main.CustomTable.CTable;

import static main.GUIs.MessageDialogs.showErrorMessageDialog;
import static main.Tools.*;

public class CarDialog extends CarDialogComponents {
    // MODES
    public static final int ADD_MODE = 0;
    public static final int EDIT_MODE = 1;

    private CTable table;
    private Integer rowN;
    private int mode;

    public CarDialog(CTable table, Integer row, int mode) {
        super(mode);
        this.table = table;
        this.mode = mode;
        this.rowN = row;

        this.setComponentsFields();
        this.setButtonsActions();
    }

    private void setComponentsFields() {
        if (this.mode == EDIT_MODE) {
            Car currentCarInfo = this.table.getModel().getValueAt(this.rowN);
            this.setCurrentData(currentCarInfo);
        }
    }

    @Override
    public void setButtonsActions() {
        this.okButton.addActionListener((event) -> this.changeData());
        this.clearButton.addActionListener((event) -> this.clearFields());
        this.cancelButton.addActionListener((event) -> this.close());
    }

    private void setCurrentData(Car carInfo) {
        this.brandTextField.setText(carInfo.getBrand());
        this.nameTextField.setText(carInfo.getName());
        this.classComboBox.setSelectedItem(carInfo.getCarClass());
        this.typeComboBox.setSelectedItem(carInfo.getType());
        this.priceTextField.setText(nonNullString(carInfo.getPrice()));
        this.availableRadioButton.setSelected(carInfo.isAvailable());
        this.prodYearComboBox.setSelectedItem(carInfo.getProductionYear());
        this.yearsInUseTextField.setText(nonNullString(carInfo.getYearsInUse()));
        this.weightTextField.setText(nonNullString(carInfo.getWeight()));
        this.wheelDiameterTextField.setText(nonNullString(carInfo.getWheelDiameter()));
        this.maximumSpeedTextField.setText(nonNullString(carInfo.getMaximumSpeed()));
        this.fuelCapacityTextField.setText(nonNullString(carInfo.getFuelCapacity()));
        this.fuelUseTextField.setText(nonNullString(carInfo.getFuelUsePer100km()));
    }

    private void changeData() {
        Car carData = null;
        try {
            carData = this.getNewCarData();
        }
        catch (NumberFormatException e) {
            showErrorMessageDialog(this.windowPanel,"Input correct data types.");
            e.fillInStackTrace();
            return;
        }

        if (carData.getBrand().isEmpty() || carData.getName().isEmpty() ||
                nonNullString(carData.getCarClass()).isEmpty() ||
                nonNullString(carData.getType()).isEmpty() || carData.getPrice() == null) {
            showErrorMessageDialog(this.windowPanel,"All Fields of Main Information must be SET.");
            return;
        }

        if (this.mode == ADD_MODE)
            this.table.getModel().addRow(carData);
        else if (this.mode == EDIT_MODE)
            this.table.getModel().setValueAt(carData, this.rowN);
    }

    private Car getNewCarData() {
        String brand = this.brandTextField.getText();
        String name = this.nameTextField.getText();
        String type = nonNullString(this.typeComboBox.getSelectedItem());
        String carClass = nonNullString(this.classComboBox.getSelectedItem());
        Integer price = formatInteger(this.priceTextField.getText());
        Boolean isAvailable = this.availableRadioButton.isSelected();
        Integer productionYear = (Integer) this.prodYearComboBox.getSelectedItem();
        Integer yearsInUse = formatInteger(this.yearsInUseTextField.getText());
        Integer weight = formatInteger(this.weightTextField.getText());
        Integer wheelDiameter = formatInteger(this.wheelDiameterTextField.getText());
        Integer maximumSpeed = formatInteger(this.maximumSpeedTextField.getText());
        Integer fuelCapacity = formatInteger(this.fuelCapacityTextField.getText());
        Integer fuelUsagePer100Kilometer = formatInteger(this.fuelUseTextField.getText());

        return new Car(brand, name, type, carClass, price, isAvailable, productionYear, yearsInUse, weight,
                wheelDiameter, maximumSpeed, fuelCapacity, fuelUsagePer100Kilometer);
    }

    private void clearFields() {
        this.brandTextField.setText(null);
        this.nameTextField.setText(null);
        this.typeComboBox.setSelectedItem(null);
        this.classComboBox.setSelectedItem(null);
        this.priceTextField.setText(null);
        this.availableRadioButton.setSelected(false);
        this.prodYearComboBox.setSelectedItem(null);
        this.yearsInUseTextField.setText(null);
        this.weightTextField.setText(null);
        this.wheelDiameterTextField.setText(null);
        this.maximumSpeedTextField.setText(null);
        this.fuelCapacityTextField.setText(null);
        this.fuelUseTextField.setText(null);
    }

    private void close() {
        this.dispose();
    }
}
