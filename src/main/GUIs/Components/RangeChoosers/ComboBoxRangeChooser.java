package main.GUIs.Components.RangeChoosers;

import javax.swing.*;
import java.util.Optional;
import java.util.Vector;

public class ComboBoxRangeChooser extends RangeChooser {
    private JComboBox<Integer> fromComboBox;
    private JComboBox<Integer> toComboBox;
    private JPanel mainPanel;

    public ComboBoxRangeChooser(Vector<Integer> range) {
        this.fromComboBox.setModel(new DefaultComboBoxModel<>(range));
        this.toComboBox.setModel(new DefaultComboBoxModel<>(range));
    }

    @Override
    public Integer[] getSelectedRange() {
        return new Integer[] {(Integer) Optional.ofNullable(fromComboBox.getSelectedItem()).orElse(0),
                (Integer) Optional.ofNullable(toComboBox.getSelectedItem()).orElse(0)};
    }

    @Override
    public void resetChooser() {
        this.toComboBox.setSelectedItem(null);
        this.fromComboBox.setSelectedItem(null);
    }

    @Override
    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public JComboBox<Integer> getFromComboBox() {
        return fromComboBox;
    }

    public JComboBox<Integer> getToComboBox() {
        return toComboBox;
    }
}
