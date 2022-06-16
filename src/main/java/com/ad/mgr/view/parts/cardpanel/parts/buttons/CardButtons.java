package com.ad.mgr.view.parts.cardpanel.parts.buttons;

import com.ad.mgr.view.parts.userpanel.config.UserPanelConfig;

import javax.swing.*;
import java.awt.*;

public class CardButtons extends JPanel {

    private final JButton userActionButton;
    private final JButton deleteButton = new JButton("Usuń dane");

    public CardButtons(CardButtonsConnector buttonsConnector) {
        userActionButton = new JButton("Zapisz kartę");
        setLayout(new FlowLayout());
        add(userActionButton);
        add(deleteButton);
        setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 200));
        userActionButton.addActionListener(event -> buttonsConnector.userActionButtonClicked());
        deleteButton.addActionListener(event -> buttonsConnector.deleteButtonClicked());
    }

}