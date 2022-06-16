package com.ad.mgr.data.cards.service;

import com.ad.mgr.data.cards.dto.CreateCardDto;
import com.ad.mgr.data.cards.dto.UpdateCardDto;
import com.ad.mgr.data.cards.entity.Card;
import com.ad.mgr.data.cards.repository.CardRepository;
import com.ad.mgr.data.cards.ex.CardNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card findCardById(Long cardId) {
        return cardRepository.findById(cardId).orElseThrow(() -> new CardNotFoundException(cardId));
    }

    @Override
    public Card createCard(CreateCardDto createCardDto) {
        return cardRepository.save(
                new Card(createCardDto.expirationDate(),
                        createCardDto.accessPlaces(),
                        createCardDto.image()));
    }

    @Override
    public Card updateCard(UpdateCardDto updateCardDto) {
        Card card = findCardById(updateCardDto.cardId());
        card.setAccessPlaces(updateCardDto.accessPlaces());
        card.setExpirationDate(updateCardDto.expirationDate());
        card.setImage(updateCardDto.image());
        return cardRepository.save(card);

    }

    @Override
    public void deleteCard(Long cardId) {
        cardRepository.deleteById(findCardById(cardId).getId());
    }
}
