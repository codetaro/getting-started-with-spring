package chapter11.bankapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FixedDepositDetails {
    private long id;

    @Min(1000)
    @Max(500000)
    private long depositAmount;

    @NotNull
    private Date maturityDate;

    @Email
    @Size(min = 10, max = 25)
    private String email;
}
