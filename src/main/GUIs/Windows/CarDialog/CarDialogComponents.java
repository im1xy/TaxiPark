package main.GUIs.Windows.CarDialog;

import javax.swing.*;

import main.Cars.AvailableCars;
import main.GUIs.Windows.CWindow;

import java.util.Vector;

import static main.Tools.*;

abstract class CarDialogComponents extends JDialog implements CWindow {
    protected JTextField brandTextField;
    protected JTextField nameTextField;
    protected JTextField priceTextField;
    protected JComboBox<String> typeComboBox;
    protected JPanel windowPanel;
    protected JPanel inputPanel;
    protected JPanel buttonsPanel;
    protected JButton okButton;
    protected JButton clearButton;
    protected JPanel mainInfoInputPanel;
    protected JPanel additionalInfoInputPanel;
    protected JTextField yearsInUseTextField;
    protected JTextField weightTextField;
    protected JTextField wheelDiameterTextField;
    protected JTextField maximumSpeedTextField;
    protected JTextField fuelCapacityTextField;
    protected JTextField fuelUseTextField;
    protected JComboBox<Integer> prodYearComboBox;
    protected JComboBox<String> classComboBox;
    protected JRadioButton availableRadioButton;
    protected JButton cancelButton;

    public CarDialogComponents(int mode) {
        this.setWindowTitle(mode);
        this.setWindowSettings();
        this.setComponentsSettings();
    }

    public void setWindowTitle(int mode) {
        if (mode == CarDialog.ADD_MODE)
            this.setTitle("Add Car Information");
        else if (mode == CarDialog.EDIT_MODE)
            this.setTitle("Update Car Information");
    }

    @Override
    public void setWindowSettings() {
        this.setIconImage(new ImageIcon("./src/main/Icons/taxi.png").getImage());
        this.setContentPane(windowPanel);
        this.setAlwaysOnTop(true);
        this.setSize(550, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setModal(true);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void setComponentsSettings() {
        this.typeComboBox.setModel(new DefaultComboBoxModel<>(AvailableCars.getCarTypes()));
        this.classComboBox.setModel(new DefaultComboBoxModel<>(AvailableCars.getCarClasses()));

        Vector<Integer> range = getRange(yearFrom, yearNow, true);
        range.add(0, null);
        this.prodYearComboBox.setModel(new DefaultComboBoxModel<>(range));
    }
}
