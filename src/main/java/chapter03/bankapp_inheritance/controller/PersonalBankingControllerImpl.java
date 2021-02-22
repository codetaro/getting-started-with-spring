package chapter03.bankapp_inheritance.controller;

import chapter03.bankapp_inheritance.domain.BankStatement;
import chapter03.bankapp_inheritance.service.PersonalBankingService;

public class PersonalBankingControllerImpl implements PersonalBankingController {

    private PersonalBankingService personalBankingService;

    public void setPersonalBankingService(PersonalBankingService personalBankingService) {
        this.personalBankingService = personalBankingService;
    }

    @Override
    public BankStatement getMiniStatement() {
        return personalBankingService.getMiniStatement();
    }
}
