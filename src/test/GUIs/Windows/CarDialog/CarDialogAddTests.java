package test.GUIs.Windows.CarDialog;

import main.CustomTable.CTable;
import main.GUIs.Windows.CarDialog.CarDialog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static test.GUIs.Windows.CarDialog.CarDialogTestingUtils.setData;
import static test.GUIs.CommonGUITests.findComponent;
import static test.GUIs.CommonGUITests.testMessageDialog;
import static test.testCarData.*;

public class CarDialogAddTests {
    @Test
    @DisplayName("Add OK Test")
    public void addOk() {
        CTable table = new CTable("Test", null);
        table.getModel().addRow(testAudiPetrolCar);

        CarDialog dialog = new CarDialog(table, null, CarDialog.ADD_MODE);
        setData(dialog, testTeslaElectricCar);

        JButton okButton = (JButton) findComponent(dialog, "okButton");
        okButton.doClick();

        assertEquals(testTeslaElectricCar, table.getModel().getData().elementAt(1));
        assertNotEquals(table.getModel().getData().elementAt(0), table.getModel().getData().elementAt(1));
    }
    @Test
    @DisplayName("Add Cancel Test")
    public void addCancel() {
        CTable table = new CTable("Test", null);

        CarDialog dialog = new CarDialog(table, null, CarDialog.ADD_MODE);
        setData(dialog, testTeslaElectricCar);

        JButton cancelButton = (JButton) findComponent(dialog, "cancelButton");
        cancelButton.doClick();

        assertTrue(table.getModel().getData().isEmpty());
    }
    @Test
    @DisplayName("Empty Main Info Test")
    public void emptyMainInfo() throws InterruptedException {
        CTable table = new CTable("Test", null);
        CarDialog dialog = new CarDialog(table, null, CarDialog.ADD_MODE);

        setData(dialog, testNullCar);

        JButton okButton = (JButton) findComponent(dialog, "okButton");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                okButton.doClick();
            }
        });
        testMessageDialog(dialog, JOptionPane.OK_OPTION);
    }
}
