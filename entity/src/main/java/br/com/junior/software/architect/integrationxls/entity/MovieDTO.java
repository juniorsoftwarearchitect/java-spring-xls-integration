package br.com.junior.software.architect.integrationxls.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class MovieDTO implements Serializable {


    private Long id;
    private Integer year;
    private String title;
    private String studios;
    private String producers;
    private String winner;
}