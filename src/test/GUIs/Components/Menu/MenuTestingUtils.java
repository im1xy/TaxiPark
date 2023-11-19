package test.GUIs.Components.Menu;

import javax.swing.*;
import java.awt.*;

import static test.GUIs.CommonGUITests.findComponent;

public class MenuTestingUtils {
    public static void provokeInvokeLaterClick(Component component, String buttonName) {
        JButton exitButton = (JButton) findComponent(component, buttonName);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                exitButton.doClick();
            }
        });
    }
}
