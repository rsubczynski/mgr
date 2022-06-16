package com.ad.mgr.data.generator.service.person;

import com.ad.mgr.data.employee.dto.CreateEmployeeDto;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.ad.mgr.data.generator.service.person.EmployeeDataHelper.*;

@Getter
public abstract class Person {

    private final String name;
    private final String secondName;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final LocalDate endOfContract;
    private final String position;
    private final Long cardId;

    Person() {
        this.name = generateName();
        this.secondName = generateSecondName();
        this.surname = generateSurname();
        this.dateOfBirth = generateDateOfBirth();
        this.position = generatePosition();
        this.endOfContract = generateOfContract();
        this.cardId = 0L;
    }

    private String generateName() {
        return generateRandomString(getNameList());
    }

    private String generateSecondName() {
        var secondName = "";
        do {
            secondName = generateRandomString(getNameList());
        } while (secondName.equals(this.name));
        return generateRandomBoolean() ? secondName : "";
    }

    private String generateSurname() {
        return generateRandomString(getSurnameList());
    }

    private LocalDate generateDateOfBirth() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2000, 1, 1).toEpochDay();
        return generatorLocalDataTime(minDay, maxDay);
    }

    private String generatePosition() {
        return generateRandomString(getPositions());
    }

    private LocalDate generateOfContract() {
        long minDay = LocalDate.now().toEpochDay();
        long maxDay = LocalDate.of(2030, 12, 31).toEpochDay();
        return generatorLocalDataTime(minDay, maxDay);
    }

    protected abstract List<String> getNameList();

    protected abstract List<String> getSurnameList();

    private LocalDate generatorLocalDataTime(Long minDay, Long maxDay) {
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public CreateEmployeeDto getAsCreateEmployeeDto(){
        return new CreateEmployeeDto(
                name,
                secondName,
                surname,
                dateOfBirth,
                position,
                endOfContract,
                cardId
        );
    }

}
