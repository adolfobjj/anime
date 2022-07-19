package br.com.anime.service;

import br.com.anime.entity.Anime;
import br.com.anime.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {
    @Autowired
    private AnimeRepository animeRepository;

    public void setAnimeRepository(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> retrieveAnimes() {
        List<Anime> animes = animeRepository.findAll();
        return animes;
    }

    public Anime getAnime(Long animeId) {
        Optional<Anime> optAni = animeRepository.findById(animeId);
        return optAni.get();
    }

    public void saveAnime(Anime anime){
        animeRepository.save(anime);
    }

    public void deleteAnime(Long animeId){
        animeRepository.deleteById(animeId);
    }

    public void updateAnime(Anime anime) {
        animeRepository.save(anime);
    }
}
