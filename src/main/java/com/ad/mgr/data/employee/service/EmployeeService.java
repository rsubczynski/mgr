package com.ad.mgr.data.employee.service;

import com.ad.mgr.data.employee.dto.CreateEmployeeDto;
import com.ad.mgr.data.employee.dto.UpdateCardIdDto;
import com.ad.mgr.data.employee.dto.UpdateEmployeeDto;
import com.ad.mgr.data.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {

    List<Employee> getAllEmployee();

    List<String> getHeaderList();

    Employee findById(Long employeeId);

    Employee createNewEmployee(CreateEmployeeDto createEmployeeDto);

    void deleteEmployeeById(Long employeeId);

    Employee updateEmployee(UpdateEmployeeDto updateEmployeeDto);

    Employee updateCardId(UpdateCardIdDto updateCardIdDto);
}
