package chapter08.bankapp.service;

import chapter08.bankapp.dao.FixedDepositDao;
import chapter08.bankapp.domain.FixedDepositDetails;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.*;
import java.util.List;

@Service
@Log4j
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private FixedDepositDao fixedDepositDao;

    @Override
    @Transactional("jmsTxManager")
    @CacheEvict(value = {"fixedDepositList"}, allEntries = true, beforeInvocation = true)
    public void createFixedDeposit(final FixedDepositDetails fdd) throws Exception {
        log.info("createFixedDeposit method invoked");
        jmsTemplate.send("emailQueueDestination", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(fdd.getEmail());
                return textMessage;
            }
        });

        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage();
                objectMessage.setObject(fdd);
                return objectMessage;
            }
        });
    }

    @Override
    @CachePut(value = {"fixedDeposit"}, key = "#fixedDepositId")
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        log.info("getFixedDeposit method invoked with fixedDepositId "
                + fixedDepositId);
        return fixedDepositDao.getFixedDeposit(fixedDepositId);
    }

    @Override
    @Cacheable(value = {"fixedDeposit"}, key = "#fixedDepositId")
    public FixedDepositDetails getFixedDepositFromCache(int fixedDepositId) {
        log.info("getFixedDepositFromCache method invoked with fixedDepositId "
                + fixedDepositId);
        throw new RuntimeException(
                "This method throws exception because FixedDepositDetails object must come from the cache");
    }

    @Override
    @Cacheable(value = {"fixedDepositList"})
    public List<FixedDepositDetails> findFixedDepositsByBankAccount(int bankAccountId) {
        log.info("findFixedDepositsByBankAccount method invoked");
        return fixedDepositDao.findFixedDepositsByBankAccount(bankAccountId);
    }
}
