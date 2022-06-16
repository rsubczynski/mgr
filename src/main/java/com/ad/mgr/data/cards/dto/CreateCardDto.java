package com.ad.mgr.data.cards.dto;

import com.ad.mgr.data.cards.entity.AccessPlaces;

import java.time.LocalDate;
import java.util.Set;

public record CreateCardDto (Set<AccessPlaces> accessPlaces, LocalDate expirationDate, byte[] image){
}
