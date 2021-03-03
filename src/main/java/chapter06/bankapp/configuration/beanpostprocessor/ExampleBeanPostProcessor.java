package chapter06.bankapp.configuration.beanpostprocessor;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Log4j
public class ExampleBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("ExampleBeanPostProcessor's postProcessBeforeInitialization method invoked for bean "
                + beanName + " of type " + bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("ExampleBeanPostProcessor's postProcessAfterInitialization method invoked for bean "
                + beanName + " of type " + bean.getClass());
        return bean;
    }
}
