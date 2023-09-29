package br.com.junior.software.architect.integrationxls.domain;

import br.com.junior.software.architect.integrationxls.dto.IAward;
import br.com.junior.software.architect.integrationxls.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {


    @Query(value = "select producer, previewWin, movie_year as followingWin, intervalWin " +
            " from " +
                "( " +
                    "select *, " +
                    "LAG(movie_year) OVER (ORDER BY movie_year) AS previewWin, " +
                    "movie_year - (LAG(movie_year) OVER (ORDER BY movie_year)) AS intervalWin " +
                    "from movie " +
                    "where winner = true " +
                    "order by movie_year" +
                ") " +
            " where previewWin is not null and intervalWin is not null" +
            " order by intervalWin",
    nativeQuery = true)
    List<IAward> getAward();
}
