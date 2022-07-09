package com.ad.mgr.data.generator.service;

import com.ad.mgr.data.cards.service.CardService;
import com.ad.mgr.data.employee.service.EmployeeService;
import com.ad.mgr.data.generator.service.person.Men;
import com.ad.mgr.data.generator.service.person.Person;
import com.ad.mgr.data.generator.service.person.Women;
import com.google.common.collect.Iterators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.ad.mgr.data.generator.EmployeeDataHelper.generateRandomBoolean;

@Service
public class DataGeneratorServiceImpl implements DataGeneratorService {

    private final Logger logger = LoggerFactory.getLogger(DataGeneratorServiceImpl.class);

    private final int PAGE_SIZE = 50;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CardService cardService;

    @Override
    public void generateEmployeeWithCardIdAs0(int count) {
        Iterators.partition(IntStream.range(0, count)
                .mapToObj(i -> getPerson())
                .map(person -> person.getAsCreateEmployeeDto(0L))
                .iterator(), PAGE_SIZE).forEachRemaining(employeeList ->
        {
            employeeList.forEach(employeeService::createNewEmployee);
            logger.info(String.format("Added %d users, with id Card equals 0", employeeList.size()));
        });
    }

    @Override
    public void generateEmployeeWithCards(int count) {
        AtomicInteger counter = new AtomicInteger();
        Iterators.partition(IntStream.range(0, count)
                .mapToObj(i -> {
                    var person = getPerson();
                    var card = cardService.createCard(person.getCardForEmployee());
                    return person.getAsCreateEmployeeDto(card.getId());
                })
                .iterator(), PAGE_SIZE).forEachRemaining(employeeList ->
        {
            employeeList.forEach(employeeService::createNewEmployee);
            logger.info(String.format("Added %d users, with Card", PAGE_SIZE * counter.incrementAndGet()));
        });
    }

    private Person getPerson() {
        return generateRandomBoolean() ? new Men() : new Women();
    }

}
