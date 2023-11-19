package main.GUIs.Components.Cell;

import main.GUIs.Components.CComponent;

import javax.swing.*;
import java.awt.*;

abstract class CellComponents extends CComponent {
    protected JPanel mainPanel;
    protected JPanel mainInfoPanel;
    protected JPanel buttonsPanel;
    protected JLabel brandN;
    protected JLabel nameN;
    protected JLabel typeN;
    protected JLabel priceN;
    protected JButton editButton;
    protected JButton deleteButton;
    protected JPanel additionalInfoPanel;
    protected JScrollPane additionalInfoScrollPanel;
    protected JPanel characteristicsLabelsPanel;
    protected JPanel characteristicsValuesPanel;
    protected JLabel yearsInUseN;
    protected JLabel weightN;
    protected JLabel wheelDiameterN;
    protected JLabel maximumSpeedN;
    protected JLabel fuelCapacityN;
    protected JLabel fuelUseN;
    protected JLabel prodYearN;
    protected JButton moreButton;
    protected JLabel classN;
    protected JRadioButton availableRadioButton;

    public CellComponents() {
        this.setComponentsSettings();
    }

    @Override
    protected void setComponentsSettings() {
        this.additionalInfoScrollPanel.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        this.additionalInfoScrollPanel.getVerticalScrollBar().setUnitIncrement(10);
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
