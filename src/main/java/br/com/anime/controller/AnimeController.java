package br.com.anime.controller;

import br.com.anime.dto.AnimeDto;
import br.com.anime.model.AnimeModel;
import br.com.anime.service.AnimeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AnimeController {
   @Autowired
    final AnimeService animeService;
    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }
    @PostMapping("/save")
    public ResponseEntity<Object> saveAnimeModel(@RequestBody @Valid AnimeDto animeDto){
        var animeModel = new AnimeModel();
        BeanUtils.copyProperties(animeDto, animeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(animeService.save(animeModel));
    }
    @GetMapping("/")
    public ResponseEntity<List<AnimeModel>> getAllAnimes() {
        return ResponseEntity.status(HttpStatus.OK).body(animeService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAnimeModel(@PathVariable(value="id")Long id) {
        Optional<AnimeModel> animeModelOptional = animeService.findById(id);
        if(!animeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Anime not found."));
        }
        return  ResponseEntity.status(HttpStatus.OK).body(animeModelOptional.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAnimeModel(@PathVariable(value="id")Long id) {
        Optional<AnimeModel> animeModelOptional = animeService.findById(id);
        if(!animeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Anime not found."));
        }
        animeService.delete(animeModelOptional.get());
        return  ResponseEntity.status(HttpStatus.OK).body("Anime deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAnimeModel(@PathVariable(value="id")Long id,
                                                   @RequestBody @Valid AnimeDto animeDto) {
        Optional<AnimeModel> animeModelOptional = animeService.findById(id);
        if(!animeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Anime not found."));
        }
        var animeModel = animeModelOptional.get();
        // outro jeito de fazer
//        BeanUtils.copyProperties(animeDto ,animeModel);
//        animeModel.setId(animeModelOptional.get()).getId();
//        return  ResponseEntity.status(HttpStatus.OK).body(animeService.save(animeModel));

        animeModel.setAuthor(animeDto.getAuthor());
        animeModel.setEpisodesNumber(animeDto.getEpisodesNumber());
        animeModel.setGenreType(animeDto.getGenreType());
        animeModel.setName(animeDto.getName());
        animeModel.setSynopsis(animeDto.getSynopsis());
        animeModel.setYearPublication(animeDto.getYearPublication());
        return ResponseEntity.status(HttpStatus.OK).body(animeService.save(animeModel));
    }




}
