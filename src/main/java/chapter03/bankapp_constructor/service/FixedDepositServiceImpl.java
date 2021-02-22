package chapter03.bankapp_constructor.service;

import chapter01.bankapp.FixedDepositDetails;
import chapter02.bankapp_interfaces.dao.FixedDepositDao;
import chapter02.bankapp_interfaces.service.FixedDepositService;
import chapter03.bankapp_constructor.base.ServiceTemplate;
import chapter03.bankapp_inheritance.base.EmailMessageSender;
import chapter03.bankapp_inheritance.base.JmsMessageSender;
import chapter03.bankapp_inheritance.base.WebServiceInvoker;
import org.apache.log4j.Logger;

import java.beans.ConstructorProperties;

public class FixedDepositServiceImpl extends ServiceTemplate implements FixedDepositService {
    private static Logger logger = Logger.getLogger(FixedDepositServiceImpl.class);

    private FixedDepositDao fixedDepositDao;

//    @ConstructorProperties({"jmsMessageSender", "emailMessageSender", "webServiceInvoker"})
    public FixedDepositServiceImpl(JmsMessageSender jmsMessageSender,
            EmailMessageSender emailMessageSender,
            WebServiceInvoker webServiceInvoker)
    {
        super(jmsMessageSender, emailMessageSender, webServiceInvoker);
    }

    @Override
    public FixedDepositDao getFixedDepositDao() {
        return fixedDepositDao;
    }

    public void setFixedDepositDao(FixedDepositDao fixedDepositDao) {
        logger.info("Setting fixedDepositDao property");
        this.fixedDepositDao = fixedDepositDao;
    }

    @Override
    public FixedDepositDetails getFixedDepositDetails(long id) {
        return fixedDepositDao.getFixedDepositDetails(id);
    }

    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        return fixedDepositDao.createFixedDeposit(fdd);
    }
}
