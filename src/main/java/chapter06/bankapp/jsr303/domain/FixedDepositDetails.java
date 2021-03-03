package chapter06.bankapp.jsr303.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class FixedDepositDetails {
    @NotNull
    private long id;

    @Min(1000)
    @Max(500000)
    private float depositAmount;

    @Min(6)
    private int tenure;

    @NotBlank
    @Size(min = 5, max = 100)
    private String email;
}
