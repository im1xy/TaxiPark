package test.GUIs.Components.TableCComponents.FilterAndSort;

import main.Cars.Car;
import main.CustomTable.CTable;
import main.GUIs.Components.TableCComponents.TableFilter.TableFilter;
import main.GUIs.Components.TableCComponents.TableSorter.TableSorter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Vector;

import static test.testCarData.*;
import static test.GUIs.CommonGUITests.*;
import static test.GUIs.Components.TableCComponents.TableTestingUtils.*;
import static test.GUIs.Components.TableCComponents.TableFilter.TableFilterTestingUtils.*;

public class FilteringAndSortingTests {
    @Test
    @DisplayName("One Filter + One Sort Test")
    public void oneFilterOneSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testOpelGasCar);
        expected.add(testBugattiPetrolCar);
        expected.add(testPorscheElectricCar);

        CTable table = new CTable("Test", getTestData());
        TableFilter filter = new TableFilter(table);
        TableSorter sorter = new TableSorter(table);

        JButton doneButton = (JButton) findComponent(filter.getMainPanel(), "doneButton");
        JPanel priceRangeChooserPanel = (JPanel) findComponent(filter.getMainPanel(), "priceRangeChooserPanel");
        JSpinner fromSpinner = (JSpinner) findComponent(priceRangeChooserPanel, "fromSpinner");
        JSpinner toSpinner = (JSpinner) findComponent(priceRangeChooserPanel, "toSpinner");
        JButton priceButton = (JButton) findComponent(sorter.getMainPanel(), "priceButton");

        fromSpinner.setValue(15000);
        toSpinner.setValue(25000);
        doneButton.doClick();
        priceButton.doClick();

        Vector<Car> result = filter.getFilter().getFilteredData();
        compareData(expected, result);
    }

    @Test
    @DisplayName("Multiple Filters + One Sort Test")
    public void MultipleFiltersOneSort() {
        Vector<Car> expected = new Vector<>();
        expected.add(testPorscheElectricCar);
        expected.add(testBugattiPetrolCar);

        CTable table = new CTable("Test", getTestData());
        TableFilter filter = new TableFilter(table);
        TableSorter sorter = new TableSorter(table);

        JButton doneButton = (JButton) findComponent(filter.getMainPanel(), "doneButton");
        JPanel priceRangeChooserPanel = (JPanel) findComponent(filter.getMainPanel(), "priceRangeChooserPanel");
        JSpinner fromSpinner = (JSpinner) findComponent(priceRangeChooserPanel, "fromSpinner");
        JSpinner toSpinner = (JSpinner) findComponent(priceRangeChooserPanel, "toSpinner");
        JComboBox<String> availableComboBox = (JComboBox<String>) findComponent(filter.getMainPanel(), "availableComboBox");
        JButton maxSpeedButton = (JButton) findComponent(sorter.getMainPanel(), "maxSpeedButton");

        fromSpinner.setValue(15000);
        toSpinner.setValue(25000);
        availableComboBox.setSelectedItem("Available");
        doneButton.doClick();
        maxSpeedButton.doClick();

        Vector<Car> result = filter.getFilter().getFilteredData();
        compareData(expected, result);
    }
}
