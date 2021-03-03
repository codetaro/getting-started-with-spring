package chapter06.bankapp.configuration.beanpostprocessor;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

@Log4j
public class BeanNamePrinterBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public BeanNamePrinterBeanFactoryPostProcessor() {
        log.info("Created BeanNamePrinterBeanFactoryPostProcessor instance");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanName = beanDefinitionNames[i];
            log.info("Found bean named: " + beanName);
        }
    }
}
