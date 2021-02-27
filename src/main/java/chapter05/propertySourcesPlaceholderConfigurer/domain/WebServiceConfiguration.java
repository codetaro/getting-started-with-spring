package chapter05.propertySourcesPlaceholderConfigurer.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class WebServiceConfiguration {
    @Getter @Setter private String webServiceUrl;
}
