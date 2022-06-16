package com.ad.mgr.data.generator.service.person;

import java.util.List;

import static com.ad.mgr.data.generator.service.person.EmployeeDataHelper.getMenNames;
import static com.ad.mgr.data.generator.service.person.EmployeeDataHelper.getMenSurnames;

public class Men extends Person{
    @Override
    protected List<String> getNameList() {
        return getMenNames();
    }

    @Override
    protected List<String> getSurnameList() {
        return getMenSurnames();
    }
}
