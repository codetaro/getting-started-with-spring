package chapter05.bankapp.customization.domain;

import lombok.*;

@Data
@AllArgsConstructor
public class FixedDepositDetails {
    private long id;
    private float depositAmount;
    private int tenure;
    private String email;
}

