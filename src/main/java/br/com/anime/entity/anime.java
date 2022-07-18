package br.com.anime.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@Entity
public class anime implements Serializable {
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
