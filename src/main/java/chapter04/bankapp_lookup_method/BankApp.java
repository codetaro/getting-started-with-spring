package chapter04.bankapp_lookup_method;

import chapter04.bankapp_dependencies.service.CustomerRequestService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j
public class BankApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter04/bankapp_lookup_method/applicationContext.xml");

        log.info("Beginning with accessing CustomerRequestService");
        CustomerRequestService customerRequestService_1 = context
                .getBean(CustomerRequestService.class);
        customerRequestService_1.submitRequest("checkBookRequest",
                "Request to send a 50-leaf check book");
        customerRequestService_1.submitRequest("checkBookRequest",
                "Request to send a 100-leaf check book");
        log.info("Done with accessing CustomerRequestService");
    }
}
