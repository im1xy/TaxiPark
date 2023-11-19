package main.GUIs.Windows.Application;

import main.CustomTable.CTable;
import main.GUIs.Components.CComponent;
import main.GUIs.Components.Menu.Menu;
import main.GUIs.Components.Statistics.Statistics;
import main.GUIs.Components.TableCComponents.TableFilter.TableFilter;
import main.GUIs.Components.TableCComponents.TableSorter.TableSorter;
import main.GUIs.Windows.CWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static main.GUIs.MessageDialogs.showQuestionOptionDialog;

abstract class ApplicationComponents extends JFrame implements CWindow {
    // Window Panel
    protected JPanel windowPanel;
    protected JPanel mainPanel;
    protected JPanel leftSidePanel;
    protected JPanel rightSidePanel;

    // Menu
    protected JPanel menuPanel;
    protected Menu menu;

    // Table Sorter
    protected JPanel sortPanel;
    protected TableSorter tableSorter;

    // Table Filter
    protected JPanel filterPanel;
    protected TableFilter tableFilter;

    // Open/Close Panels Buttons
    protected JButton filterPanelButton;
    protected JButton sortPanelButton;
    protected JButton menuPanelButton;

    // Statistics
    protected JPanel statisticsPanel;
    protected Statistics statistics;

    // Main Panel
    protected JButton addButton;
    protected CTable infoTable;
    protected JScrollPane tableScrollPanel;
    protected JPanel actionPanel;

    public ApplicationComponents() {
        this.setWindowSettings();
        this.setComponentsSettings();
    }

    @Override
    public void setWindowSettings() {
        this.setTitle("TaxiPark");
        this.setIconImage(new ImageIcon("./src/main/Icons/taxi.png").getImage());
        this.setContentPane(windowPanel);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(1250, 850));

        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() { @Override public void windowClosing(WindowEvent e) { closeWindow(); }});
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void setComponentsSettings() {
        this.infoTable.setName("infoTable");
        this.infoTable.getModel().setDefaultDataLogger();
    }

    private void closeWindow() {
        if (showQuestionOptionDialog(this,
                "Exit?","Are You Sure to Close Application?") == 0)
            this.dispose();
    }

    private void createUIComponents() {
        this.infoTable = new CTable("Car's Information", null);
        this.menuPanel = new JPanel();
        this.sortPanel = new JPanel();
        this.filterPanel = new JPanel();
        this.statisticsPanel = new JPanel();

        this.menu = new Menu(this, this.infoTable);
        this.tableSorter = new TableSorter(this.infoTable);
        this.tableFilter = new TableFilter(this.infoTable);
        this.statistics = new Statistics(this.infoTable);

        this.addCustomComponent(this.menuPanel, this.menu);
        this.addCustomComponent(this.sortPanel, this.tableSorter);
        this.addCustomComponent(this.filterPanel, this.tableFilter);
        this.addCustomComponent(this.statisticsPanel, this.statistics);
    }

    private void addCustomComponent(JPanel parentPanel, CComponent component) {
        parentPanel.add(component.getMainPanel());
    }
}
