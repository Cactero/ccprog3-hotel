package main;

import javax.swing.*;

public abstract class AbstractView extends JPanel {
    protected JPanel contentHolder;

    public JPanel getContentHolder() {
        return contentHolder;
    }
}
