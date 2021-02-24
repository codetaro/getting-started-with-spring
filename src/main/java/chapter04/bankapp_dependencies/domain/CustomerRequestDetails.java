package chapter04.bankapp_dependencies.domain;

import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.Date;

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
