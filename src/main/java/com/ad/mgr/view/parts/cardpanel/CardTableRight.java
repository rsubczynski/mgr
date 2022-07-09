package com.ad.mgr.view.parts.cardpanel;

import com.ad.mgr.data.cards.entity.AccessPlaces;
import com.ad.mgr.data.cards.entity.Card;
import com.ad.mgr.view.parts.cardpanel.parts.checkboxes.CheckboxListCellRenderer;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CardTableRight extends JPanel {

    private final JLabel label = new JLabel("Miejsca dostępu:");

    private JList<String> jList;

    public CardTableRight() {
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        setLayout(null);
        listConfig();
        addControls();
        setBounds();
    }

    private void listConfig() {
        var accessPlacesAsArray =
                Arrays.stream(AccessPlaces.values())
                        .toList()
                        .stream()
                        .map(AccessPlaces::getLocation)
                        .toArray(String[]::new);

        jList = new JList<>(accessPlacesAsArray);
        jList.setCellRenderer(new CheckboxListCellRenderer());
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    }

    private void addControls() {
        add(label);
        add(jList);
    }

    private void setBounds() {
        label.setBounds(10, 10, 280, 25);
        jList.setBounds(10, 40, 180, 215);
    }

    public void setSelected(Card card) {
        int[] selectedList = Arrays.
                stream(card.getAccessPlaces().stream().map(Enum::ordinal).toArray())
                .mapToInt(o -> (int)o)
                .toArray();
        jList.setSelectedIndices(selectedList);

    }

    public void cleanData() {
        jList.clearSelection();
    }

    public Set<AccessPlaces> getAccessPlaces() {
        return jList.getSelectedValuesList().stream().map(AccessPlaces::fromString).collect(Collectors.toSet());
    }
}

