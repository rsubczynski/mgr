package com.ad.mgr.data.generator.service.person;

import java.util.List;

import static com.ad.mgr.data.generator.service.person.EmployeeDataHelper.getWomenNames;
import static com.ad.mgr.data.generator.service.person.EmployeeDataHelper.getWomenSurnames;

public class Women extends Person {

    @Override
    protected List<String> getNameList() {
        return getWomenNames();
    }

    @Override
    protected List<String> getSurnameList() {
        return getWomenSurnames();
    }
}
