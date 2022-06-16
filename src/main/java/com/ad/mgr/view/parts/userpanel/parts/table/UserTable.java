package com.ad.mgr.view.parts.userpanel.parts.table;


import com.ad.mgr.data.employee.entity.Employee;
import com.ad.mgr.view.parts.userpanel.config.UserPanelConfig;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.*;

import static com.ad.mgr.view.util.DataPickerHelper.convertToLocalDate;
import static com.ad.mgr.view.util.DataPickerHelper.getDatePicker;

public class UserTable extends JPanel {
    private final JTextField nameField = new JTextField();
    private final JTextField secondNameField = new JTextField();
    private final JTextField surnameField = new JTextField();
    private final JTextField positionField = new JTextField();
    private JDatePickerImpl dateOfBirthPicker;
    private JDatePickerImpl dateOfEndPicker;
    private final Employee employee;

    public UserTable(UserPanelConfig userPanelConfig, Employee employee) {
        var gridLayout = new GridLayout(6, 2);
        this.employee = employee;
        gridLayout.setHgap(25);
        gridLayout.setVgap(10);
        setLayout(gridLayout);
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        setDataToFields(userPanelConfig, this.employee);

        add(new JLabel("Imię"));
        add(nameField);

        add(new JLabel("Drugie Imię"));
        add(secondNameField);

        add(new JLabel("Nazwisko"));
        add(surnameField);

        add(new JLabel("Data urodzin"));
        add(dateOfBirthPicker);

        add(new JLabel("Stanowisko"));
        add(positionField);

        add(new JLabel("Data konca umowy"));
        add(dateOfEndPicker);
    }

    private void setDataToFields(UserPanelConfig userPanelConfig, Employee employee) {
        dateOfBirthPicker = getDatePicker(!userPanelConfig.isAddMode(), employee.getDateOfBirth());
        dateOfEndPicker = getDatePicker(!userPanelConfig.isAddMode(), employee.getEndContract());
        nameField.setText(employee.getFirstName());
        secondNameField.setText(employee.getSecondName());
        surnameField.setText(employee.getSurname());
        positionField.setText(employee.getPosition());
    }

    public Employee getEmployee() {
        employee.setDateOfBirth(convertToLocalDate(dateOfBirthPicker));
        employee.setEndContract(convertToLocalDate(dateOfEndPicker));
        employee.setFirstName(nameField.getText());
        employee.setSecondName(secondNameField.getText());
        employee.setSurname(surnameField.getText());
        employee.setPosition(positionField.getText());
        return employee;
    }

    public void cleanTable() {
        nameField.setText("");
        secondNameField.setText("");
        surnameField.setText("");
        dateOfBirthPicker.getModel().setSelected(false);
        positionField.setText("");
        dateOfEndPicker.getModel().setSelected(false);
    }
}
