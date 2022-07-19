package br.com.anime.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@Entity
public class Anime implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nomeAnime", nullable = false)
    private String nomeAnime;
    @Column(name = "nomeAutor", nullable = false)
    private String nomeAutor;
    @Column(name = "publicacaoAnime", nullable = false)
    private String publicacaoAnime;
    @Column(name = "episodioAnime", nullable = false)
    private int episodioAnime;
    @Column(name = "generoAnime", nullable = false)
    private String generoAnime;
    @Column(name = "sinopseAnime", nullable = false)
    private String sinopseAnime;
}
