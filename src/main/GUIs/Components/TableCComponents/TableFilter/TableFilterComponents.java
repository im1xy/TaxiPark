package main.GUIs.Components.TableCComponents.TableFilter;

import main.GUIs.Components.CComponent;
import main.GUIs.Components.RangeChoosers.ComboBoxRangeChooser;
import main.GUIs.Components.RangeChoosers.SpinnerRangeChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import main.Cars.AvailableCars;
import static main.Tools.*;

abstract class TableFilterComponents extends CComponent {
    protected JPanel mainPanel;
    protected JTextField nameTextField;
    protected JTextField brandTextField;
    protected JComboBox<String> typeComboBox;
    protected JPanel fuelUsePer100kmRangeChooserPanel;
    protected JPanel priceRangeChooserPanel;
    protected JPanel yearsInUseRangeChooserPanel;
    protected JPanel weightRangeChooserPanel;
    protected JPanel wheelDiameterRangeChooserPanel;
    protected JPanel maxSpeedRangeChooserPanel;
    protected JPanel fuelCapacityRangeChooserPanel;
    protected JScrollPane scrollPanel;
    protected JPanel filterPanel;
    protected JButton doneButton;
    protected JPanel prodYearRangeChooserPanel;
    protected JButton clearButton;
    protected JPanel buttonsPanel;
    protected JButton resetButton;
    protected JPanel filterInputPanel;
    protected JComboBox<String> classComboBox;
    protected JComboBox<String> availableComboBox;

    // RangeChoosers
    protected SpinnerRangeChooser priceRangeChooser;
    protected ComboBoxRangeChooser prodYearRangeChooser;
    protected SpinnerRangeChooser yearsInUseRangeChooser;
    protected SpinnerRangeChooser weightRangeChooser;
    protected SpinnerRangeChooser wheelDiameterRangeChooser;
    protected SpinnerRangeChooser maxSpeedRangeChooser;
    protected SpinnerRangeChooser fuelCapacityRangeChooser;
    protected SpinnerRangeChooser fuelUsePer100kmRangeChooser;

    public TableFilterComponents() {
        this.setComponentsSettings();
    }

    @Override
    protected void setComponentsSettings() {
        this.scrollPanel.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        this.scrollPanel.getVerticalScrollBar().setUnitIncrement(10);

        this.availableComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"", "Available", "Not Available"}));
        this.typeComboBox.setModel(new DefaultComboBoxModel<>(AvailableCars.getCarTypes()));
        this.classComboBox.setModel(new DefaultComboBoxModel<>(AvailableCars.getCarClasses()));
    }

    private void createUIComponents() {
        int minValue = 0, maxValue = Integer.MAX_VALUE;
        Vector<Integer> range = getRange(yearFrom, yearNow, true);
        range.add(0, null);

        this.priceRangeChooserPanel = new JPanel();
        this.prodYearRangeChooserPanel = new JPanel();
        this.yearsInUseRangeChooserPanel = new JPanel();
        this.weightRangeChooserPanel = new JPanel();
        this.wheelDiameterRangeChooserPanel = new JPanel();
        this.maxSpeedRangeChooserPanel = new JPanel();
        this.fuelCapacityRangeChooserPanel = new JPanel();
        this.fuelUsePer100kmRangeChooserPanel = new JPanel();

        this.priceRangeChooser = new SpinnerRangeChooser(minValue, maxValue);
        this.prodYearRangeChooser = new ComboBoxRangeChooser(range);
        this.yearsInUseRangeChooser = new SpinnerRangeChooser(minValue, maxValue);
        this.weightRangeChooser = new SpinnerRangeChooser(minValue, maxValue);
        this.wheelDiameterRangeChooser = new SpinnerRangeChooser(minValue, maxValue);
        this.maxSpeedRangeChooser = new SpinnerRangeChooser(minValue, maxValue);
        this.fuelCapacityRangeChooser = new SpinnerRangeChooser(minValue, maxValue);
        this.fuelUsePer100kmRangeChooser = new SpinnerRangeChooser(minValue, maxValue);

        this.addCustomComponent(this.priceRangeChooserPanel, this.priceRangeChooser);
        this.addCustomComponent(this.prodYearRangeChooserPanel, this.prodYearRangeChooser);
        this.addCustomComponent(this.yearsInUseRangeChooserPanel, this.yearsInUseRangeChooser);
        this.addCustomComponent(this.weightRangeChooserPanel, this.weightRangeChooser);
        this.addCustomComponent(this.wheelDiameterRangeChooserPanel, this.wheelDiameterRangeChooser);
        this.addCustomComponent(this.maxSpeedRangeChooserPanel, this.maxSpeedRangeChooser);
        this.addCustomComponent(this.fuelCapacityRangeChooserPanel, this.fuelCapacityRangeChooser);
        this.addCustomComponent(this.fuelUsePer100kmRangeChooserPanel, this.fuelUsePer100kmRangeChooser);
    }

    private void addCustomComponent(JPanel parentPanel, CComponent component) {
        parentPanel.add(component.getMainPanel());
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
