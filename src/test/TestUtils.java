package test;

import javax.swing.*;
import java.awt.*;

abstract public class TestUtils {
    static int counter;
    public static Component getChildNamed(Component parent, String name) {
        if (name.equals(parent.getName())) {
            return parent;
        }
        if (parent instanceof Container) {
            Component[] children = ((Container) parent).getComponents();

            for (Component component : children) {
                Component child = getChildNamed(component, name);
                if (child != null) {
                    return child;
                }
            }
        }
        return null;
    }

    public static Component getChildIndexed(Component parent, String klass, int index) {
        counter = 0;
        if (parent instanceof Window) {
            Component[] children = ((Window) parent).getOwnedWindows();
            for (Component component : children) {
                if (component instanceof Window && !((Window) component).isActive()) {
                    continue;
                }
                Component child = getChildIndexedInternal(component, klass, index);
                if (child != null) {
                    return child;
                }
            }

        }
        return null;
    }

    private static Component getChildIndexedInternal(Component parent, String klass, int index) {
        if (parent.getClass().toString().endsWith(klass)) {
            if (counter == index) {
                return parent;
            }
            ++counter;
        }

        if (parent instanceof Container) {
            Component[] children = (parent instanceof JMenu) ?
                    ((JMenu) parent).getMenuComponents() : ((Container) parent).getComponents();
            for (Component component : children) {
                Component child = getChildIndexedInternal(component, klass, index);
                if (child != null) {
                    return child;
                }
            }
        }
        return null;
    }
}