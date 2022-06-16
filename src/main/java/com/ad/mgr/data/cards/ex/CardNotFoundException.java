package com.ad.mgr.data.cards.ex;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(Long id){
        super(String.format("Card not found by id = %d", id));
    }
}
