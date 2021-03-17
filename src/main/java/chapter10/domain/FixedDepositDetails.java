package chapter10.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FixedDepositDetails {
    private long id;
    private String depositAmount;
    private String tenure;
    private String email;
}
