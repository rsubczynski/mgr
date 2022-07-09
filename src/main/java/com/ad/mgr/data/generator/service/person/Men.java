package com.ad.mgr.data.generator.service.person;

import lombok.SneakyThrows;

import java.util.List;

import static com.ad.mgr.data.generator.EmployeeDataHelper.*;


public class Men extends Person{
    @Override
    protected List<String> getNameList() {
        return getMenNames();
    }

    @Override
    protected List<String> getSurnameList() {
        return getMenSurnames();
    }

    @SneakyThrows
    protected byte[] getPhoto() {
        return getRandomPhotoFromResources("static/men");
    }
}
