package chapter02.bankapp_interfaces.controller;

import chapter01.bankapp.FixedDepositDetails;
import chapter02.bankapp_interfaces.service.FixedDepositService;

public interface FixedDepositController {
    FixedDepositService getFixedDepositService();

    boolean submit();

    FixedDepositDetails get();
}
