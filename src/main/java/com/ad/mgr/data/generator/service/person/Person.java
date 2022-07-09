package com.ad.mgr.data.generator.service.person;

import com.ad.mgr.data.cards.dto.CreateCardDto;
import com.ad.mgr.data.employee.dto.CreateEmployeeDto;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.ad.mgr.data.generator.EmployeeDataHelper.*;
import static com.ad.mgr.data.generator.EmployeeDataHelper.getRandomElementFromList;


@Getter
public abstract class Person {

    private final String name;
    private final String secondName;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final LocalDate endOfContract;
    private final String position;

    Person() {
        this.name = generateName();
        this.secondName = generateSecondName();
        this.surname = generateSurname();
        this.dateOfBirth = generateDateOfBirth();
        this.position = generatePosition();
        this.endOfContract = generateDateOfContract();
    }

    private String generateName() {
        return getRandomElementFromList(getNameList());
    }

    private String generateSecondName() {
        var secondName = "";
        do {
            secondName = getRandomElementFromList(getNameList());
        } while (secondName.equals(this.name));
        return generateRandomBoolean() ? secondName : "";
    }

    private String generateSurname() {
        return getRandomElementFromList(getSurnameList());
    }

    private LocalDate generateDateOfBirth() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2000, 1, 1).toEpochDay();
        return generatorLocalDataTime(minDay, maxDay);
    }

    private String generatePosition() {
        return getRandomElementFromList(getPositions());
    }

    private LocalDate generateDateOfContract() {
        long minDay = LocalDate.now().toEpochDay();
        long maxDay = LocalDate.of(2030, 12, 31).toEpochDay();
        return generatorLocalDataTime(minDay, maxDay);
    }

    private LocalDate generateExpirationDate() {
        long minDay = LocalDate.now().minusDays(5).toEpochDay();
        long maxDay = endOfContract.toEpochDay();
        return generatorLocalDataTime(minDay, maxDay);
    }

    protected abstract List<String> getNameList();

    protected abstract List<String> getSurnameList();

    protected abstract byte[] getPhoto();

    private LocalDate generatorLocalDataTime(Long minDay, Long maxDay) {
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public CreateCardDto getCardForEmployee(){
        return new CreateCardDto(
                getAccessPlaces(),
                generateExpirationDate(),
                getPhoto()
        );
    }

    public CreateEmployeeDto getAsCreateEmployeeDto(long cardId){
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
