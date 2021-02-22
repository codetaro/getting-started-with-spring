package chapter03.bankapp_constructor.service;

import org.apache.log4j.Logger;

import java.beans.ConstructorProperties;

public class TransferFundsServiceImpl implements TransferFundsService {
    private static Logger logger = Logger.getLogger(TransferFundsServiceImpl.class);

    private String webServiceUrl;
    private boolean active;
    private long timeout;
    private int numberOfRerialAttempts;

    @ConstructorProperties({"webServiceUrl", "active", "timeout", "numberOfRerialAttempts"})
    public TransferFundsServiceImpl(String webServiceUrl, boolean active, long timeout, int numberOfRerialAttempts) {
        this.webServiceUrl = webServiceUrl;
        this.active = active;
        this.timeout = timeout;
        this.numberOfRerialAttempts = numberOfRerialAttempts;

        logger.info("Web Service URL: " + webServiceUrl +
                ", active: " + active +
                ", timeout: " + timeout +
                ", numberOfRetrialAttempts: " + numberOfRerialAttempts);
    }

    @Override
    public void transferFunds() {

    }
}
