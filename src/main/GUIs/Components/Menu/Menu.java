package main.GUIs.Components.Menu;

import main.Cars.Car;
import main.CustomTable.CTable;
import main.CustomTable.CTableModel;
import main.Mailer.Mailer;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Vector;

import static main.GUIs.MessageDialogs.*;

public class Menu extends MenuComponents {
    private JFrame parentFrame;
    private CTable table;
    public Menu(JFrame parentFrame, CTable table) {
        this.parentFrame = parentFrame;
        this.table = table;

        this.setButtonActions();
    }

    @Override
    protected void setButtonActions() {
        this.newTableButton.addActionListener((event) -> this.createNewTable());
        this.saveButton.addActionListener((event) -> this.openSaveWindow());
        this.loadButton.addActionListener((event) -> this.openLoadWindow());
        this.aboutButton.addActionListener((event) -> this.openAboutWindow());
        this.exitButton.addActionListener((event) -> this.closeWindow());
    }

    private void closeWindow() {
        if (showQuestionOptionDialog(this.parentFrame,
                "Exit?","Are You Sure to Close Application?") == 0)
            this.parentFrame.dispose();
    }

    private void createNewTable() {
        if (this.table.getModel().getRowCount() != 0 &&
                showQuestionOptionDialog(this.parentFrame, "Confirm",
                        "All unsaved data will be lost!\nAre you sure to continue?") != 0) {
                return;
        }
        this.table.getModel().setData(null);
    }

    private void openSaveWindow() {
        CTableModel model = this.table.getModel();
        if (model.getData().isEmpty()) {
            showErrorMessageDialog(this.parentFrame, "There is no data to save.");
            return;
        }

        FileDialog fileDialog = new FileDialog(this.parentFrame, "Choose Directory to Save", FileDialog.SAVE);
        fileDialog.setDirectory("C:\\");
        fileDialog.setVisible(true);

        String filePath = fileDialog.getFile();
        if (filePath == null)
            return;

        this.writeDataToFile(filePath, model);
    }

    private void openLoadWindow() {
        FileDialog fileDialog = new FileDialog(this.parentFrame, "Choose File to Load", FileDialog.LOAD);
        fileDialog.setDirectory("C:\\");
        fileDialog.setVisible(true);

        String filePath = fileDialog.getFile();
        if (filePath == null)
            return;

        this.loadDataFromFile(filePath, this.table.getModel());
    }

    private void openAboutWindow() {
        JOptionPane.showMessageDialog(this.parentFrame,
                """
                         Created by: Mamrak Artem
                         Group: OI-22
                         """, "About", JOptionPane.INFORMATION_MESSAGE);
    }

    public void loadDataFromFile(String filePath, CTableModel model) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            objectInputStream = new ObjectInputStream(fileInputStream);
            model.setData((Vector<Car>) objectInputStream.readObject());

            showSuccessMessageDialog(this.parentFrame, "The data is loaded successfully!");
        }
        catch (FileNotFoundException e) {
            showErrorMessageDialog(this.parentFrame, "Could not find the save file");
            e.fillInStackTrace();
        }
        catch (IOException | ClassNotFoundException e) {
            String title = "Load Error";
            if (showErrorOptionDialog(this.parentFrame, title,
                    "Could not open the save file\n" +
                            "Would you like to send an error mail with file to dev?") == 0) {
                this.mailError(title, "Could not open following file to load data.", filePath);
            }
            e.fillInStackTrace();
        } finally {
            try {
                fileInputStream.close();
                objectInputStream.close();
            }
            catch (IOException | NullPointerException e) {
                e.fillInStackTrace();
            }
        }
    }

    public void writeDataToFile(String filePath, CTableModel model) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(model.getData());

            showSuccessMessageDialog(this.parentFrame, "The data is saved successfully!");
        }
        catch (IOException e) {
            String title = "Save Error";
            if (showErrorOptionDialog(this.parentFrame, title,
                    "Could not create a save file\n" +
                            "Would you like to send error mail to dev?") == 0) {
                this.mailError(title, "Could not create file to load data.", null);
            }
            e.fillInStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            }
            catch (IOException | NullPointerException e) {
                e.fillInStackTrace();
            }
        }
    }

    private void mailError(String subject, String messageText, String filePath) {
        try {
            new Mailer().sendMessage(subject, messageText, new File(filePath));
        }
        catch (IOException | MessagingException e) {
            showErrorMessageDialog(this.parentFrame, "Could not send an Email.");
            e.fillInStackTrace();
        }
    }

    public JFrame getParentFrame() {
        return parentFrame;
    }
}
