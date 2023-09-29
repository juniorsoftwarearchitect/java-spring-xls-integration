package br.com.junior.software.architect.integrationxls.domain;

import br.com.junior.software.architect.integrationxls.dto.AwardFormatDTO;
import br.com.junior.software.architect.integrationxls.dto.MovieDTO;

import java.util.List;
import java.util.Map;

public interface MovieFacade {

    List<MovieDTO> getMovies(final Map<String, String> params);

    AwardFormatDTO getAwardFormat();

    void insert(final MovieDTO movieDTO);

    void update(final MovieDTO movieDTO);

    void delete(final Integer id);
}
