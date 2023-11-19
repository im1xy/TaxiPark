package test.GUIs.Components.Menu;

import main.Cars.Car;
import main.CustomTable.CTable;
import main.GUIs.Components.Menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.GUIs.CommonGUITests.testMessageDialog;
import static test.testCarData.testOpelGasCar;
import static test.testCarData.testAudiPetrolCar;

public class LoadTests {
    @Test
    @DisplayName("Save/Load Test")
    public void saveLoad() throws InterruptedException {
        CTable table = new CTable("Test", null);
        table.getModel().addRow(testAudiPetrolCar);
        table.getModel().addRow(testOpelGasCar);
        Vector<Car> originalData = table.getModel().getData();
        JFrame frame = new JFrame();
        Menu menu = new Menu(frame, table);
        String filePath = "./testSave.txt";
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                menu.writeDataToFile(filePath, table.getModel());
            }
        });
        testMessageDialog(menu.getParentFrame(), JOptionPane.OK_OPTION);

        File file = new File(filePath);
        assertTrue(file.isFile());

        table.getModel().setData(null);
        assertTrue(table.getModel().getData().isEmpty());

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                menu.loadDataFromFile(filePath, table.getModel());
            }
        });
        testMessageDialog(menu.getParentFrame(), JOptionPane.OK_OPTION);

        assertTrue(file.delete());

        assertFalse(table.getModel().getData().isEmpty());
        assertEquals(originalData, table.getModel().getData());
    }

    @Test
    @DisplayName("Load Fail Test (Wrong Path)")
    public void loadFailWrongPath() throws InterruptedException {
        CTable table = new CTable("Test", null);
        JFrame frame = new JFrame();
        Menu menu = new Menu(frame, table);

        String wrongFilePath = "./Save.txt";
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                menu.loadDataFromFile(wrongFilePath, table.getModel());
            }
        });
        testMessageDialog(menu.getParentFrame(), JOptionPane.OK_OPTION);
    }
}
