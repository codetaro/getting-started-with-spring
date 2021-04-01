package chapter13.bankapp.domain;

import chapter13.bankapp.formatter.AmountFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FixedDepositDetails {

    private long id; //-- id value is set by the system

    @AmountFormat
    private long depositAmount;
    private String tenure;
    private String email;
}
