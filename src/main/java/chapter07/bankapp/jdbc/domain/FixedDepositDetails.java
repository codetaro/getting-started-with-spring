package chapter07.bankapp.jdbc.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "FixedDepositDetails")
@Table(name = "fixed_deposit_details")
@Data
public class FixedDepositDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fixed_deposit_id")
    private int fixedDepositId;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    private BankAccountDetails bankAccountDetails;

    @Transient
    private int bankAccountId;

    @Column(name = "fd_creation_date")
    private Date fdCreationDate;

    @Column(name = "amount")
    private int fdAmount;

    @Column(name = "tenure")
    private int tenure;

    @Column(name = "active")
    private String active;
}
