package com.ad.mgr.view.parts.cardpanel;

import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

import static com.ad.mgr.view.util.DataPickerHelper.getDatePicker;

public class CardTableLeft extends JPanel {
    private final JTextField cardIdFiled = new JTextField();
    private final JTextField photoFiled = new JTextField();
    private final JTextField accessPlaces = new JTextField();
    private final JTextField photoPreview = new JTextField();
    private JDatePickerImpl expirationDatePicker;
//    private final Card card;

    public CardTableLeft() {
        var gridLayout = new GridLayout(5, 1);
        setLayout(gridLayout);
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        setDataToFields();

        add(new JLabel("Id Karty"));

        add(new JLabel("Data ważnosci"));

        add(new JLabel("Miejsca dostępu"));

        add(new JLabel("Picture"));

        add(new JLabel("Podgląd zdjęcia"));

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

