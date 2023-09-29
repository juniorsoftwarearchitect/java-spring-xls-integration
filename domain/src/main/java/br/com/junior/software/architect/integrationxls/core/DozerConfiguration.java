package br.com.junior.software.architect.integrationxls.core;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfiguration {

    /**
     * Bean for mapper external class with configuration of the dozer default
     */
    @Bean
    public Mapper mapper(){
        return DozerBeanMapperBuilder.buildDefault();
    }
}
