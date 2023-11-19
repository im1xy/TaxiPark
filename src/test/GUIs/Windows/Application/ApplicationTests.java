package test.GUIs.Windows.Application;

import main.GUIs.Windows.Application.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.File;

import static test.GUIs.CommonGUITests.findComponent;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTests {
    @Test
    @DisplayName("Right Side Panel Visibility Test")
    public void rightSidePanelVisibility() throws InterruptedException {
        Application app = new Application();
        assertNotNull(app);

        JPanel rightSidePanel = (JPanel) findComponent(app, "rightSidePanel");
        JButton filterButton = (JButton) findComponent(app, "filterButton");
        JButton sortButton = (JButton) findComponent(app, "sortButton");

        filterButton.doClick();
        assertTrue(rightSidePanel.isVisible());
        filterButton.doClick();

        sortButton.doClick();
        assertTrue(rightSidePanel.isVisible());
        sortButton.doClick();

        filterButton.doClick();
        sortButton.doClick();
        assertFalse(rightSidePanel.isVisible());
    }

    @Test
    @DisplayName("Menu Visibility Test")
    public void menuVisibility() {
        Application app = new Application();
        assertNotNull(app);

        JPanel menuPanel = (JPanel) findComponent(app, "menuPanel");
        JButton menuButton = (JButton) findComponent(app, "menuButton");

        menuButton.doClick();
        assertFalse(menuPanel.isVisible());
    }
}
