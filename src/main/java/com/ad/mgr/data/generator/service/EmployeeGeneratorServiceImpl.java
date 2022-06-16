package com.ad.mgr.data.generator.service;

import com.ad.mgr.data.employee.dto.CreateEmployeeDto;
import com.ad.mgr.data.employee.service.EmployeeService;
import com.ad.mgr.data.generator.service.person.Men;
import com.ad.mgr.data.generator.service.person.Person;
import com.ad.mgr.data.generator.service.person.Women;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.ad.mgr.data.generator.service.person.EmployeeDataHelper.generateRandomBoolean;

@Service
public class EmployeeGeneratorServiceImpl implements EmployeeGeneratorService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void generateEmployeeWithCardIdAs0(int count) {
         IntStream.range(0, count)
                .mapToObj(i -> getCandidates())
                .map(Person::getAsCreateEmployeeDto)
                .forEach(employeeService::createNewEmployee);
    }

    private Person getCandidates() {
        return generateRandomBoolean() ? new Men() : new Women();
    }

}
