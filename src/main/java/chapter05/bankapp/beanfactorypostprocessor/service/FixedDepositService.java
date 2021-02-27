package chapter05.bankapp.beanfactorypostprocessor.service;

public interface FixedDepositService {
    void createFixedDeposit(long id, float depositAmount, int tenure, String email) throws Exception;
}
