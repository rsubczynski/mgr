package com.ad.mgr.view.parts.userpanel.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class UserPanelConfig {

    private Long id;

    private UserPanelMode userPanelMode;

    public boolean isAddMode(){
        return userPanelMode.equals(UserPanelMode.ADD);
    }

}
