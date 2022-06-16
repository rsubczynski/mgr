package com.ad.mgr.view.parts.employeelist;

import javax.swing.*;

public class EmployeeTable extends JTable {

    private final EmployeeDataAdapter adapter;

    public EmployeeTable(EmployeeDataAdapter adapter){
        super(adapter);
        this.setFillsViewportHeight(true);
        this.setRowSelectionAllowed(true);
        this.setColumnSelectionAllowed(false);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.adapter = adapter;
    }
    public void refreshData(){
        adapter.refreshData();
        repaint();
    }

    public void refreshAfterDelete(){
        refreshData();
        getSelectionModel().clearSelection();
    }
}
