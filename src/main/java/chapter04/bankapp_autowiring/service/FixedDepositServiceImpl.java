package chapter04.bankapp_autowiring.service;

import chapter04.bankapp_dependencies.dao.FixedDepositDao;
import chapter04.bankapp_dependencies.domain.FixedDepositDetails;
import chapter04.bankapp_dependencies.service.FixedDepositService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class FixedDepositServiceImpl implements FixedDepositService {
    @Setter private FixedDepositDao myFixedDepositDao;

    @Override
    public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
        myFixedDepositDao.createFixedDeposit(fdd);
    }
}
