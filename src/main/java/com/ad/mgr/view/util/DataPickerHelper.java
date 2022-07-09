package com.ad.mgr.view.util;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

public class DataPickerHelper {
    public static JDatePickerImpl getDatePicker(boolean isEditMode, LocalDate localDate) {
        Properties p = new Properties();
        p.put("text.today", "Dzisiaj");
        p.put("text.month", "Miesiąć");
        p.put("text.year", "Rok");
        UtilDateModel model = new UtilDateModel(convertToDateViaInstant(isEditMode ? localDate : LocalDate.now()));
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePanel.getModel().setSelected(isEditMode);
        return new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }

    public static LocalDate convertToLocalDate(JDatePickerImpl dateToConvert) {
        if (!dateToConvert.getModel().isSelected()) {
            return null;
        }
        return LocalDate.of(
                dateToConvert.getModel().getYear(),
                dateToConvert.getModel().getMonth(),
                dateToConvert.getModel().getDay());
    }

    public static LocalDate convertToLocalDateCard(JDatePickerImpl dateToConvert) {
        if (!dateToConvert.getModel().isSelected()) {
            return null;
        }
        return LocalDate.of(
                dateToConvert.getModel().getYear(),
                dateToConvert.getModel().getMonth() + 1,
                dateToConvert.getModel().getDay());
    }

    private static Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
