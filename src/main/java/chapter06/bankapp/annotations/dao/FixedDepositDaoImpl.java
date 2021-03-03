package chapter06.bankapp.annotations.dao;

import chapter06.bankapp.annotations.domain.FixedDepositDetails;
import org.springframework.stereotype.Repository;

@Repository(value = "myFixedDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {
    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        return true;
    }
}
