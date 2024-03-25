package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankRepository {

    private final List<Bank> bankList = new ArrayList<>();

    public Bank save(Bank bank) {
        bankList.add(bank);
        return bank;
    }

    public List<Bank> getAll() {
        return new ArrayList<>(bankList);
    }

    public Optional<Bank> findByName(String name) {
        return bankList.stream()
                .filter(bank -> bank.getName().equals(name))
                .findFirst();
    }

    public void delete(Bank bank) {
        bankList.remove(bank);
    }

}
