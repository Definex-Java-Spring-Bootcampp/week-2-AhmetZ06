package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.enums.ApplicationType;
import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.ApplicationService;
import com.patika.kredinbizdeservice.service.BankService;
import com.patika.kredinbizdeservice.service.CampaignService;
import com.patika.kredinbizdeservice.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankService bankService;
    private CreditCardService creditCardService;
    private CampaignService campaignService;

    @GetMapping("/{bankName}/credit-cards")
    public ResponseEntity<List<CreditCard>> getBankCreditCards(@PathVariable String bankName) {
        Bank bank = bankService.findByName(bankName)
                .orElseThrow(() -> new RuntimeException("Bank not found"));
        List<CreditCard> creditCards = bank.getCreditCards();
        return ResponseEntity.ok(creditCards);//kampanyalar zaten kredi kartlarinin icinde bulunuyor
    }

}