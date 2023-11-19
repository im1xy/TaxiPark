package main.GUIs.Components.RangeChoosers;
import main.GUIs.Components.CComponent;

abstract public class RangeChooser extends CComponent {
    abstract public Integer[] getSelectedRange();
    abstract public void resetChooser();
}
