package chapter12.webservice.dao;

import chapter12.webservice.domain.FixedDepositDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class FixedDepositDaoImpl implements FixedDepositDao {
    private List<FixedDepositDetails> fdList;

    public FixedDepositDaoImpl() {
        fdList = new ArrayList<>();
        fdList.add(new FixedDepositDetails(
                1, "10000", "24", "a1email@somedomain.com"));
        fdList.add(new FixedDepositDetails(
                2, "20000", "36", "a2email@somedomain.com"));
        fdList.add(new FixedDepositDetails(
                3, "30000", "36", "a3email@somedomain.com"));
        fdList.add(new FixedDepositDetails(
                4, "50000", "36", "a4email@somedomain.com"));
        fdList.add(new FixedDepositDetails(
                5, "15000", "36", "a5email@somedomain.com"));
    }

    @Override
    public List<FixedDepositDetails> getFixedDeposits() {
        return fdList;
    }

    @Override
    public void saveFixedDeposit(FixedDepositDetails fixedDepositDetails) {
        Random random = new Random();
        long id = random.nextInt();
        fixedDepositDetails.setId(id);
        fdList.add(fixedDepositDetails);
    }

    @Override
    public void closeFixedDeposit(int fixedDepositId) {
        for (FixedDepositDetails fixedDepositDetails : fdList) {
            if (fixedDepositDetails.getId() == fixedDepositId) {
                fdList.remove(fixedDepositDetails);
                break;
            }
        }
    }

    @Override
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        FixedDepositDetails matchingFixedDepositDetails = null;
        for (FixedDepositDetails fixedDepositDetails : fdList) {
            if (fixedDepositDetails.getId() == fixedDepositId) {
                matchingFixedDepositDetails = fixedDepositDetails;
                break;
            }
        }
        return matchingFixedDepositDetails;
    }

    @Override
    public void editFixedDeposit(FixedDepositDetails modifiedFixedDepositDetails) {
        for (FixedDepositDetails fixedDepositDetails : fdList) {
            if (fixedDepositDetails.getId() == modifiedFixedDepositDetails.getId()) {
                fdList.remove(fixedDepositDetails);
                break;
            }
        }
        fdList.add(modifiedFixedDepositDetails);
    }
}
