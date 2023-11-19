package main.GUIs.Components.TableCComponents.TableFilter;

import main.CustomTable.CTable;
import main.CustomTable.CTableFilter;

import static main.Tools.nonNullString;

public class TableFilter extends TableFilterComponents {
    private CTable table;
    private CTableFilter filter;
    public TableFilter(CTable table) {
        super();
        this.table = table;
        this.filter = new CTableFilter(this.table);
        this.setButtonActions();
    }

    @Override
    protected void setButtonActions() {
        this.doneButton.addActionListener((event) -> this.filterData());
        this.resetButton.addActionListener((event) -> this.resetFilter());
        this.clearButton.addActionListener((event) -> this.clearFields());
    }

    private void filterData() {
        String brandCriteria = this.brandTextField.getText();
        String nameCriteria = this.nameTextField.getText();
        String typeCriteria = nonNullString(this.typeComboBox.getSelectedItem());
        String carClassCriteria = nonNullString(this.classComboBox.getSelectedItem());
        Integer[] priceRangeCriteria = this.priceRangeChooser.getSelectedRange();
        String isAvailableCriteria = nonNullString(this.availableComboBox.getSelectedItem());
        Integer[] prodYearCriteria = this.prodYearRangeChooser.getSelectedRange();
        Integer[] yearsInUseRangeCriteria = this.yearsInUseRangeChooser.getSelectedRange();
        Integer[] weightRangeCriteria = this.weightRangeChooser.getSelectedRange();
        Integer[] wheelDiameterRangeCriteria = this.wheelDiameterRangeChooser.getSelectedRange();
        Integer[] maxSpeedRangeCriteria = this.maxSpeedRangeChooser.getSelectedRange();
        Integer[] fuelCapacityRangeCriteria = this.fuelCapacityRangeChooser.getSelectedRange();
        Integer[] fuelOn100kmRangeCriteria = this.fuelUsePer100kmRangeChooser.getSelectedRange();

        this.filter.filterData(brandCriteria,nameCriteria,typeCriteria,carClassCriteria,priceRangeCriteria,
                isAvailableCriteria,prodYearCriteria,yearsInUseRangeCriteria,weightRangeCriteria,
                wheelDiameterRangeCriteria,maxSpeedRangeCriteria,fuelCapacityRangeCriteria,fuelOn100kmRangeCriteria);
    }

    private void resetFilter() {
        this.filter.reset();
    }

    private void clearFields() {
        this.brandTextField.setText(null);
        this.nameTextField.setText(null);
        this.typeComboBox.setSelectedItem(null);
        this.classComboBox.setSelectedItem(null);
        this.priceRangeChooser.resetChooser();
        this.availableComboBox.setSelectedItem(null);
        this.prodYearRangeChooser.resetChooser();
        this.yearsInUseRangeChooser.resetChooser();
        this.weightRangeChooser.resetChooser();
        this.wheelDiameterRangeChooser.resetChooser();
        this.maxSpeedRangeChooser.resetChooser();
        this.fuelCapacityRangeChooser.resetChooser();
        this.fuelUsePer100kmRangeChooser.resetChooser();
    }

    public CTableFilter getFilter() {
        return filter;
    }
}
