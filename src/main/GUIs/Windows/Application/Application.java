package main.GUIs.Windows.Application;
import main.GUIs.Windows.CarDialog.CarDialog;
import test.GUIs.Components.TableCComponents.TableFilter.TableFilterTestingUtils;

public class Application extends ApplicationComponents {
    public Application() {
        super();
        this.setButtonsActions();
    }

    @Override
    public void setButtonsActions() {
        this.menuPanelButton.addActionListener((event) -> this.showORCloseMenu());
        this.addButton.addActionListener((event) -> this.openCarDialog());
        this.filterPanelButton.addActionListener((event) -> this.showOrCloseFilter());
        this.sortPanelButton.addActionListener((event) -> this.showORCloseSort());
    }

    private void showORCloseMenu() {
        this.menuPanel.setVisible(!this.menuPanel.isVisible());
        this.leftSidePanel.updateUI();
    }

    private void showOrCloseFilter() {
        this.filterPanel.setVisible(!this.filterPanel.isVisible());
        this.showOrCloseRightPanel();
    }

    private void showORCloseSort() {
        this.sortPanel.setVisible(!this.sortPanel.isVisible());
        this.showOrCloseRightPanel();
    }

    private void showOrCloseRightPanel() {
        this.rightSidePanel.setVisible(this.filterPanel.isVisible() || this.sortPanel.isVisible());
        this.rightSidePanel.updateUI();
    }

    private void openCarDialog() {
        CarDialog dialog = new CarDialog(this.infoTable, null, CarDialog.ADD_MODE);
        dialog.setVisible(true);
    }
}
