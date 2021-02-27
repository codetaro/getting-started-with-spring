package chapter05.bankapp.beanpostprocessor.factory;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

@Log4j
public class EventSenderFactoryBean implements FactoryBean<EventSender>, InitializingBean {

    public EventSenderFactoryBean() {
        log.info("Created EventSenderFactoryBean");
    }

    @Override
    public EventSender getObject() throws Exception {
        log.info("getObject method of EventSenderFactoryBean invoked");
        return new EventSender();
    }

    @Override
    public Class<?> getObjectType() {
        return EventSender.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet method of EventSenderFactoryBean invoked");
    }
}
