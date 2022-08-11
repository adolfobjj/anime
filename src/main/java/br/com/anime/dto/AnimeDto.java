package br.com.anime.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimeDto {

    private String name;
    private String author;
    private String yearPublication;
    private String episodesNumber;
    private String genreType;
    private String synopsis;

}

