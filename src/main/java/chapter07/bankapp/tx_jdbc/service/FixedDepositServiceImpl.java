package chapter07.bankapp.tx_jdbc.service;

import chapter07.bankapp.jdbc.dao.BankAccountDao;
import chapter07.bankapp.jdbc.dao.FixedDepositDao;
import chapter07.bankapp.jdbc.domain.FixedDepositDetails;
import chapter07.bankapp.jdbc.service.FixedDepositService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@Log4j
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private FixedDepositDao fixedDepositDao;

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public int createFixedDeposit(final FixedDepositDetails fdd) throws Exception {
        transactionTemplate.execute(new TransactionCallback<FixedDepositDetails>() {
            @Override
            public FixedDepositDetails doInTransaction(TransactionStatus status) {
                try {
                    fixedDepositDao.createFixedDeposit(fdd);
                    bankAccountDao.subtractFromAccount(fdd.getBankAccountId(), fdd.getFdAmount());
                } catch (Exception e) {
                    status.setRollbackOnly();
                    log.error(e.getMessage());
                }
                return fdd;
            }
        });
        return fdd.getFixedDepositId();
    }

    @Override
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        return fixedDepositDao.getFixedDeposit(fixedDepositId);
    }
}
