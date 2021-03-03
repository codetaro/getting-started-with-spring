package chapter06.bankapp.annotations.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FixedDepositDetails {
    private long id;
    private float depositAmount;
    private int tenure;
    private String email;
}
