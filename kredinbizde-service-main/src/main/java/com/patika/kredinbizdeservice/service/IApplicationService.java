package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;

import java.util.List;

public interface IApplicationService {
    Application save(Application application);

    Application saveloanapplication(Application application);

    List<Application> findAll();
    List<Application> findByUserEmail(String email);
    Application update(Application application);
    void delete(Application application);
}
