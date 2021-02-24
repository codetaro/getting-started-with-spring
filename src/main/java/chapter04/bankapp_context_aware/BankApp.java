package chapter04.bankapp_context_aware;

import chapter04.bankapp_dependencies.domain.FixedDepositDetails;
import chapter04.bankapp_dependencies.service.CustomerRegistrationService;
import chapter04.bankapp_dependencies.service.CustomerRequestService;
import chapter04.bankapp_dependencies.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class BankApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter04/bankapp_context_aware/applicationContext.xml");

        FixedDepositService fixedDepositService = (FixedDepositService) context.getBean("service");

        fixedDepositService.createFixedDeposit(new FixedDepositDetails(
                101, 10000, 60, "someemail@somedomain.com"));

        log.info("Beginning with accessing CustomerRequestService");
        CustomerRequestService customerRequestService_1 = context.getBean(CustomerRequestService.class);
        customerRequestService_1.submitRequest(
                "checkBookRequest", "Request to send a 50-leaf check book");
        customerRequestService_1.submitRequest(
                "checkBookRequest", "Request to send a 100-leaf check book");
        customerRequestService_1.submitRequest(
                "checkBookRequest", "Request to send a 150-leaf check book");
        customerRequestService_1.submitRequest(
                "checkBookRequest", "Request to send a 200-leaf check book");
        log.info("Done with accessing CustomerRequestService");
    }
}
