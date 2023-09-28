package br.com.junior.software.architect.integrationxls.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ConfigurationProperties("junior")
public class XlsProperties {

    private String integration;

}
