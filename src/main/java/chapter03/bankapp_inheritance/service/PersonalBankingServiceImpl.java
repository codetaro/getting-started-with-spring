package chapter03.bankapp_inheritance.service;

import chapter03.bankapp_inheritance.base.ServiceTemplate;
import chapter03.bankapp_inheritance.dao.PersonalBankingDao;
import chapter03.bankapp_inheritance.domain.BankStatement;

public class PersonalBankingServiceImpl extends ServiceTemplate implements PersonalBankingService {

    private PersonalBankingDao personalBankingDao;

    public void setPersonalBankingDao(PersonalBankingDao personalBankingDao) {
        this.personalBankingDao = personalBankingDao;
    }

    @Override
    public BankStatement getMiniStatement() {
        return personalBankingDao.getMiniStatement();
    }
}
