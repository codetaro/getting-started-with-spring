package chapter12.webservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FixedDepositDetails {

    private long id;
    private String depositAmount;
    private String tenure;
    private String email;

}
