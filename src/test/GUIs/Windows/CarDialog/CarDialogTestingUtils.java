package test.GUIs.Windows.CarDialog;

import main.Cars.Car;
import main.GUIs.Windows.CarDialog.CarDialog;

import javax.swing.*;

import static main.Tools.formatInteger;
import static main.Tools.nonNullString;
import static test.GUIs.CommonGUITests.findComponent;

public class CarDialogTestingUtils {
    public static void setData(CarDialog dialog, Car car) {
        JTextField brandTextField = (JTextField) findComponent(dialog, "brandTextField");
        JTextField nameTextField = (JTextField) findComponent(dialog, "nameTextField");
        JComboBox<String> typeComboBox = (JComboBox<String>) findComponent(dialog, "typeComboBox");
        JComboBox<String> classComboBox = (JComboBox<String>) findComponent(dialog, "classComboBox");
        JTextField priceTextField = (JTextField) findComponent(dialog, "priceTextField");
        JRadioButton availableRadioButton = (JRadioButton) findComponent(dialog, "availableRadioButton");
        JComboBox<Integer> prodYearComboBox = (JComboBox<Integer>) findComponent(dialog, "prodYearComboBox");
        JTextField yearsInUseTextField = (JTextField) findComponent(dialog, "yearsInUseTextField");
        JTextField weightTextField = (JTextField) findComponent(dialog, "weightTextField");
        JTextField wheelDiameterTextField = (JTextField) findComponent(dialog, "wheelDiameterTextField");
        JTextField maximumSpeedTextField = (JTextField) findComponent(dialog, "maximumSpeedTextField");
        JTextField fuelCapacityTextField = (JTextField) findComponent(dialog, "fuelCapacityTextField");
        JTextField fuelUseTextField = (JTextField) findComponent(dialog, "fuelUseTextField");

        brandTextField.setText(car.getBrand());
        nameTextField.setText(car.getName());
        classComboBox.setSelectedItem(car.getCarClass());
        typeComboBox.setSelectedItem(car.getType());
        priceTextField.setText(nonNullString(car.getPrice()));
        availableRadioButton.setSelected(car.isAvailable());
        prodYearComboBox.setSelectedItem(car.getProductionYear());
        yearsInUseTextField.setText(nonNullString(car.getYearsInUse()));
        weightTextField.setText(nonNullString(car.getWeight()));
        wheelDiameterTextField.setText(nonNullString(car.getWheelDiameter()));
        maximumSpeedTextField.setText(nonNullString(car.getMaximumSpeed()));
        fuelCapacityTextField.setText(nonNullString(car.getFuelCapacity()));
        fuelUseTextField.setText(nonNullString(car.getFuelUsePer100km()));
    }

    public static Car getCurrentData(CarDialog dialog) {
        JTextField brandTextField = (JTextField) findComponent(dialog, "brandTextField");
        JTextField nameTextField = (JTextField) findComponent(dialog, "nameTextField");
        JComboBox<String> typeComboBox = (JComboBox<String>) findComponent(dialog, "typeComboBox");
        JComboBox<String> classComboBox = (JComboBox<String>) findComponent(dialog, "classComboBox");
        JTextField priceTextField = (JTextField) findComponent(dialog, "priceTextField");
        JRadioButton availableRadioButton = (JRadioButton) findComponent(dialog, "availableRadioButton");
        JComboBox<Integer> prodYearComboBox = (JComboBox<Integer>) findComponent(dialog, "prodYearComboBox");
        JTextField yearsInUseTextField = (JTextField) findComponent(dialog, "yearsInUseTextField");
        JTextField weightTextField = (JTextField) findComponent(dialog, "weightTextField");
        JTextField wheelDiameterTextField = (JTextField) findComponent(dialog, "wheelDiameterTextField");
        JTextField maximumSpeedTextField = (JTextField) findComponent(dialog, "maximumSpeedTextField");
        JTextField fuelCapacityTextField = (JTextField) findComponent(dialog, "fuelCapacityTextField");
        JTextField fuelUseTextField = (JTextField) findComponent(dialog, "fuelUseTextField");

        String brand = brandTextField.getText();
        String name = nameTextField.getText();
        String type = nonNullString(typeComboBox.getSelectedItem());
        String carClass = nonNullString(classComboBox.getSelectedItem());
        Integer price = formatInteger(priceTextField.getText());
        Boolean isAvailable = availableRadioButton.isSelected();
        Integer productionYear = (Integer) prodYearComboBox.getSelectedItem();
        Integer yearsInUse = formatInteger(yearsInUseTextField.getText());
        Integer weight = formatInteger(weightTextField.getText());
        Integer wheelDiameter = formatInteger(wheelDiameterTextField.getText());
        Integer maximumSpeed = formatInteger(maximumSpeedTextField.getText());
        Integer fuelCapacity = formatInteger(fuelCapacityTextField.getText());
        Integer fuelUsagePer100Kilometer = formatInteger(fuelUseTextField.getText());

        return new Car(brand, name, type, carClass, price, isAvailable, productionYear, yearsInUse, weight,
                wheelDiameter, maximumSpeed, fuelCapacity, fuelUsagePer100Kilometer);
    }
}
