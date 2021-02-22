package chapter03.bankapp_inheritance.controller;

import chapter02.bankapp_interfaces.controller.FixedDepositControllerImpl;

public class ControllerFactory {
    public Object getController(String controllerName) {
        Object controller = null;
        if ("fixedDepositController".equalsIgnoreCase(controllerName)) {
            controller = new FixedDepositControllerImpl();
        }
        if ("personalBankingController".equalsIgnoreCase(controllerName)) {
            controller = new PersonalBankingControllerImpl();
        }
        return controller;
    }
}
