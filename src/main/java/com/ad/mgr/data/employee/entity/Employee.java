package com.ad.mgr.data.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Employee {

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;

    private String secondName;

    private String surname;

    private LocalDate dateOfBirth;

    private String position;

    private LocalDate endContract;

    private long cardId;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", position='" + position + '\'' +
                ", endContract=" + endContract +
                ", cardId=" + cardId +
                '}';
    }

    public Object[] toArray() {
        return new Object[]{firstName, secondName, surname, dateOfBirth, position, endContract, cardId, id};
    }
}
