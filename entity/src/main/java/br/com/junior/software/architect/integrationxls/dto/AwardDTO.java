package br.com.junior.software.architect.integrationxls.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AwardDTO implements IAward {

    private String producer;
    private Integer previewWin;
    private Integer followingWin;
    private Integer intervalWin;

}
