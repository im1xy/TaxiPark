package main.GUIs.Components.Menu;
import main.GUIs.Components.CComponent;

import javax.swing.*;

abstract class MenuComponents extends CComponent {
    protected JPanel menuOptionsPanel;
    protected JButton newTableButton;
    protected JButton saveButton;
    protected JButton loadButton;
    protected JButton aboutButton;
    protected JButton exitButton;
    protected JPanel mainPanel;
    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
