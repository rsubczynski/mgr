package com.ad.mgr.view.parts.cardpanel.parts.config;

import com.ad.mgr.view.parts.userpanel.config.UserPanelMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CardPanelConfig {

    private Long cardId;

    private CardPanelMode cardPanelMode;

    public boolean isAddMode(){
        return cardPanelMode.equals(CardPanelMode.ADD);
    }

}
