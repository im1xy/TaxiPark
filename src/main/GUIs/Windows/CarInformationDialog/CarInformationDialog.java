package main.GUIs.Windows.CarInformationDialog;

import main.Cars.Car;
import main.GUIs.Windows.CWindow;

import javax.swing.*;

import static main.Tools.*;

public class CarInformationDialog extends JDialog implements CWindow {
    private JPanel mainPanel;
    private JScrollPane infoScrollPanel;
    private JPanel infoPanel;
    private JLabel nameN;
    private JLabel brandN;
    private JLabel typeN;
    private JLabel priceN;
    private JLabel prodYearN;
    private JLabel yearsInUseN;
    private JLabel weightN;
    private JLabel wheelDiameterN;
    private JLabel maxSpeedN;
    private JLabel fuelCapacityN;
    private JLabel fuelUsePer100kmN;
    private JLabel classN;
    private JLabel availabilityN;
    private Car car;
    public CarInformationDialog(Car car) {
        this.car = car;

        this.setWindowSettings();
        this.setComponentsSettings();
    }

    @Override
    public void setWindowSettings() {
        this.setTitle(this.car.getBrand() + " " + this.car.getName() + " Full Information");
        this.setIconImage(new ImageIcon("./src/main/Icons/taxi.png").getImage());
        this.setContentPane(mainPanel);
        this.setAlwaysOnTop(true);
        this.setSize(300, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setModal(false);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void setComponentsSettings() {
        this.brandN.setText(this.car.getBrand());
        this.nameN.setText(this.car.getName());
        this.typeN.setText(this.car.getType());
        this.classN.setText(this.car.getCarClass());
        this.priceN.setText(nonNullString(this.car.getPrice()));
        this.availabilityN.setText(this.car.isAvailable() ? "Available" : "Not Available");
        this.prodYearN.setText(nonNullString(this.car.getProductionYear()));
        this.yearsInUseN.setText(nonNullString(this.car.getYearsInUse()));
        this.weightN.setText(nonNullString(this.car.getWeight()));
        this.wheelDiameterN.setText(nonNullString(this.car.getWheelDiameter()));
        this.maxSpeedN.setText(nonNullString(this.car.getMaximumSpeed()));
        this.fuelCapacityN.setText(nonNullString(this.car.getFuelCapacity()));
        this.fuelUsePer100kmN.setText(nonNullString(this.car.getFuelUsePer100km()));
    }

    @Override
    public void setButtonsActions() {}
}
