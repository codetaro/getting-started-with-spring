package chapter04.bankapp_dependencies.domain;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomerRegistrationDetails {
    @Setter private String accountNumber;
    @Setter private String address;
    @Setter private String cardNumber;

    public CustomerRegistrationDetails() {
        log.info("Created CustomerRegistrationDetails instance");
    }
}
