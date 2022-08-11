package br.com.anime.service;

import br.com.anime.model.AnimeModel;
import br.com.anime.repository.AnimeRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {
    final AnimeRepository animeRepository;
    @Transactional
    public AnimeModel save(AnimeModel animeModel) {
        return animeRepository.save(animeModel);
    }
    public List<AnimeModel> findAll() {
        return animeRepository.findAll();
    }
    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }
    public Optional<AnimeModel> findById(Long id) {
        return animeRepository.findById(id);
    }
    @Transactional
    public void delete(AnimeModel animeModel) {
        animeRepository.delete(animeModel);
    }
}
