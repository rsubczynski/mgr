package com.ad.mgr.data.employee.dto;

import java.time.LocalDate;

public record CreateEmployeeDto(
        String firstName,
        String secondName,
        String surname,
        LocalDate dateOfBirth,
        String position,
        LocalDate endContract,
        long cardId) {
}
