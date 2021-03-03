package chapter06.bankapp.validator_interface.dao;

import chapter06.bankapp.annotations.dao.FixedDepositDao;
import chapter06.bankapp.annotations.domain.FixedDepositDetails;
import org.springframework.stereotype.Repository;

@Repository(value = "myFixedDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {
    @Override
    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        return false;
    }
}
