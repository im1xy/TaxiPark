package test.GUIs.Components.TableCComponents.TableSorter;

import main.Cars.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static test.testCarData.*;
import static test.GUIs.Components.TableCComponents.TableSorter.TableSorterTestingUtils.*;

public class DescendingTests {
    @Test
    @DisplayName("Brand Sort Test")
    public void brandSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testTeslaElectricCar);
        expected.add(testOpelGasCar);
        expected.add(testAudiPetrolCar);

        testDescSort(expected, "brandButton");
    }

    @Test
    @DisplayName("Name Sort Test")
    public void nameSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testTeslaElectricCar);
        expected.add(testAudiPetrolCar);
        expected.add(testOpelGasCar);

        testDescSort(expected, "nameButton");
    }

    @Test
    @DisplayName("Type Sort Test")
    public void typeSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testAudiPetrolCar);
        expected.add(testOpelGasCar);
        expected.add(testTeslaElectricCar);

        testDescSort(expected, "typeButton");
    }

    @Test
    @DisplayName("Class Sort Test")
    public void classSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testTeslaElectricCar);
        expected.add(testAudiPetrolCar);
        expected.add(testOpelGasCar);

        testDescSort(expected, "classButton");
    }

    @Test
    @DisplayName("Price Sort Test")
    public void priceSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testOpelGasCar);
        expected.add(testTeslaElectricCar);
        expected.add(testAudiPetrolCar);

        testDescSort(expected, "priceButton");
    }

    @Test
    @DisplayName("Production Year Sort Test")
    public void prodYearSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testAudiPetrolCar);
        expected.add(testTeslaElectricCar);
        expected.add(testOpelGasCar);

        testDescSort(expected, "prodYearButton");
    }

    @Test
    @DisplayName("Use Years Sort Test")
    public void useYearsSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testOpelGasCar);
        expected.add(testAudiPetrolCar);
        expected.add(testTeslaElectricCar);

        testDescSort(expected, "useYearsButton");
    }

    @Test
    @DisplayName("Weight Sort Test")
    public void weightSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testAudiPetrolCar);
        expected.add(testTeslaElectricCar);
        expected.add(testOpelGasCar);

        testDescSort(expected, "weightButton");
    }

    @Test
    @DisplayName("Wheel Diameter Sort Test")
    public void wheelDiameterSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testTeslaElectricCar);
        expected.add(testOpelGasCar);
        expected.add(testAudiPetrolCar);

        testDescSort(expected, "wheelDiamButton");
    }

    @Test
    @DisplayName("Max Speed Sort Test")
    public void maxSpeedSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testTeslaElectricCar);
        expected.add(testAudiPetrolCar);
        expected.add(testOpelGasCar);

        testDescSort(expected, "maxSpeedButton");
    }

    @Test
    @DisplayName("Fuel Capacity Sort Test")
    public void fuelCapacitySort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testAudiPetrolCar);
        expected.add(testOpelGasCar);
        expected.add(testTeslaElectricCar);

        testDescSort(expected, "fuelCapacityButton");
    }

    @Test
    @DisplayName("Fuel Use Per 100km Sort Test")
    public void fuelUsePer100kmSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testOpelGasCar);
        expected.add(testTeslaElectricCar);
        expected.add(testAudiPetrolCar);

        testDescSort(expected, "fuelUsePer100kmButton");
    }
}
