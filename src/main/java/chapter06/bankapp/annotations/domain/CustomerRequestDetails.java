package chapter06.bankapp.annotations.domain;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value = "customerRequestDetails")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Log4j
@Data
public class CustomerRequestDetails {
    private String type;
    private String description;
    private String category;
    private String assignedDepartment;
    private Date submissionDate;
    private String status;
    private String resolutionTimeInDays;

    public CustomerRequestDetails() {
        log.info("Created CustomerRequestDetails instance");
    }
}
