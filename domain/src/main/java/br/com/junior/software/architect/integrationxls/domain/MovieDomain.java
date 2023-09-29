package br.com.junior.software.architect.integrationxls.domain;

import br.com.junior.software.architect.integrationxls.dto.AwardDTO;
import br.com.junior.software.architect.integrationxls.dto.AwardFormatDTO;
import br.com.junior.software.architect.integrationxls.dto.MovieDTO;
import br.com.junior.software.architect.integrationxls.entity.Movie;
import com.github.dozermapper.core.Mapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieDomain implements MovieFacade {

    /** DAO  persistence context */
    @PersistenceContext
    private EntityManager entityManager;

    private final MovieRepository repository;
    private final Mapper mapper;

    @Override
    public List<MovieDTO> getMovies(final Map<String, String> params) {
        return repository.findAll().stream()
                .map(movie -> mapper.map(movie, MovieDTO.class) )
                .collect(Collectors.toList());
    }


    @Override
    public AwardFormatDTO getAwardFormat() {
        final List<AwardDTO> award = repository.getAward().stream()
                .map(iAward -> mapper.map(iAward, AwardDTO.class))
                .collect(Collectors.toList());
        return new AwardFormatDTO()
                .setMin(Arrays.asList(award.get(0), award.get(1)))
                .setMax(Arrays.asList(award.get(award.size()-2), award.get(award.size()-1)));

    }

    @Override
    public void insert(final MovieDTO movieDTO) {
        final var movie = mapper.map(movieDTO, Movie.class);
        repository.saveAndFlush(movie);
    }

    @Override
    public void update(final MovieDTO movieDTO) {
        final var movie = findMovieById(movieDTO.getId());
        mapper.map(movieDTO, movie);
        repository.saveAndFlush(movie);
    }

    private Movie findMovieById(final Integer id) {
        Optional<Movie> movieOptional = repository.findById(id);
        if (movieOptional.isEmpty())
            throw new EntityNotFoundException();
        return movieOptional.get();
    }

    @Override
    public void delete(final Integer id) {
        final var movie = findMovieById(id);
        repository.delete(movie);
    }

}
