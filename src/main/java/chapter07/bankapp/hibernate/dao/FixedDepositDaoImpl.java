package chapter07.bankapp.hibernate.dao;

import chapter07.bankapp.jdbc.dao.FixedDepositDao;
import chapter07.bankapp.jdbc.domain.FixedDepositDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository(value = "fixedDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public int createFixedDeposit(final FixedDepositDetails fdd) {
        sessionFactory.getCurrentSession().save(fdd);
        return fdd.getFixedDepositId();
    }

    @Override
    public FixedDepositDetails getFixedDeposit(final int fixedDepositId) {
        String hql =
                "from FixedDepositDetails  as fixedDepositDetails where fixedDepositDetails.fixedDepositId="
                        + fixedDepositId;
        return (FixedDepositDetails) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
    }
}
