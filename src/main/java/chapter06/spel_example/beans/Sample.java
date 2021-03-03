package chapter06.spel_example.beans;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
public class Sample {
    private String environment;
    private String currency;
    private String country;
    private String state;
}
