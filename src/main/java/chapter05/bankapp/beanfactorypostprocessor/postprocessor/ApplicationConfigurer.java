package chapter05.bankapp.beanfactorypostprocessor.postprocessor;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.RuntimeBeanReference;

@Log4j
public class ApplicationConfigurer implements BeanFactoryPostProcessor {

    public ApplicationConfigurer() {
        log.info("Created ApplicationConfigurer instance");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanName = beanDefinitionNames[i];
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            beanDefinition.setAutowireCandidate(false);

            if (beanDefinition.isSingleton()) {
                if (hasPrototypeDependency(beanFactory, beanDefinition)) {
                    log.error("Singleton-scoped " + beanName
                            + " bean is dependent on a prototype-scoped bean.");
                }
            }
        }
    }

    private boolean hasPrototypeDependency(
            ConfigurableListableBeanFactory beanFactory,
            BeanDefinition beanDefinition) {
        boolean isPrototype = false;
        MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
        PropertyValue[] propertyValues = mutablePropertyValues.getPropertyValues();
        for (int j = 0; j < propertyValues.length; j++) {
            if (propertyValues[j].getValue() instanceof RuntimeBeanReference) {
                String dependencyBeanName = ((RuntimeBeanReference) propertyValues[j].getValue()).getBeanName();
                BeanDefinition dependencyBeanDef = beanFactory.getBeanDefinition(dependencyBeanName);
                if (dependencyBeanDef.isPrototype()) {
                    isPrototype = true;
                    break;
                }
            }
        }
        return isPrototype;
    }
}
