package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ApplicationRepository {

    private final List<Application> applicationList = new ArrayList<>();
    private final List<Application> LoanApplicationList = new ArrayList<>();

    public void save(Application application) {

        applicationList.removeIf(existingApp -> existingApp.getLocalDateTime().equals(application.getLocalDateTime())
                && existingApp.getUser().equals(application.getUser()));
        applicationList.add(application);
    }

    public void saveloanapplication(Application application) {
        LoanApplicationList.add(application);
    }

    public List<Application> getAll() {
        return new ArrayList<>(applicationList);
    }

    private List<Application> findByUser(User user) {
        return applicationList.stream()
                .filter(application -> application.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public void delete(Application application) {
        applicationList.remove(application);
    }

    // Additional methods can be added as needed
}
