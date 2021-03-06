package chapter07.bankapp.jdbc.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "BankAccountDetails")
@Table(name = "bank_account_details")
@Data
public class BankAccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "balance_amount")
    private int balanceAmount;

    @Column(name = "last_transaction_ts")
    private Date lastTransactionTimestamp;
}
