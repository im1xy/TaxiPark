package test.GUIs.Components.TableCComponents.TableSorter;

import main.Cars.Car;
import main.CustomTable.CTable;
import main.GUIs.Components.TableCComponents.TableSorter.TableSorter;

import javax.swing.*;
import java.util.Vector;

import static test.GUIs.CommonGUITests.findComponent;
import static test.GUIs.Components.TableCComponents.TableTestingUtils.compareData;
import static test.testCarData.*;

public class TableSorterTestingUtils {
    public static Vector<Car> getTestData() {
        Vector<Car> vector = new Vector<>();
        vector.add(testAudiPetrolCar);
        vector.add(testTeslaElectricCar);
        vector.add(testOpelGasCar);
        return vector;
    }

    public static void testDescSort(Vector<Car> expected, String buttonName) {
        CTable table = new CTable("Test", getTestData());
        TableSorter sorter = new TableSorter(table);

        JButton orderButton = (JButton) findComponent(sorter.getMainPanel(), "orderButton");
        JButton button = (JButton) findComponent(sorter.getMainPanel(), buttonName);

        orderButton.doClick();
        button.doClick();

        Vector<Car> result = table.getModel().getData();
        compareData(expected, result);
    }

    public static void testAscSort(Vector<Car> expected, String buttonName) {
        CTable table = new CTable("Test", getTestData());
        TableSorter sorter = new TableSorter(table);

        JButton button = (JButton) findComponent(sorter.getMainPanel(), buttonName);
        button.doClick();

        Vector<Car> result = table.getModel().getData();
        compareData(expected, result);
    }
}
