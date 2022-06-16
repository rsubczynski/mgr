package com.ad.mgr.view.parts.homebar;

import javax.swing.*;
import java.awt.*;

import static com.ad.mgr.view.parts.homebar.HomeBarButtons.*;


public class HomeBar extends JPanel {

    private final JButton home = new JButton("Home");
    private final JButton add = new JButton("Add");
    private final JButton delete = new JButton("Delete");
    private final JButton edit = new JButton("Edit");
    private final JButton card = new JButton("Card");
    private final JPanel leftMenu = new JPanel();

    public HomeBar(HomeBarConnector homeBarConnector) {
        leftMenu.add(add);
        leftMenu.add(delete);
        leftMenu.add(edit);
        leftMenu.add(card);

        setLayout(new BorderLayout());
        this.add(home, BorderLayout.WEST);
        this.add(leftMenu, BorderLayout.EAST);


        home.addActionListener(event -> {
            showLeftMenu();
            homeBarConnector.homeBarClicked(HOME);
        });

        add.addActionListener(e -> {
            hideLeftMenu();
            homeBarConnector.homeBarClicked(ADD);
        });

        delete.addActionListener(event -> {
            disableButtons();
            homeBarConnector.homeBarClicked(DELETE);
        });

        edit.addActionListener(event -> {
            hideLeftMenu();
            homeBarConnector.homeBarClicked(EDIT);
        });

        card.addActionListener(event -> {
            hideLeftMenu();
            homeBarConnector.homeBarClicked(CARD);
        });
    }

    public void disableButtons() {
        setEnableButtons(false);
    }

    public void enableButtons() {
        setEnableButtons(true);
    }

    private void setEnableButtons(boolean enableButtons) {
        delete.setEnabled(enableButtons);
        edit.setEnabled(enableButtons);
        card.setEnabled(enableButtons);
    }

    void hideLeftMenu() {
        leftMenu.setVisible(false);
    }

    public void showLeftMenu() {
        leftMenu.setVisible(true);
    }
}

