package com.ad.mgr.data.cards.entity;

public enum AccessPlaces {
    GATE("Brama"),
    OFFICE("Biuro"),
    LAB("Laboratorium"),
    BOOKKEEPING("Ksiegowosc"),
    FABRIC("Fabryka"),
    TEST_STATION("Stacja_prob"),
    WELDING("Spawalnia"),
    PAINT_SHOW("Lakiernia"),
    MANAGEMENT("Zarzad");

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
