package chapter02.bankapp_scopes.controller;

import chapter01.bankapp.FixedDepositDetails;
import chapter02.bankapp_interfaces.service.FixedDepositService;
import org.apache.log4j.Logger;

public class FixedDepositControllerImpl implements FixedDepositController {
    private static Logger logger = Logger.getLogger(FixedDepositControllerImpl.class);

    private FixedDepositService fixedDepositService;

    public FixedDepositControllerImpl() {
        logger.info("initializing");
    }

    @Override
    public FixedDepositService getFixedDepositService() {
        return fixedDepositService;
    }

    public void setFixedDepositService(FixedDepositService fixedDepositService) {
        logger.info("Setting fixedDepositService property");
        this.fixedDepositService = fixedDepositService;
    }

    public boolean submit(FixedDepositDetails fixedDepositDetails) {
        return fixedDepositService.createFixedDeposit(fixedDepositDetails);
    }

    public FixedDepositDetails get() {
        return fixedDepositService.getFixedDepositDetails(1L);
    }
}
