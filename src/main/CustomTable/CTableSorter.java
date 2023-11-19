package main.CustomTable;

import main.Cars.Car;

import java.util.Collections;
import java.util.function.Function;

public class CTableSorter {
    private CTable table;
    public CTableSorter(CTable table) {
        this.table = table;
    }
    public void sortData(Function<? super Car, ? > criteria, boolean ascendingOrder) {
        this.table.getModel().getData().sort((car1, car2) -> {
            Object value1 = criteria.apply(car1);
            Object value2 = criteria.apply(car2);
            if (value1 == null)
                return ascendingOrder ? 1 : -1;
            else if (value2 == null)
                return ascendingOrder ? -1 : 1;

            if (value1 instanceof Integer && value2 instanceof Integer)
                return ((Integer) value1).compareTo((Integer) value2);
            else if (value1 instanceof String && value2 instanceof String)
                return ((String) value1).toLowerCase().compareTo(((String) value2).toLowerCase());
            else if (value1 instanceof Boolean && value2 instanceof Boolean)
                return ((Boolean) value1).compareTo((Boolean) value2);
            else
                return 0;
        });

        if (!ascendingOrder) // To move nulls at the end
            Collections.reverse(this.table.getModel().getData());

        this.table.getModel().fireTableStructureChanged();
    }
}
