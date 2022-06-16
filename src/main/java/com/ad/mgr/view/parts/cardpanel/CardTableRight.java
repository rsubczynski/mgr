package com.ad.mgr.view.parts.cardpanel;

import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

import static com.ad.mgr.view.util.DataPickerHelper.getDatePicker;

public class CardTableRight extends JPanel {
    private final JTextField cardIdFiled = new JTextField();
    private final JTextField photoFiled = new JTextField();
    private final JTextField accessPlaces = new JTextField();
    private final JTextField photoPreview = new JTextField();
    private JDatePickerImpl expirationDatePicker;
//    private final Card card;

    public CardTableRight() {
        var gridLayout = new GridLayout(5, 2);
        setLayout(gridLayout);
        setBorder(BorderFactory.createEmptyBorder(40, 1, 40, 10));

        setDataToFields();

        add(new JLabel("Id Karty"));
        add(cardIdFiled);

        add(new JLabel("Data ważnosci"));
        add(expirationDatePicker);

        add(new JLabel("Miejsca dostępu"));
        add(accessPlaces);

        add(new JLabel("Picture"));
        add(photoFiled);

        add(new JLabel("Podgląd zdjęcia"));
        add(photoPreview);

    }

    private void setDataToFields() {
        expirationDatePicker = getDatePicker(true, LocalDate.now());
//        cardIdFiled.setText(card.getId());
//        photoFiled.setText(employee.getSecondName());
//        accessPlaces.setText(employee.getSurname());
//        photoPreview.setText(employee.getPosition());
    }


    public void cleanTable() {
        cardIdFiled.setText("");
        photoFiled.setText("");
        accessPlaces.setText("");
        expirationDatePicker.getModel().setSelected(false);
        photoPreview.setText("");
    }

}

