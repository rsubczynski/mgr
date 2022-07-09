package com.ad.mgr.view.parts.cardpanel;


import com.ad.mgr.data.cards.dto.CreateCardDto;
import com.ad.mgr.data.cards.dto.UpdateCardDto;
import com.ad.mgr.data.cards.entity.Card;
import com.ad.mgr.data.cards.service.CardService;
import com.ad.mgr.view.parts.cardpanel.parts.buttons.CardButtons;
import com.ad.mgr.view.parts.cardpanel.parts.buttons.CardButtonsConnector;
import com.ad.mgr.view.parts.cardpanel.parts.config.CardPanelConfig;

import javax.swing.*;

public class CardPanel extends JPanel implements CardButtonsConnector, CardLeftPanelConnector {

    private CardPanelConfig cardPanelConfig;
    private final JLabel title = new JLabel("Tworzenie karty");
    private final CardTableLeft leftTable = new CardTableLeft(this);
    private final CardTableRight rightTable = new CardTableRight();
    private final CardButtons cardButtons = new CardButtons(this);

    private final CardPanelConnector cardPanelConnector;

    private final CardService cardService;

    public CardPanel(CardService cardService, CardPanelConnector cardPanelConnector) {
        this.cardPanelConnector = cardPanelConnector;
        this.cardService = cardService;
        setLayout(null);
        addControls();
        setBounds();
    }

    private void setBounds() {
        title.setBounds(10, 40, 200, 50);
        leftTable.setBounds(10, 100, 320, 280);
        rightTable.setBounds(340, 100, 200, 280);
        cardButtons.setBounds(-10, 390, 250, 40);
    }

    private void addControls() {
        add(title);
        add(leftTable);
        add(rightTable);
        add(cardButtons);
    }

    public void setConfig(CardPanelConfig cardPanelConfig) {

        this.cardPanelConfig = cardPanelConfig;

        Card card = cardPanelConfig.isAddMode() ?
                new Card() : cardService.findCardById(cardPanelConfig.getCardId());

        leftTable.setData(card, cardPanelConfig);
        rightTable.setSelected(card);
    }

    @Override
    public void userActionButtonClicked() {
        long cardId;
        Card cardToSave = new Card();
        cardToSave.setExpirationDate(leftTable.getExpirationDate());
        cardToSave.setImage(leftTable.getImage());
        cardToSave.setAccessPlaces(rightTable.getAccessPlaces());

        if (!isValidCardData(cardToSave)) {
            JOptionPane.showMessageDialog(this, "Prosze uzupełnić wszystkie pola");
            return;
        }

        if (cardPanelConfig.isAddMode()) {
            Card newCard = cardService.createCard(
                    new CreateCardDto(
                            cardToSave.getAccessPlaces(),
                            cardToSave.getExpirationDate(),
                            cardToSave.getImage()
                    ));
            cardId = newCard.getId();
        } else {
            cardService.updateCard(
                    new UpdateCardDto(cardPanelConfig.getCardId(),
                            cardToSave.getAccessPlaces(),
                            cardToSave.getExpirationDate(),
                            cardToSave.getImage()
                    ));
            cardId = cardPanelConfig.getCardId();
        }
        cardPanelConnector.userAddCardClicked(cardId);
    }

    private boolean isValidCardData(Card card) {
        return card.getExpirationDate() != null
                && !card.getAccessPlaces().isEmpty()
                && card.getImage() != null;
    }

    @Override
    public void deleteButtonClicked() {
        leftTable.cleanData();
        rightTable.cleanData();
    }


    @Override
    public boolean accessPlacesButtonClicked() {
        var accessPlacesVisible = !rightTable.isVisible();
        rightTable.setVisible(accessPlacesVisible);
        return accessPlacesVisible;
    }
}
