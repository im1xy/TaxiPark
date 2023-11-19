package main;

import java.time.Year;
import java.util.Collections;
import java.util.Objects;
import java.util.Vector;

public interface Tools {
    Integer yearNow = Year.now().getValue();
    Integer yearFrom = 1950;
    static Vector<Integer> getRange(Integer from, Integer to, boolean reversed) {
        Vector<Integer> range = new Vector<>();
        for (int value = from; value <= to; value++)
            range.add(value);

        if (reversed)
            Collections.reverse(range);

        return range;
    }

    static String nonNullString(Object value) {
        return Objects.toString(value, "");
    }

    static Integer formatInteger(String value) {
        return value == null || value.isEmpty() ? null : Integer.parseInt(value);
    }
}
