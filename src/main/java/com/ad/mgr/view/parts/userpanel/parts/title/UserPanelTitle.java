package com.ad.mgr.view.parts.userpanel.parts.title;

import com.ad.mgr.view.parts.userpanel.config.UserPanelConfig;

import javax.swing.*;

public class UserPanelTitle extends JLabel {

    public UserPanelTitle(UserPanelConfig userPanelConfig){
        super(userPanelConfig.isAddMode() ? "Wprowadz dane" : "Edytuj dane");
        setBorder(BorderFactory.createEmptyBorder(10, 1, 20, 1));
    }
}
