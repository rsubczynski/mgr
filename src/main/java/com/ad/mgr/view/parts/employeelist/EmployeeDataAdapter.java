package com.ad.mgr.view.parts.employeelist;

import com.ad.mgr.data.employee.entity.Employee;
import com.ad.mgr.data.employee.service.EmployeeService;

import javax.swing.table.AbstractTableModel;
public class EmployeeDataAdapter extends AbstractTableModel {
    private final EmployeeService employeeService;
    private Object[][] data = new Object[][]{};
    private final String[] columns;

    public EmployeeDataAdapter(EmployeeService employeeService) {
        this.columns = employeeService.getHeaderList().toArray(new String[0]);
        this.employeeService = employeeService;
        refreshData();
    }

    public void refreshData() {
        data = employeeService.getAllEmployee().stream()
                .map(Employee::toArray)
                .toArray(Object[][]::new);
    }

    @Override
    public int getRowCount() {
        return data.length;
    }
    @Override
    public int getColumnCount() {
        return columns.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return data[0][columnIndex].getClass();
    }
}
