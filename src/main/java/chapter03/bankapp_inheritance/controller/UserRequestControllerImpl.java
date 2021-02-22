package chapter03.bankapp_inheritance.controller;

import chapter03.bankapp_inheritance.base.ServiceTemplate;
import chapter03.bankapp_inheritance.domain.Request;

public class UserRequestControllerImpl implements UserRequestController {
    private ServiceTemplate serviceTemplate;

    public void setServiceTemplate(ServiceTemplate serviceTemplate) {
        this.serviceTemplate = serviceTemplate;
    }

    @Override
    public void submitRequest(Request request) {
        serviceTemplate.getJmsMessageSender();
    }
}
