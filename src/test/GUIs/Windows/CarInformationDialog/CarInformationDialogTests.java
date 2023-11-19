package test.GUIs.Windows.CarInformationDialog;

import main.Cars.Car;
import main.GUIs.Windows.CarInformationDialog.CarInformationDialog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.GUIs.Windows.CarInformationDialog.CarInformationDialogTestingUtils.getCar;
import static test.testCarData.*;

public class CarInformationDialogTests {
    @Test
    @DisplayName("Correct Values Test")
    public void correctValues() {
        Car expected = testOpelGasCar;
        CarInformationDialog dialog = new CarInformationDialog(expected);
        Car result = getCar(dialog);
        assertEquals(expected, result);
    }
}
