package br.com.junior.software.architect.integrationxls.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter @Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO implements Serializable {


    private Integer id;
    private Integer movieYear;
    private String title;
    private String studios;
    private String producer;
    private Boolean winner;
}