package me.ghisiluizgustavo.techchallenge.models;

import javax.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@ToString
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @OneToMany(mappedBy = "pauta")
    private List<Sessao> sessao;

    @OneToMany(mappedBy = "pauta")
    private List<Voto> votos;

}
