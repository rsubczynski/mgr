package com.ad.mgr.data.cards.service;

import com.ad.mgr.data.cards.dto.CreateCardDto;
import com.ad.mgr.data.cards.dto.UpdateCardDto;
import com.ad.mgr.data.cards.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {

    List<Card> getAllCards();

    Card findCardById(Long cardId);

    Card createCard(CreateCardDto createCardDto);

    Card updateCard(UpdateCardDto updateCardDto);

    void deleteCard(Long cardId);

    List<Card> findAll();
}
