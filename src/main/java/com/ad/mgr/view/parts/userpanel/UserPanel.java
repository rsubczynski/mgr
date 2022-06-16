package com.ad.mgr.view.parts.userpanel;

import com.ad.mgr.data.employee.dto.CreateEmployeeDto;
import com.ad.mgr.data.employee.dto.UpdateEmployeeDto;
import com.ad.mgr.data.employee.entity.Employee;
import com.ad.mgr.data.employee.service.EmployeeService;
import com.ad.mgr.view.parts.userpanel.parts.buttons.UserButtons;
import com.ad.mgr.view.parts.userpanel.parts.buttons.UserButtonsConnector;
import com.ad.mgr.view.parts.userpanel.parts.table.UserTable;
import com.ad.mgr.view.parts.userpanel.parts.title.UserPanelTitle;
import com.ad.mgr.view.parts.userpanel.config.UserPanelConfig;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel implements UserButtonsConnector {

    private final EmployeeService employeeService;
    private UserTable formPanel;
    private JLabel title;
    private JPanel buttons;
    private UserPanelConfig userPanelConfig;

    private final UserPanelConnector userPanelConnector;

    public UserPanel(EmployeeService employeeService, UserPanelConnector userPanelConnector) {
        this.employeeService = employeeService;
        this.userPanelConnector = userPanelConnector;
    }

    public void setConfig(UserPanelConfig userPanelConfig) {
        this.userPanelConfig = userPanelConfig;
        setView();
    }

    private void setView() {
        Employee employee = userPanelConfig.isAddMode() ?
                new Employee() : employeeService.findById(userPanelConfig.getId());

        title = new UserPanelTitle(userPanelConfig);
        formPanel = new UserTable(userPanelConfig, employee);
        buttons = new UserButtons(this, userPanelConfig);
        removeAll();
        addComponentsToContainer();
        repaint();
    }

    public void addComponentsToContainer() {
        JPanel view = new JPanel();
        view.setLayout(new BorderLayout());
        view.add(title, BorderLayout.BEFORE_FIRST_LINE);
        view.add(formPanel);


        setBorder(BorderFactory.createEmptyBorder(30, 10, 5, 80));
        setLayout(new BorderLayout());
        add(view, BorderLayout.BEFORE_FIRST_LINE);
        add(buttons, BorderLayout.WEST);
    }

    @Override
    public void userActionButtonClicked() {
        Employee employee = formPanel.getEmployee();
        if (isValidEmployee(employee)) {
            if (userPanelConfig.isAddMode()) {
                createEmployee(employee);
            } else {
                updateEmployee(employee);
            }
            userPanelConnector.userAddClicked();
        } else {
            JOptionPane.showMessageDialog(formPanel, "Prosze uzupełnić wszystkie pola");
        }
    }

    private void updateEmployee(Employee employee) {
        employeeService.updateEmployee(new UpdateEmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getSecondName(),
                employee.getSurname(),
                employee.getDateOfBirth(),
                employee.getPosition(),
                employee.getEndContract(),
                employee.getCardId()
        ));
    }

    private void createEmployee(Employee employee) {
        employeeService.createNewEmployee(new CreateEmployeeDto(
                employee.getFirstName(),
                employee.getSecondName(),
                employee.getSurname(),
                employee.getDateOfBirth(),
                employee.getPosition(),
                employee.getEndContract(),
                0L
        ));
    }

    private boolean isValidEmployee(Employee employee) {
        return !employee.getFirstName().isBlank() &&
                !employee.getSecondName().isBlank() &&
                !employee.getSurname().isBlank() &&
                !employee.getPosition().isBlank() &&
                employee.getDateOfBirth() != null &&
                employee.getEndContract() != null;
    }

    @Override
    public void deleteButtonClicked() {
        formPanel.cleanTable();
    }
}
