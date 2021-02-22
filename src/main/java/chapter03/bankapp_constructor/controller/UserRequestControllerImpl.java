package chapter03.bankapp_constructor.controller;

import chapter03.bankapp_constructor.base.ServiceTemplate;
import chapter03.bankapp_inheritance.controller.UserRequestController;
import chapter03.bankapp_inheritance.domain.Request;

public class UserRequestControllerImpl implements UserRequestController {
    private ServiceTemplate serviceTemplate;

    public UserRequestControllerImpl(ServiceTemplate serviceTemplate) {
        this.serviceTemplate = serviceTemplate;
    }

    @Override
    public void submitRequest(Request request) {
        serviceTemplate.getJmsMessageSender();
    }
}
