package com.ad.mgr.view.parts.cardpanel.parts.checkboxes;

import javax.swing.*;
import java.awt.*;

public class CheckboxListCellRenderer extends JCheckBox implements ListCellRenderer<String> {

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {

        setSelected(isSelected);
        setEnabled(list.isEnabled());

        setText(value == null ? "" : value);
        return this;
    }
}
