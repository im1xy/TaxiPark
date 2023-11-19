package test.GUIs.Windows.CarDialog;

import main.Cars.Car;
import main.CustomTable.CTable;
import main.GUIs.Windows.CarDialog.CarDialog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static test.GUIs.Windows.CarDialog.CarDialogTestingUtils.*;
import static test.GUIs.CommonGUITests.findComponent;
import static test.GUIs.CommonGUITests.testMessageDialog;
import static test.testCarData.*;

public class CarDialogEditTests {
    @Test
    @DisplayName("Edit Ok Test")
    public void editOk() {
        CTable table = new CTable("Test", null);
        table.getModel().addRow(testAudiPetrolCar);
        table.getModel().addRow(testOpelGasCar);

        int rowToEdit = 1;

        CarDialog dialog = new CarDialog(table, rowToEdit, CarDialog.EDIT_MODE);
        setData(dialog, testAudiPetrolCar);

        JButton okButton = (JButton) findComponent(dialog, "okButton");
        okButton.doClick();

        assertEquals(testAudiPetrolCar, table.getModel().getData().elementAt(rowToEdit));
        assertEquals(testAudiPetrolCar, table.getModel().getData().elementAt(0));
        assertEquals(table.getModel().getData().elementAt(0), table.getModel().getData().elementAt(rowToEdit));
    }

    @Test
    @DisplayName("Edit Cancel Test")
    public void editCancel() {
        CTable table = new CTable("Test", null);
        table.getModel().addRow(testAudiPetrolCar);

        int rowToEdit = 0;

        CarDialog dialog = new CarDialog(table, rowToEdit, CarDialog.EDIT_MODE);
        setData(dialog, testOpelGasCar);

        JButton cancelButton = (JButton) findComponent(dialog, "cancelButton");
        cancelButton.doClick();

        assertNotEquals(testOpelGasCar, table.getModel().getData().elementAt(rowToEdit));
        assertEquals(testAudiPetrolCar, table.getModel().getData().elementAt(rowToEdit));
    }

    @Test
    @DisplayName("Clear Edit Test")
    public void clearEdit() throws InterruptedException {
        CTable table = new CTable("Test", null);
        table.getModel().addRow(testAudiPetrolCar);

        int rowToEdit = 0;

        CarDialog dialog = new CarDialog(table, rowToEdit, CarDialog.EDIT_MODE);
        setData(dialog, testOpelGasCar);

        JButton clearButton = (JButton) findComponent(dialog, "clearButton");
        JButton okButton = (JButton) findComponent(dialog, "okButton");
        clearButton.doClick();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                okButton.doClick();
            }
        });
        testMessageDialog(dialog, JOptionPane.OK_OPTION);
    }

    @Test
    @DisplayName("Current Info while Edit Test")
    public void currentInfoEdit() {
        CTable table = new CTable("Test", null);
        table.getModel().addRow(testAudiPetrolCar);
        table.getModel().addRow(testOpelGasCar);

        CarDialog dialog = new CarDialog(table, 0, CarDialog.EDIT_MODE);
        Car result = getCurrentData(dialog);
        Car expected = testAudiPetrolCar;
        assertEquals(expected, result);

        dialog = new CarDialog(table, 1, CarDialog.EDIT_MODE);
        result = getCurrentData(dialog);
        expected = testOpelGasCar;
        assertEquals(expected, result);
    }
}
