package br.com.anime.controller;

import br.com.anime.entity.Anime;
import br.com.anime.service.AnimeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {
   @Autowired
    private AnimeService animeService;
   @Autowired
   private ModelMapper modelMapper;

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public Anime salvar(Anime anime){
       return animeService.salvar(anime);
   }
   @GetMapping
   @ResponseStatus(HttpStatus.OK
   )
   public List<Anime> listaAnime(){
       return animeService.listaAnime();
   }

   @GetMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public Anime buscarAnimePorId(@PathVariable("id") Long id){
       return animeService.buscarPorId(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime não encontrado."));
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void removerAnime(@PathVariable("id")Long id){
       animeService.buscarPorId(id)
               .map(anime -> {
                   animeService.removerPorId(anime.getId());
                   return Void.TYPE;
               }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime não encontrado."));
   }
   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void atualizarAnime(@PathVariable("id") Long id , @RequestBody Anime anime){
       animeService.buscarPorId(id)
               .map(animeBase -> {
                   modelMapper.map(anime,animeBase);
                   return Void.TYPE;

               }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime não encontrado."));
   }

}
