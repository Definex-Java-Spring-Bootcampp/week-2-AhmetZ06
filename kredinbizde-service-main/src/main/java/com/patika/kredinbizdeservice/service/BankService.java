package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class BankService implements IBankService {

    private BankRepository BankRepository = new BankRepository();

    @Override
    public Bank save(Bank bank) {
        return BankRepository.save(bank);
    }

    @Override
    public List<Bank> getAll() {
        return BankRepository.getAll();
    }

    @Override
    public Optional<Bank> findByName(String name) {
        return BankRepository.findByName(name);
    }

    @Override
    public Bank update(String name, Bank bank) {
        Optional<Bank> foundBank = findByName(name);

        if (foundBank.isPresent()) {
            Bank updatedBank = foundBank.get();
            updatedBank.setName(bank.getName());
            updatedBank.setLoanList(bank.getLoanList());
            updatedBank.setCreditCards(bank.getCreditCards());
            return BankRepository.save(updatedBank);
        } else {
            throw new RuntimeException("Bank not found");
        }
    }

    @Override
    public void delete(Bank bank) {
        BankRepository.delete(bank);
    }
}
