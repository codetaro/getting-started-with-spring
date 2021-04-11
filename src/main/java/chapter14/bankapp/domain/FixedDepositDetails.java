package chapter14.bankapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FixedDepositDetails {
    private long id;

    private String customerId;

    private String depositAmount;

    private String tenure;

    private String email;

}
