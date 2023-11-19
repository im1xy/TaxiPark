package main.GUIs.Components.TableCComponents.TableSorter;

import main.GUIs.Components.CComponent;

import javax.swing.*;
import java.awt.*;

abstract class TableSorterComponents extends CComponent {
    protected JPanel mainPanel;
    protected JScrollPane sortScrollPanel;
    protected JPanel sortPanel;
    protected JButton brandButton;
    protected JButton nameButton;
    protected JButton priceButton;
    protected JButton prodYearButton;
    protected JButton useYearsButton;
    protected JButton weightButton;
    protected JButton wheelDiamButton;
    protected JButton maxSpeedButton;
    protected JButton typeButton;
    protected JButton fuelCapacityButton;
    protected JButton fuelUsePer100kmButton;
    protected JButton orderButton;
    protected JButton classButton;
    protected JButton availabilityButton;

    public TableSorterComponents() {
        this.setComponentsSettings();
    }

    @Override
    protected void setComponentsSettings() {
        this.sortScrollPanel.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        this.sortScrollPanel.getVerticalScrollBar().setUnitIncrement(10);
    }
    @Override
    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
