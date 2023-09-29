package br.com.junior.software.architect.integrationxls.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter @Setter
@Accessors(chain = true)
public class AwardFormatDTO {

    private List<AwardDTO> min;

    private List<AwardDTO> max;
}
