package test.GUIs.Components.TableCComponents.TableFilter;

import main.Cars.Car;
import java.util.Vector;

import static test.testCarData.*;

public class TableFilterTestingUtils {
    public static Vector<Car> getTestData() {
        Vector<Car> vector = new Vector<>();
        vector.add(testAudiPetrolCar);
        vector.add(testTeslaElectricCar);
        vector.add(testOpelGasCar);
        vector.add(testBugattiPetrolCar);
        vector.add(testPorscheElectricCar);
        vector.add(testAlfaRomeoGasCar);
        return vector;
    }
}
