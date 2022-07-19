package br.com.anime.controller;

import br.com.anime.entity.Anime;
import br.com.anime.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AnimeController {
   @Autowired
    private AnimeService animeService;

    @GetMapping("/")
    public List<Anime> getAnimes() {
        List<Anime> animes= animeService.retrieveAnimes();
        return animes;
    }

    @GetMapping("/{id}")
    public Anime getAnime(@PathVariable(name="id")Long animeId) {

        return animeService.getAnime(animeId);
    }


    @PostMapping("/")
    public void saveAnime(Anime anime){
        animeService.saveAnime(anime);
        System.out.println("Anime Saved Successfully");
    }

    @DeleteMapping("/{id}")
    public void deleteAnime(@PathVariable(name="id")Long animeId){
        animeService.deleteAnime(animeId);
        System.out.println("Anime Deleted Successfully");
    }

    @PutMapping("/{id}")
    public void updateAnime(@RequestBody Anime anime,
                               @PathVariable(name="animeId")Long animeId){
        Anime ani = animeService.getAnime(animeId);
        if(ani != null){
           animeService.updateAnime(anime);
        }

    }

}
