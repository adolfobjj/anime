package br.com.anime.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
public class AnimeModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "Author", nullable = false)
    private String author;
    @Column(name = "yearPublication", nullable = false)
    private String yearPublication;
    @Column(name = "episodesNumber", nullable = false)
    private String episodesNumber;
    @Column(name = "genreType", nullable = false)
    private String genreType;
    @Column(name = "synopsis", nullable = false)
    private String synopsis;

}
