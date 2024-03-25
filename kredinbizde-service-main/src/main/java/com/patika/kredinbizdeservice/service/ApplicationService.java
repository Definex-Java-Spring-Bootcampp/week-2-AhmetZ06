package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService implements IApplicationService {

    private ApplicationRepository applicationRepository = new ApplicationRepository();

    @Override
    public Application save(Application application) {
        applicationRepository.save(application);
        return application;
    }

    @Override
    public Application saveloanapplication(Application application) {
        applicationRepository.saveloanapplication(application);
        return application;
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.getAll();
    }

    @Override
    public List<Application> findByUserEmail(String email) {
        return applicationRepository.getAll().stream()
                .filter(app -> app.getUser().getEmail().equals(email))
                .collect(Collectors.toList());
    }

    @Override
    public Application update(Application application) {
        applicationRepository.delete(application);
        applicationRepository.save(application);
        return application;
    }

    @Override
    public void delete(Application application) {
        applicationRepository.delete(application);
    }
}
