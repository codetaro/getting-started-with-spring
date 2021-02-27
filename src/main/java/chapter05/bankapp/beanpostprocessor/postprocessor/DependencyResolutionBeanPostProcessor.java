package chapter05.bankapp.beanpostprocessor.postprocessor;

import chapter05.bankapp.beanpostprocessor.common.DependencyResolver;
import chapter05.bankapp.beanpostprocessor.common.MyApplicationContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

@Log4j
public class DependencyResolutionBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Setter private MyApplicationContext myApplicationContext;
    @Getter @Setter private int order;

    public DependencyResolutionBeanPostProcessor() {
        log.info("Created DependencyResolutionBeanPostProcessor instance");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("DependencyResolutionBeanPostProcessor's postProcessBeforeInitialization method invoked for bean " + beanName + " of type " + bean.getClass());
        if (bean instanceof DependencyResolver) {
            ((DependencyResolver) bean).resolveDependency(myApplicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("DependencyResolutionBeanPostProcessor's postProcessAfterInitialization method invoked for bean " + beanName + " of type " + bean.getClass());
        return bean;
    }
}
