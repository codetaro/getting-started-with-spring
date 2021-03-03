package chapter06.bankapp.configuration;


import chapter06.bankapp.annotations.dao.*;
import chapter06.bankapp.annotations.domain.CustomerRegistrationDetails;
import chapter06.bankapp.annotations.service.*;
import chapter06.bankapp.configuration.beanpostprocessor.BeanNamePrinterBeanFactoryPostProcessor;
import chapter06.bankapp.configuration.beanpostprocessor.ExampleBeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BankAppConfiguration {

    @Bean
    public AccountStatementService accountStatementService() {
        return new AccountStatementServiceImpl();
    }

    @Bean
    public AccountStatementDao accountStatementDao() {
        return new AccountStatementDaoImpl();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CustomerRegistrationService customerRegistrationService() {
        return new CustomerRegistrationServiceImpl();
    }

    @Bean
    public CustomerRegistrationDao customerRegistrationDao() {
        return new CustomerRegistrationDaoImpl();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CustomerRegistrationDetails customerRegistrationDetails() {
        return new CustomerRegistrationDetails();
    }

    @Bean
    public FixedDepositService fixedDepositService() {
        return new FixedDepositServiceImpl();
    }

    @Bean(name = "myFixedDepositDao")
    public FixedDepositDao fixedDepositDao() {
        return new FixedDepositDaoImpl();
    }

    @Bean
    public ExampleBeanPostProcessor exampleBeanPostProcessor() {
        return new ExampleBeanPostProcessor();
    }

    @Bean
    public static BeanNamePrinterBeanFactoryPostProcessor beanNamePrinterBeanFactoryPostProcessor() {
        return new BeanNamePrinterBeanFactoryPostProcessor();
    }
}
