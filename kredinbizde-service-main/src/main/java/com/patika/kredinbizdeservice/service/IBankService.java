package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;

import java.util.List;
import java.util.Optional;

public interface IBankService {

    Bank save(Bank bank);

    List<Bank> getAll();

    Optional<Bank> findByName(String name);

    Bank update(String name, Bank bank);

    void delete(Bank bank);
}