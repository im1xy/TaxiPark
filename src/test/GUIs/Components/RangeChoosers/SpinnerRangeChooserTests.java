package test.GUIs.Components.RangeChoosers;

import main.GUIs.Components.RangeChoosers.SpinnerRangeChooser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpinnerRangeChooserTests {
    @Test
    @DisplayName("Right Range Values Test")
    public void rightRangeValues () {
        Integer[] expected = {0, 20};
        SpinnerRangeChooser rangeChooser = new SpinnerRangeChooser(0, 50);
        rangeChooser.getFromSpinner().setValue(0);
        rangeChooser.getToSpinner().setValue(20);
        Integer[] result = rangeChooser.getSelectedRange();

        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
    }
}
