package com.ad.mgr.data.cards.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "cards")
@Getter
@Setter
public class Card {

    public Card() {
    }

    public Card(LocalDate expirationDate, Set<AccessPlaces> accessPlacesList, byte[] image) {
        this.expirationDate = expirationDate;
        setAccessPlaces(accessPlacesList);
        this.image = image;
    }

    Card(long id, LocalDate expirationDate, Set<AccessPlaces> accessPlacesList, byte[] image) {
        this.id = id;
        this.expirationDate = expirationDate;
        setAccessPlaces(accessPlacesList);
        this.image = image;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate expirationDate;

    @Column(name = "accessPlaces")
    private String accessPlaces;
    @Lob
    @Column(name = "image", columnDefinition="BLOB")
    private byte[] image;

    public Set<AccessPlaces> getAccessPlaces() {
        return (null == accessPlaces || accessPlaces.equals("")) ?
                Collections.emptySet() :
                Arrays.stream(accessPlaces.split(",")).map(AccessPlaces::fromString).collect(Collectors.toSet());
    }

    public void setAccessPlaces(Set<AccessPlaces> accessPlaces) {
        if (accessPlaces == null)
            this.accessPlaces = null;
        else
            this.accessPlaces = accessPlaces.stream().map(AccessPlaces::getLocation).collect(Collectors.joining(","));
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", expirationDate=" + expirationDate +
                ", accessPlaces='" + getAccessPlaces() + '\'' +
//                ", image=" + Arrays.toString(image) +
                '}';
    }
}
