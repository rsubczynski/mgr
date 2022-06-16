package com.ad.mgr.view.parts.userpanel.parts.buttons;

import com.ad.mgr.view.parts.userpanel.config.UserPanelConfig;

import javax.swing.*;
import java.awt.*;

public class UserButtons extends JPanel {

    private final JButton userActionButton;
    private final JButton deleteButton = new JButton("Usuń dane");

    public UserButtons(UserButtonsConnector buttonsConnector, UserPanelConfig userPanelConfig) {
        userActionButton = new JButton(getActionUserButtonName(userPanelConfig));
        setLayout(new FlowLayout());
        add(userActionButton);
        add(deleteButton);
        setBorder(BorderFactory.createEmptyBorder(30, 1, 1, 1));
        userActionButton.addActionListener(event -> buttonsConnector.userActionButtonClicked());
        deleteButton.addActionListener(event -> buttonsConnector.deleteButtonClicked());
    }

    private String getActionUserButtonName(UserPanelConfig userPanelConfig) {
        return userPanelConfig.isAddMode() ? "Utwórz pracownika" : "Aktualizuj Pracownika";
    }
}