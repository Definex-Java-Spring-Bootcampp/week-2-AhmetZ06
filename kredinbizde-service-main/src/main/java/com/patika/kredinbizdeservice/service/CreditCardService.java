package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.CreditCardRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class CreditCardService implements ICreditCardService {

        private CreditCardRepository creditCardRepository = new CreditCardRepository();

        @Override
        public CreditCard save(CreditCard creditCard) {
            return creditCardRepository.save(creditCard);
        }

        @Override
        public List<CreditCard> getAll() {
            return creditCardRepository.getAll();
        }

    @Override
    public Optional<CreditCard> findById(Long id) {
        return Optional.empty();
    }

    @Override
        public List<CreditCard> findByBank(Bank bank) {
            return creditCardRepository.findByBank(bank);
        }

        @Override
        public void delete(CreditCard creditCard) {
            creditCardRepository.delete(creditCard);
        }
    }