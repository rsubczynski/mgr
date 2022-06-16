package com.ad.mgr.view;

import com.ad.mgr.data.cards.service.CardService;
import com.ad.mgr.data.employee.service.EmployeeService;
import com.ad.mgr.view.parts.cardpanel.CardPanel;
import com.ad.mgr.view.parts.userpanel.UserPanel;
import com.ad.mgr.view.parts.employeelist.EmployeeDataAdapter;
import com.ad.mgr.view.parts.employeelist.EmployeeTable;
import com.ad.mgr.view.parts.homebar.HomeBar;
import com.ad.mgr.view.parts.homebar.HomeBarButtons;
import com.ad.mgr.view.parts.homebar.HomeBarConnector;
import com.ad.mgr.view.parts.userpanel.UserPanelConnector;
import com.ad.mgr.view.parts.userpanel.config.UserPanelConfig;
import com.ad.mgr.view.parts.userpanel.config.UserPanelMode;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

import static com.ad.mgr.view.util.ListUtils.indexExists;
import static com.ad.mgr.view.parts.homebar.HomeBarButtons.HOME;

public class Window extends JPanel implements HomeBarConnector, UserPanelConnector {

    private final  CardService cardService;
    private final EmployeeService employeeService;
    private Long selectedId;
    private EmployeeTable employeeTable;
    private JTabbedPane jtp;
    private JScrollPane employeeListScrollPane;
    private final HomeBar homeBar = new HomeBar(this);
    private final UserPanel userPanel;
    private final CardPanel cardPanel = new CardPanel();

    public Window(EmployeeService employeeService, CardService cardService) {
        this.cardService = cardService;
        this.employeeService = employeeService;
        this.userPanel = new UserPanel(employeeService, this);
        init();
    }

    public static void showFrame(String appName, EmployeeService employeeService, CardService cardService) {
        JPanel panel = new Window(employeeService, cardService);
        panel.setOpaque(true);
        JFrame frame = new JFrame(appName);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void init() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 500));
        employeeTableConfig();
        homeBar.disableButtons();
        jtp = new JTabbedPane();
        jtp.setUI(new BasicTabbedPaneUI(){
            @Override
            protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
                return 0;
            }
        });
        add(homeBar, BorderLayout.BEFORE_FIRST_LINE);
        jtp.addTab("", employeeListScrollPane);
        jtp.addTab("", userPanel);
        jtp.addTab("", cardPanel);
        add(jtp);

    }

    void employeeTableConfig() {
        employeeTable = new EmployeeTable(new EmployeeDataAdapter(employeeService));
        employeeTable.getSelectionModel().addListSelectionListener(e -> {
            var employeeList = employeeService.getAllEmployee();
            if (indexExists(employeeList, employeeTable.getSelectedRow())) {
                selectedId = employeeList.get(employeeTable.getSelectedRow()).getId();
                homeBar.enableButtons();
            }
        });
        employeeListScrollPane = new JScrollPane(employeeTable);
    }

    @Override
    public void homeBarClicked(HomeBarButtons button) {
        jtp.setSelectedIndex(button.getViewNumber());
        switch (button) {
            case HOME -> homeClicked();
            case ADD -> addNewUserClicked();
            case DELETE -> deleteClicked();
            case EDIT -> editUserClicked();
            case CARD -> addCardClicked();
        }
    }

    public void homeClicked() {
        employeeTable.refreshData();
        homeBar.showLeftMenu();
    }

    public void addNewUserClicked() {
       userPanel.setConfig(getUserConfig(UserPanelMode.ADD));
    }

    public void deleteClicked() {
        var employee = employeeService.findById(selectedId);
        if(employee.getCardId() != 0){
            cardService.deleteCard(employee.getCardId());
        }
        employeeService.deleteEmployeeById(selectedId);
        employeeTable.refreshAfterDelete();
    }

    public void editUserClicked() {
        userPanel.setConfig(getUserConfig(UserPanelMode.EDIT));
    }

    public void addCardClicked() {
        //TODO: implement
    }

    private UserPanelConfig getUserConfig(UserPanelMode mode){
        return UserPanelConfig
                .builder()
                .id(selectedId)
                .userPanelMode(mode)
                .build();
    }

    @Override
    public void userAddClicked() {
        homeBarClicked(HOME);
    }
}

