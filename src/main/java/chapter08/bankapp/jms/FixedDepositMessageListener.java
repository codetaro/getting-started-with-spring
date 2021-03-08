package chapter08.bankapp.jms;

import chapter08.bankapp.dao.BankAccountDao;
import chapter08.bankapp.dao.FixedDepositDao;
import chapter08.bankapp.domain.FixedDepositDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class FixedDepositMessageListener implements MessageListener {
    @Autowired
    private FixedDepositDao fixedDepositDao;

    @Autowired
    private BankAccountDao bankAccountDao;

    @Transactional
    public int createFixedDeposit(FixedDepositDetails fdd) {
        bankAccountDao.subtractFromAccount(fdd.getBankAccountId(), fdd.getFdAmount());
        return fixedDepositDao.createFixedDeposit(fdd);
    }

    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        FixedDepositDetails fdd = null;
        try {
            fdd = (FixedDepositDetails) objectMessage.getObject();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        if (fdd != null) {
            createFixedDeposit(fdd);
        }
    }
}
