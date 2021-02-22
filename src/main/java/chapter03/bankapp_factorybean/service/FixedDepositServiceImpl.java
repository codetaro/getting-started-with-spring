package chapter03.bankapp_factorybean.service;

import chapter01.bankapp.FixedDepositDetails;
import chapter03.bankapp_factorybean.dao.FixedDepositDao;
import chapter03.bankapp_factorybean.event.Event;
import chapter03.bankapp_factorybean.event.EventSender;
import chapter03.bankapp_factorybean.event.FixedDepositCreatedEvent;

import java.util.HashMap;
import java.util.Map;

public class FixedDepositServiceImpl implements FixedDepositService {
    private FixedDepositDao fixedDepositDao;
    private EventSender eventSender;

    public void setFixedDepositDao(FixedDepositDao fixedDepositDao) {
        this.fixedDepositDao = fixedDepositDao;
    }

    public void setEventSender(EventSender eventSender) {
        this.eventSender = eventSender;
    }

    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) {
        fixedDepositDao.createFixedDeposit(fdd);

        FixedDepositCreatedEvent event = new FixedDepositCreatedEvent();
        Map<String, Object> eventData = new HashMap<>();
        eventData.put("amount", fdd.getDepositAmount());
        event.setEventData(eventData);

        eventSender.sendEvent(event);
    }
}
