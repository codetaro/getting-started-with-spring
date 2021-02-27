package chapter05.bankapp.beanfactorypostprocessor.dao;

public interface FixedDepositDao {
    boolean createFixedDeposit(long id, float depositAmount, int tenure, String email);
}
