package br.com.anime.controller;

import br.com.anime.entity.Anime;
import br.com.anime.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {
   @Autowired
    private AnimeService animeService;

    @GetMapping("/anime")
    public List<Anime> getAnimes() {
        List<Anime> animes= animeService.retrieveAnimes();
        return animes;
    }

    @GetMapping("/anime/{id}")
    public Anime getAnime(@PathVariable(name="animeId")Long animeId) {

        return animeService.getAnime(animeId);
    }


    @PostMapping("/anime")
    public void saveAnime(Anime anime){
        animeService.saveAnime(anime);
        System.out.println("Anime Saved Successfully");
    }

    @DeleteMapping("/anime/{id}")
    public void deleteAnime(@PathVariable(name="animeId")Long animeId){
        animeService.deleteAnime(animeId);
        System.out.println("Anime Deleted Successfully");
    }

    @PutMapping("/anime/{id}")
    public void updateAnime(@RequestBody Anime anime,
                               @PathVariable(name="animeId")Long animeId){
        Anime ani = animeService.getAnime(animeId);
        if(ani != null){
           animeService.updateAnime(anime);
        }

    }

}
