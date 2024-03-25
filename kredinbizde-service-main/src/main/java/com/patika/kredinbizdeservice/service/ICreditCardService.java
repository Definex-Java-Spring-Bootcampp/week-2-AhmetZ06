package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.model.Bank;

import java.util.List;
import java.util.Optional;

public interface ICreditCardService {

    CreditCard save(CreditCard creditCard);

    List<CreditCard> getAll();

    Optional<CreditCard> findById(Long id);

    List<CreditCard> findByBank(Bank bank);

    void delete(CreditCard creditCard);
}