package com.ad.mgr.data.generator.service.person;

import lombok.SneakyThrows;

import java.util.List;

import static com.ad.mgr.data.generator.EmployeeDataHelper.*;


public class Women extends Person {

    @Override
    protected List<String> getNameList() {
        return getWomenNames();
    }

    @Override
    protected List<String> getSurnameList() {
        return getWomenSurnames();
    }

    @SneakyThrows
    protected byte[] getPhoto() {
        return getRandomPhotoFromResources("static/women");
    }
}
