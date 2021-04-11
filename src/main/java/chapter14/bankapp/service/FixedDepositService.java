package chapter14.bankapp.service;

import chapter14.bankapp.domain.FixedDepositDetails;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface FixedDepositService {

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    List<FixedDepositDetails> getFixedDeposits(String user);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostFilter("hasPermission(filterObject, read) or hasPermission(filterObject, admin)")
    List<FixedDepositDetails> getAllFixedDeposits();

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    void saveFixedDeposit(FixedDepositDetails fixedDepositDetails);

    @PreAuthorize("hasPermission(#fixedDepositId, 'chapter14.bankapp.domain.FixedDepositDetails', read) or "
            + "hasPermission(#fixedDepositId, 'chapter14.bankapp.domain.FixedDepositDetails', admin)")
    FixedDepositDetails getFixedDeposit(int fixedDepositId);

    @PreAuthorize("hasPermission(#fixedDepositId, 'chapter14.bankapp.domain.FixedDepositDetails', delete)")
    void closeFixedDeposit(int fixedDepositId);

    @PreAuthorize("hasPermission(#fixedDepositDetails, write)")
    void editFixedDeposit(FixedDepositDetails fixedDepositDetails);

    @PreAuthorize("hasPermission(#fixedDepositId, 'chapter14.bankapp.domain.FixedDepositDetails', write)")
    void provideAccessToAdmin(int fixedDepositId);
}
