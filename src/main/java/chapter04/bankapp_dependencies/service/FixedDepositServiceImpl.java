package chapter04.bankapp_dependencies.service;

import chapter04.bankapp_dependencies.Constants;
import chapter04.bankapp_dependencies.dao.FixedDepositDao;
import chapter04.bankapp_dependencies.domain.FixedDepositDetails;
import chapter04.bankapp_dependencies.event.EventSender;
import chapter04.bankapp_dependencies.event.FixedDepositCreatedEvent;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Log4j
public class FixedDepositServiceImpl implements FixedDepositService {

    @Setter private FixedDepositDao fixedDepositDao;
    private EventSender eventSender;

    public FixedDepositServiceImpl(String configFile) throws Exception {
        ClassPathResource configProperties = new ClassPathResource(configFile);

        if (configProperties.exists()) {
            InputStream inStream = configProperties.getInputStream();
            Properties properties = new Properties();
            properties.load(inStream);
            String eventSenderClassString = properties
                    .getProperty(Constants.EVENT_SENDER_CLASS_PROPERTY);

            if (eventSenderClassString != null) {
                Class<?> eventSenderClass = Class.forName(eventSenderClassString);
                eventSender = (EventSender) eventSenderClass.newInstance();
                log.info("Created EventSender class");

            } else {
                log.info("appConfig.properties file doesn't contain the information about EventSender class");
            }
        }
    }

    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        fixedDepositDao.createFixedDeposit(fdd);

        FixedDepositCreatedEvent event = new FixedDepositCreatedEvent();
        Map<String, Object> eventData = new HashMap<>();
        eventData.put("amount", fdd.getDepositAmount());
        event.setEventData(eventData);

        if (eventSender != null) {
            eventSender.sendEvent(event);
        }
    }
}
