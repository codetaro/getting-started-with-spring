package chapter09.bankapp.simple_aop.dao;

import chapter09.bankapp.simple_aop.domain.FixedDepositDetails;
import org.springframework.stereotype.Repository;

@Repository(value = "fixedDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {
    @Override
    public int createFixedDeposit(FixedDepositDetails fdd) {
        return 2;
    }

    @Override
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        return new FixedDepositDetails(1, 100, 12, "somedomain@someemail.com");
    }
}
