package main.GUIs;

import javax.swing.*;
import java.awt.*;

public interface MessageDialogs {
    static void showErrorMessageDialog(Component parent, String message) {
        JOptionPane.showMessageDialog(parent,
                message, "Something went WRONG!", JOptionPane.ERROR_MESSAGE);
    }

    static void showSuccessMessageDialog(Component parent, String message) {
        JOptionPane.showMessageDialog(parent,
                message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    static int showErrorOptionDialog(Component parent, String title, String message) {
        return JOptionPane.showOptionDialog(parent, message, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
                null, null, null);
    }

    static int showQuestionOptionDialog(Component parent, String title, String message) {
        return JOptionPane.showOptionDialog(parent, message, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, null, null);
    }
}
