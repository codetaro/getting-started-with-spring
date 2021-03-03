package chapter06.bankapp.jsr303.dao;

import chapter06.bankapp.jsr303.domain.FixedDepositDetails;
import org.springframework.stereotype.Repository;

@Repository(value = "myFixedDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {

    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        return false;
    }
}
