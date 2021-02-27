package chapter05.bankapp.beanpostprocessor.common;

import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyApplicationContext implements ApplicationContextAware {
    @Setter private ApplicationContext applicationContext;

/*
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
*/

    public <T> T getBean(Class<T> klass) {
        return applicationContext.getBean(klass);
    }
}
