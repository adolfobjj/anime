package br.com.anime.repository;


import br.com.anime.model.AnimeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<AnimeModel, Long> {
}
