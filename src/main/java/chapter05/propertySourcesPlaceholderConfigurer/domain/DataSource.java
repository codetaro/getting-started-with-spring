package chapter05.propertySourcesPlaceholderConfigurer.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DataSource {
    @Getter @Setter private String url;
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private String driverClass;
}
