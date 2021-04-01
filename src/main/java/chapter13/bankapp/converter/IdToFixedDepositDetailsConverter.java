package chapter13.bankapp.converter;

import chapter13.bankapp.domain.FixedDepositDetails;
import chapter13.bankapp.service.FixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class IdToFixedDepositDetailsConverter implements
        Converter<String, FixedDepositDetails> {

    @Autowired
    private FixedDepositService fixedDepositService;

    @Override
    public FixedDepositDetails convert(String source) {
        return fixedDepositService.getFixedDeposit(Integer.parseInt(source));
    }
}
