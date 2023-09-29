package br.com.junior.software.architect.integrationxls.controller;

import br.com.junior.software.architect.integrationxls.domain.MovieFacade;
import br.com.junior.software.architect.integrationxls.dto.AwardFormatDTO;
import br.com.junior.software.architect.integrationxls.dto.MovieDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/movies", produces = "application/json")
public class MovieController {

    private final MovieFacade movieFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Validated @RequestBody MovieDTO movieDTO){
        movieFacade.insert(movieDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@Validated @RequestBody MovieDTO movieDTO){
        movieFacade.update(movieDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@RequestParam Integer id){
        movieFacade.delete(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> getMovie(@RequestParam final Map<String, String> params) {
        return movieFacade.getMovies(params);
    }

    @GetMapping("/awards")
    @ResponseStatus(HttpStatus.OK)
    public AwardFormatDTO getAwards(@RequestParam final Map<String, String> params) {
        return movieFacade.getAwardFormat();
    }
}
