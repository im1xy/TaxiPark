package test.GUIs.Components.Menu;

import main.CustomTable.CTable;
import main.GUIs.Components.Menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static test.GUIs.CommonGUITests.testMessageDialog;
import static test.GUIs.Components.Menu.MenuTestingUtils.provokeInvokeLaterClick;
import static test.testCarData.*;

public class BasicFunctionsTests {
    @Test
    @DisplayName("New Table Test")
    public void newTable() throws InterruptedException {
        CTable table = new CTable("Test", null);
        JFrame frame = new JFrame();
        Menu menu = new Menu(frame, table);

        table.getModel().addRow(testAudiPetrolCar);

        provokeInvokeLaterClick(menu.getMainPanel(), "newTableButton");
        testMessageDialog(menu.getParentFrame(), JOptionPane.OK_OPTION);

        assertTrue(table.getModel().getData().isEmpty());
    }

    @Test
    @DisplayName("About Test")
    public void about() throws InterruptedException {
        Menu menu = new Menu(new JFrame(), null);

        provokeInvokeLaterClick(menu.getMainPanel(), "aboutButton");
        testMessageDialog(menu.getParentFrame(), JOptionPane.OK_OPTION);
    }

    @Test
    @DisplayName("Exit Test")
    public void exit() throws InterruptedException {
        JFrame frame = new JFrame();
        Menu menu = new Menu(frame, null);

        provokeInvokeLaterClick(menu.getMainPanel(), "exitButton");
        testMessageDialog(menu.getParentFrame(), JOptionPane.OK_OPTION);
        assertFalse(frame.isVisible());
    }
}
