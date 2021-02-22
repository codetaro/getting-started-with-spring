package chapter03.bankapp_constructor.service;

import chapter03.bankapp_constructor.base.ServiceTemplate;
import chapter03.bankapp_inheritance.base.EmailMessageSender;
import chapter03.bankapp_inheritance.base.JmsMessageSender;
import chapter03.bankapp_inheritance.base.WebServiceInvoker;
import chapter03.bankapp_inheritance.dao.PersonalBankingDao;
import chapter03.bankapp_inheritance.domain.BankStatement;
import chapter03.bankapp_inheritance.service.PersonalBankingService;

public class PersonalBankingServiceImpl extends ServiceTemplate implements PersonalBankingService {

    private PersonalBankingDao personalBankingDao;

    public PersonalBankingServiceImpl(JmsMessageSender jmsMessageSender,
                                      EmailMessageSender emailMessageSender,
                                      WebServiceInvoker webServiceInvoker) {
        super(jmsMessageSender, emailMessageSender, webServiceInvoker);
    }

    public void setPersonalBankingDao(PersonalBankingDao personalBankingDao) {
        this.personalBankingDao = personalBankingDao;
    }

    @Override
    public BankStatement getMiniStatement() {
        return personalBankingDao.getMiniStatement();
    }
}
