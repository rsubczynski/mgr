package com.ad.mgr.data.employee.ex;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id){
        super(String.format("Employee not found by id = %d", id));
    }
}
