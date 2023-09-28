package br.com.junior.software.architect.integrationxls.domain;

import br.com.junior.software.architect.integrationxls.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
