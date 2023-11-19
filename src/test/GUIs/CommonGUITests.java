package test.GUIs;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static test.TestUtils.getChildIndexed;
import static test.TestUtils.getChildNamed;

public class CommonGUITests {
    public static void testMessageDialog(Component parent, int buttonToPress) throws InterruptedException {
        String buttonToPressText = UIManager.getString("OptionPane.okButtonText");
        if (buttonToPress == JOptionPane.CANCEL_OPTION)
            buttonToPressText = UIManager.getString("OptionPane.cancelButtonText");

        JButton button = null;
        for (int i = 0; button == null; ++i) {
            Thread.sleep(200);
            button = (JButton) getChildIndexed(parent, "JButton", 0);
            assertTrue(i < 10);
        }
        assertEquals(buttonToPressText, button.getText());

        button.doClick();
        Thread.sleep(200);
    }

    public static Component findComponent(Component parent, String componentName) {
        Component component = getChildNamed(parent, componentName);
        assertNotNull(component);
        return component;
    }
}
