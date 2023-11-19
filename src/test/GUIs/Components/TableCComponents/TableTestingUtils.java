package test.GUIs.Components.TableCComponents;

import main.Cars.Car;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class TableTestingUtils {
    public static void compareData(Vector<Car> expected, Vector<Car> result) {
        assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++)
            assertEquals(expected.elementAt(i), result.elementAt(i));
    }
}
