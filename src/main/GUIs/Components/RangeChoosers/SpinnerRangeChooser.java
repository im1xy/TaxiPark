package main.GUIs.Components.RangeChoosers;

import javax.swing.*;

public class SpinnerRangeChooser extends RangeChooser {
    private JPanel mainPanel;
    private JSpinner fromSpinner;
    private JSpinner toSpinner;

    public SpinnerRangeChooser(int minValue, int maxValue) {
        this.fromSpinner.setModel(new SpinnerNumberModel(minValue, minValue, maxValue, 1));
        this.toSpinner.setModel(new SpinnerNumberModel(minValue, minValue, maxValue, 1));
    }

    @Override
    public Integer[] getSelectedRange() {
        return new Integer[] {(Integer) fromSpinner.getValue(), (Integer) toSpinner.getValue()};
    }

    @Override
    public void resetChooser() {
        this.fromSpinner.setValue(0);
        this.toSpinner.setValue(0);
    }

    @Override
    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public JSpinner getFromSpinner() {
        return fromSpinner;
    }

    public JSpinner getToSpinner() {
        return toSpinner;
    }
}
