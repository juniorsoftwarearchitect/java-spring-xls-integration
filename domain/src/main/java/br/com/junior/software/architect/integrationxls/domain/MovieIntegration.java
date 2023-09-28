package br.com.junior.software.architect.integrationxls.domain;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieIntegration {

    private final MovieFacade facade;


    @PostConstruct
    public void init() {
        facade.generateEntityMovieByXlsFile();
    }

}
