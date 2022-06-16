package com.ad.mgr.view.parts.homebar;

public enum HomeBarButtons {
    HOME(0), ADD(1), EDIT(1), DELETE(0), CARD(2);

    private final int viewNumber;

    HomeBarButtons(final int viewNumber) {
        this.viewNumber = viewNumber;
    }

    public int getViewNumber() {
        return viewNumber;
    }
}
