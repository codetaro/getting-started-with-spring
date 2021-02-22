package chapter03.bankapp_constructor.base;

import chapter03.bankapp_inheritance.base.EmailMessageSender;
import chapter03.bankapp_inheritance.base.JmsMessageSender;
import chapter03.bankapp_inheritance.base.WebServiceInvoker;
import org.apache.log4j.Logger;

import java.beans.ConstructorProperties;

public class ServiceTemplate {
    private static Logger logger = Logger.getLogger(ServiceTemplate.class);

    private JmsMessageSender jmsMessageSender;
    private EmailMessageSender emailMessageSender;
    private WebServiceInvoker webServiceInvoker;

//    @ConstructorProperties({"jmsMessageSender", "emailMessageSender", "webServiceInvoker"})
    public ServiceTemplate(JmsMessageSender jmsMessageSender,
                           EmailMessageSender emailMessageSender,
                           WebServiceInvoker webServiceInvoker) {
        this.jmsMessageSender = jmsMessageSender;
        this.emailMessageSender = emailMessageSender;
        this.webServiceInvoker = webServiceInvoker;

        logger.info("Invoked bankapp_constructor: ServiceTemplate(JmsMessageSender, "
                + "EmailMessageSender, "
                + "WebServiceInvoker)");
    }

    public JmsMessageSender getJmsMessageSender() {
        return jmsMessageSender;
    }

    public void setJmsMessageSender(JmsMessageSender jmsMessageSender) {
        this.jmsMessageSender = jmsMessageSender;
    }

    public EmailMessageSender getEmailMessageSender() {
        return emailMessageSender;
    }

    public void setEmailMessageSender(EmailMessageSender emailMessageSender) {
        this.emailMessageSender = emailMessageSender;
    }

    public WebServiceInvoker getWebServiceInvoker() {
        return webServiceInvoker;
    }

    public void setWebServiceInvoker(WebServiceInvoker webServiceInvoker) {
        this.webServiceInvoker = webServiceInvoker;
    }
}
