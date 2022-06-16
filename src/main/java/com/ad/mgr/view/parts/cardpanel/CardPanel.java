package com.ad.mgr.view.parts.cardpanel;


import com.ad.mgr.view.parts.cardpanel.parts.buttons.CardButtons;
import com.ad.mgr.view.parts.cardpanel.parts.buttons.CardButtonsConnector;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel implements CardButtonsConnector {

    CardButtons cardButtons = new CardButtons(this);
    public CardPanel(){
        setLayout(new BorderLayout());
        add(new JLabel("CardPanel"), BorderLayout.NORTH);

        JPanel panel = new JPanel();
        var gridLayout = new GridLayout(1, 0);
        panel.setLayout(gridLayout);

        setBorder(BorderFactory.createEmptyBorder(50, 30, 50, 10));

        panel.add(new CardTableRight());
        panel.add(new CardTableLeft());
//        panel.add(Box.createHorizontalBox());

        add(panel);
        add(cardButtons, BorderLayout.SOUTH);
    }

    @Override
    public void userActionButtonClicked() {

    }

    @Override
    public void deleteButtonClicked() {

    }
}
