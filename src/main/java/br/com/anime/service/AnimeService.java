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

    public Anime salvar(Anime anime){
        return animeRepository.save(anime);
    }
    public List<Anime> listaAnime(){
        return animeRepository.findAll();
    }
    public Optional<Anime> buscarPorId(Long id){
        return animeRepository.findById(id);
    }
    public void removerPorId(Long id){
        animeRepository.deleteById(id);
    }
}
