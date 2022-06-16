package com.ad.mgr.data.employee.service;

import com.ad.mgr.data.employee.dto.CreateEmployeeDto;
import com.ad.mgr.data.employee.dto.UpdateCardIdDto;
import com.ad.mgr.data.employee.dto.UpdateEmployeeDto;
import com.ad.mgr.data.employee.entity.Employee;
import com.ad.mgr.data.employee.ex.EmployeeNotFoundException;
import com.ad.mgr.data.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<String> getHeaderList() {
        return Arrays.asList(
                "Imię", "Drugie imię", "Nazwisko", "Data urodzin", "Stanowisko", "Koniec umowy", "ID karty"
        );
    }

    @Override
    public Employee findById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
    }

    @Override
    public Employee createNewEmployee(CreateEmployeeDto createEmployeeDto) {
        return employeeRepository.save(
                Employee.
                        builder()
                        .firstName(createEmployeeDto.firstName())
                        .secondName(createEmployeeDto.secondName())
                        .surname(createEmployeeDto.surname())
                        .dateOfBirth(createEmployeeDto.dateOfBirth())
                        .endContract(createEmployeeDto.endContract())
                        .position(createEmployeeDto.position())
                        .cardId(createEmployeeDto.cardId())
                        .build()
        );
    }

    @Override
    public Employee updateEmployee(UpdateEmployeeDto updateEmployeeDto) {
        Employee employee = findById(updateEmployeeDto.id());
        employee.setFirstName(updateEmployeeDto.firstName());
        employee.setSecondName(updateEmployeeDto.secondName());
        employee.setSurname(updateEmployeeDto.surname());
        employee.setDateOfBirth(updateEmployeeDto.dateOfBirth());
        employee.setEndContract(updateEmployeeDto.endContract());
        employee.setPosition(updateEmployeeDto.position());
        employee.setCardId(updateEmployeeDto.cardId());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateCardId(UpdateCardIdDto updateCardIdDto) {
        Employee employee = findById(updateCardIdDto.employeeId());
        employee.setCardId(updateCardIdDto.cardId());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(findById(employeeId).getId());
    }
}
