package chapter08.bankapp.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FixedDepositDetails implements Serializable {
    private static final long serialVersionUID = -8363144927181713477L;
    private int fixedDepositId;
    private int bankAccountId;
    private Date fdCreationDate;
    private int fdAmount;
    private int tenure;
    private String active;
    private String email;
}
