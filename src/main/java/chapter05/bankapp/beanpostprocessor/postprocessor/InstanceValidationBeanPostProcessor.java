package chapter05.bankapp.beanpostprocessor.postprocessor;

import chapter05.bankapp.beanpostprocessor.common.InstanceValidator;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

@Log4j
public class InstanceValidationBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Getter @Setter private int order;

    public InstanceValidationBeanPostProcessor() {
        log.info("Created InstanceValidationBeanPostProcessor instance");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("InstanceValidationBeanPostProcessor's postProcessBeforeInitialization method invoked for bean " + beanName + " of type " + bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("InstanceValidationBeanPostProcessor's postProcessAfterInitialization method invoked for bean " + beanName + " of type " + bean.getClass());
        if (bean instanceof InstanceValidator) {
            ((InstanceValidator) bean).validateInstance();
        }
        return bean;
    }
}
