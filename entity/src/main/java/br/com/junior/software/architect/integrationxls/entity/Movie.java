package br.com.junior.software.architect.integrationxls.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity
@Getter @Setter
@Accessors(chain = true)
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "movie_SEQ", allocationSize = 1)
    private Integer id;

    private Integer movieYear;
    private String title;
    private String studios;
    private String producer;
    private boolean winner;
}
