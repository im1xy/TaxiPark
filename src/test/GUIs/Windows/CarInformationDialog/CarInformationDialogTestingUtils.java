package test.GUIs.Windows.CarInformationDialog;

import main.Cars.Car;

import javax.swing.*;

import static main.Tools.formatInteger;
import static test.GUIs.CommonGUITests.findComponent;

public class CarInformationDialogTestingUtils {
    public static Car getCar(JDialog parent) {
        JLabel brandN = (JLabel) findComponent(parent, "brandN");
        JLabel nameN = (JLabel) findComponent(parent, "nameN");
        JLabel typeN = (JLabel) findComponent(parent, "typeN");
        JLabel classN = (JLabel) findComponent(parent, "classN");
        JLabel priceN = (JLabel) findComponent(parent, "priceN");
        JLabel availabilityN = (JLabel) findComponent(parent, "availabilityN");
        JLabel prodYearN = (JLabel) findComponent(parent, "prodYearN");
        JLabel yearsInUseN = (JLabel) findComponent(parent, "yearsInUseN");
        JLabel weightN = (JLabel) findComponent(parent, "weightN");
        JLabel wheelDiameterN = (JLabel) findComponent(parent, "wheelDiameterN");
        JLabel maxSpeedN = (JLabel) findComponent(parent, "maxSpeedN");
        JLabel fuelCapacityN = (JLabel) findComponent(parent, "fuelCapacityN");
        JLabel fuelUsePer100kmN = (JLabel) findComponent(parent, "fuelUsePer100kmN");

        String brand = brandN.getText();
        String name = nameN.getText();
        String type = typeN.getText();
        String carClass = classN.getText();
        Integer price = formatInteger(priceN.getText());
        Boolean isAvailable = availabilityN.getText().equals("Available");
        Integer productionYear = formatInteger(prodYearN.getText());
        Integer yearsInUse = formatInteger(yearsInUseN.getText());
        Integer weight = formatInteger(weightN.getText());
        Integer wheelDiameter = formatInteger(wheelDiameterN.getText());
        Integer maximumSpeed = formatInteger(maxSpeedN.getText());
        Integer fuelCapacity = formatInteger(fuelCapacityN.getText());
        Integer fuelUsagePer100Kilometer = formatInteger(fuelUsePer100kmN.getText());

        return new Car(brand, name, type, carClass, price, isAvailable, productionYear, yearsInUse, weight,
                wheelDiameter, maximumSpeed, fuelCapacity, fuelUsagePer100Kilometer);
    }
}
