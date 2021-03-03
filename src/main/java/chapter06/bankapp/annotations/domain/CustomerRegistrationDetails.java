package chapter06.bankapp.annotations.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "customerRegistrationDetails")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Log4j
public class CustomerRegistrationDetails {
    @Getter @Setter private String accountNumber;
    @Setter private String address;
    @Setter private String cardNumber;

    public CustomerRegistrationDetails() {
        log.info("Created CustomerRegistrationDetails instance");
    }
}
