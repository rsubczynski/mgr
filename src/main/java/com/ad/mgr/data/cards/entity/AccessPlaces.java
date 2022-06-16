package com.ad.mgr.data.cards.entity;

public enum AccessPlaces {
    NONE(""),
    OFFICE("Biuro"),
    LAB("Laboratorium"),
    BOOKKEEPING("Ksiegowosc"),
    TEST_STATION("Stacja_prob"),
    MANAGEMENT("Zarzad"),
    FABRIC("Fabryka"),
    PAINT_SHOW("Lakiernia");

    private final String location;

     AccessPlaces(String code) {
        this.location = code;
    }

    public String getLocation() {
        return location;
    }

    public static AccessPlaces fromString(String text) {
        for (AccessPlaces b : AccessPlaces.values()) {
            if (b.location.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
