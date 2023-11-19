package test.GUIs.Components.RangeChoosers;

import main.GUIs.Components.RangeChoosers.ComboBoxRangeChooser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static main.Tools.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ComboBoxRangeChooserTests {
    @Test
    @DisplayName("Right Range Values Test")
    public void rightRangeValues () {
        Integer[] expected = {0, 20};
        ComboBoxRangeChooser rangeChooser = new ComboBoxRangeChooser(getRange(0, 50, false));
        rangeChooser.getFromComboBox().setSelectedItem(0);
        rangeChooser.getToComboBox().setSelectedItem(20);
        Integer[] result = rangeChooser.getSelectedRange();

        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
    }

    @Test
    @DisplayName("Value that is not in Range Test")
    public void nonRangeValue () {
        Integer[] expected = {5, 20};
        ComboBoxRangeChooser rangeChooser = new ComboBoxRangeChooser(getRange(0, 50, false));
        rangeChooser.getFromComboBox().setSelectedItem(5);
        rangeChooser.getToComboBox().setSelectedItem(100);
        Integer[] result = rangeChooser.getSelectedRange();

        assertEquals(expected[0], result[0]);
        assertNotEquals(expected[1], result[1]);
        assertEquals(0, result[1]);
    }
}
