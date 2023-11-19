package test.GUIs.Components.TableCComponents.TableFilter;

import main.Cars.Car;
import main.CustomTable.CTable;
import main.GUIs.Components.TableCComponents.TableFilter.TableFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Vector;

import static test.GUIs.CommonGUITests.findComponent;
import static test.GUIs.Components.TableCComponents.TableFilter.TableFilterTestingUtils.getTestData;
import static test.GUIs.Components.TableCComponents.TableTestingUtils.compareData;
import static test.testCarData.*;

public class TableFilterTests {
    @Test
    @DisplayName("TextField Filtering Test")
    public void textFieldFiltering() {
        Vector<Car> expected = new Vector<>();
        expected.add(testAudiPetrolCar);
        expected.add(testAlfaRomeoGasCar);

        CTable table = new CTable("Test", getTestData());
        TableFilter filter = new TableFilter(table);
        JButton doneButton = (JButton) findComponent(filter.getMainPanel(), "doneButton");
        JTextField brandTextField = (JTextField) findComponent(filter.getMainPanel(), "brandTextField");

        brandTextField.setText("A");

        doneButton.doClick();

        Vector<Car> result = filter.getFilter().getFilteredData();
        compareData(expected, result);
    }

    @Test
    @DisplayName("ComboBox Filtering Test")
    public void comboBoxFiltering() {
        Vector<Car> expected = new Vector<>();
        expected.add(testTeslaElectricCar);
        expected.add(testPorscheElectricCar);

        CTable table = new CTable("Test", getTestData());
        TableFilter filter = new TableFilter(table);
        JButton doneButton = (JButton) findComponent(filter.getMainPanel(), "doneButton");
        JComboBox<String> typeComboBox = (JComboBox<String>) findComponent(filter.getMainPanel(), "typeComboBox");

        typeComboBox.setSelectedItem("Electric Car");

        doneButton.doClick();

        Vector<Car> result = filter.getFilter().getFilteredData();
        compareData(expected, result);
    }

    @Test
    @DisplayName("SpinnerRangeChoosers Filtering Test")
    public void spinnerRangeChoosersFiltering() {
        Vector<Car> expected = new Vector<>();
        expected.add(testAudiPetrolCar);
        expected.add(testTeslaElectricCar);

        CTable table = new CTable("Test", getTestData());
        TableFilter filter = new TableFilter(table);
        JButton doneButton = (JButton) findComponent(filter.getMainPanel(), "doneButton");
        JPanel priceRangeChooserPanel = (JPanel) findComponent(filter.getMainPanel(), "priceRangeChooserPanel");
        JSpinner fromSpinner = (JSpinner) findComponent(priceRangeChooserPanel, "fromSpinner");
        JSpinner toSpinner = (JSpinner) findComponent(priceRangeChooserPanel, "toSpinner");

        fromSpinner.setValue(5000);
        toSpinner.setValue(12000);

        doneButton.doClick();

        Vector<Car> result = filter.getFilter().getFilteredData();
        compareData(expected, result);
    }

    @Test
    @DisplayName("ComboBoxRangeChoosers Filtering Test")
    public void comboBoxRangeChoosersFiltering() {
        Vector<Car> expected = new Vector<>();
        expected.add(testAudiPetrolCar);
        expected.add(testTeslaElectricCar);

        CTable table = new CTable("Test", getTestData());
        TableFilter filter = new TableFilter(table);
        JButton doneButton = (JButton) findComponent(filter.getMainPanel(), "doneButton");
        JPanel prodYearRangeChooserPanel = (JPanel) findComponent(filter.getMainPanel(), "prodYearRangeChooserPanel");
        JComboBox<Integer> fromComboBox = (JComboBox<Integer>) findComponent(prodYearRangeChooserPanel, "fromComboBox");
        JComboBox<Integer> toComboBox = (JComboBox<Integer>) findComponent(prodYearRangeChooserPanel, "toComboBox");

        fromComboBox.setSelectedItem(2022);
        toComboBox.setSelectedItem(2023);
        doneButton.doClick();

        Vector<Car> result = filter.getFilter().getFilteredData();
        compareData(expected, result);
    }

    @Test
    @DisplayName("Multiple Filtering Test")
    public void multipleFiltering() {
        Vector<Car> expected = new Vector<>();
        expected.add(testTeslaElectricCar);

        CTable table = new CTable("Test", getTestData());
        TableFilter filter = new TableFilter(table);
        JButton doneButton = (JButton) findComponent(filter.getMainPanel(), "doneButton");
        JPanel prodYearRangeChooserPanel = (JPanel) findComponent(filter.getMainPanel(), "prodYearRangeChooserPanel");
        JComboBox<Integer> fromComboBox = (JComboBox<Integer>) findComponent(prodYearRangeChooserPanel, "fromComboBox");
        JComboBox<Integer> toComboBox = (JComboBox<Integer>) findComponent(prodYearRangeChooserPanel, "toComboBox");
        JComboBox<String> availableComboBox = (JComboBox<String>) findComponent(filter.getMainPanel(), "availableComboBox");
        JComboBox<String> typeComboBox = (JComboBox<String>) findComponent(filter.getMainPanel(), "typeComboBox");

        fromComboBox.setSelectedItem(2020);
        toComboBox.setSelectedItem(2023);
        availableComboBox.setSelectedItem("Available");
        typeComboBox.setSelectedItem("Electric Car");

        doneButton.doClick();

        Vector<Car> result = filter.getFilter().getFilteredData();
        compareData(expected, result);
    }

    @Test
    @DisplayName("Reset Filter Test")
    public void resetFilter() {
        Vector<Car> expected = new Vector<>();
        expected.add(testOpelGasCar);

        CTable table = new CTable("Test", getTestData());
        TableFilter filter = new TableFilter(table);
        JButton doneButton = (JButton) findComponent(filter.getMainPanel(), "doneButton");
        JButton resetButton = (JButton) findComponent(filter.getMainPanel(), "resetButton");
        JComboBox<String> classComboBox = (JComboBox<String>) findComponent(filter.getMainPanel(), "classComboBox");

        classComboBox.setSelectedItem("Compact car");

        doneButton.doClick();

        Vector<Car> result = filter.getFilter().getFilteredData();
        compareData(expected, result);

        resetButton.doClick();

        expected = getTestData();
        result = filter.getFilter().getFilteredData();
        compareData(expected, result);
    }
}
