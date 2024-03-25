package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.model.Bank;
import java.util.ArrayList;
import java.util.List;

public class CreditCardRepository {

    private final List<CreditCard> creditCardList = new ArrayList<>();

    public CreditCard save(CreditCard creditCard) {
        creditCardList.add(creditCard);
        return creditCard;
    }

    public List<CreditCard> getAll() {
        return new ArrayList<>(creditCardList);
    }

    public List<CreditCard> findByBank(Bank bank) {
        return creditCardList.stream()
                .filter(creditCard -> creditCard.getBank().equals(bank))
                .toList();
    }

    public List<CreditCard> listByBank(Bank bank) {
        return creditCardList.stream()
                .filter(creditCard -> creditCard.getBank().equals(bank))
                .toList();
    }


    public void delete(CreditCard creditCard) {
        creditCardList.remove(creditCard);
    }
}
